package service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

import model.Frame;
import model.FrameHeader;
import model.Tag;
import model.TagHeader;

public class TagExtractor
{
    public TagExtractor()
    {
    }

    public Tag getTag(File file) throws IOException
    {
        Tag tag = new Tag();

        byte[] bytes = FileUtils.readFileToByteArray(file);

        if (!this.hasIdTag(bytes)) {
            return null;
        }

        ByteArraySplitter splitter = new ByteArraySplitter(bytes);

        tag.setHeader(this.buildHeader(splitter.getNextRange(10)));

        int size = tag.getHeader().getSize();
        while (splitter.getCurrent() < size) {
            Frame frame = new Frame();

            FrameHeader header = this.buildFrameHeader(splitter.getNextRange(10));
            byte[] value = splitter.getNextRange(header.getSize());

            frame.setHeader(header);
            frame.setValue(value);

            if (frame.getHeader().getSize() > 0) {
                tag.addFrame(frame);
            }
        }

        return tag;
    }

    protected TagHeader buildHeader(byte[] bytes)
    {
        if (bytes.length != 10) {
            throw new RuntimeException(String.format("Invalid header, must contains 10 bytes, only %d bytes found", bytes.length));
        }

        TagHeader header = new TagHeader();

        header.setName(new String(Arrays.copyOf(bytes, 3)));
        header.setVersion(Integer.valueOf(bytes[3]));
        header.setRevision(Integer.valueOf(bytes[4]));

        byte flag = bytes[5];
        header.setUnsynchronisation(this.readBit(flag, 0) == 1);
        header.setExtendedHeader(this.readBit(flag, 1) == 1);
        header.setExperimentalIndicator(this.readBit(flag, 2) == 1);
        header.setFooterPresent(this.readBit(flag, 3) == 1);

        header.setSize(this.computeSize(Arrays.copyOfRange(bytes, 6, 10)));

        return header;
    }

    protected boolean hasIdTag(byte[] bytes)
    {
        byte[] headerBytes = Arrays.copyOf(bytes, 10);

        return headerBytes[0] == 0x49
            && headerBytes[1] == 0x44
            && headerBytes[2] == 0x33
            && headerBytes[3] < 255
            && headerBytes[4] < 255
            // headerBytes[5] ignore flag byte
            && headerBytes[6] < 128
            && headerBytes[7] < 128
            && headerBytes[8] < 128
            && headerBytes[9] < 128
        ;
    }

    protected boolean hasFooter(byte[] bytes, int size)
    {
        byte[] footerBytes = Arrays.copyOfRange(bytes, size + 10, size + 20);

        return
            footerBytes[0] == 0x33
            && footerBytes[1] == 0x44
            && footerBytes[2] == 0x49
            && footerBytes[3] < 255
            && footerBytes[4] < 255
            // headerBytes[5] ignore flag byte
            && footerBytes[6] < 128
            && footerBytes[7] < 128
            && footerBytes[8] < 128
            && footerBytes[9] < 128
        ;
    }

    public FrameHeader buildFrameHeader(byte[] bytes)
    {
        FrameHeader header = new FrameHeader();

        header.setId(new String(Arrays.copyOf(bytes, 4)));

        header.setSize(this.computeSize(Arrays.copyOfRange(bytes, 4, 8)));

        byte statusMessages = bytes[8];
        header.setTagAlterPreservation(this.readBit(statusMessages, 1) == 1);
        header.setFileAlterPreservation(this.readBit(statusMessages, 2) == 1);
        header.setReadOnly(this.readBit(statusMessages, 3) == 1);

        byte formatDescription = bytes[9];
        header.setGroupingIdentity(this.readBit(formatDescription, 1) == 1);
        header.setCompression(this.readBit(formatDescription, 4) == 1);
        header.setEncryption(this.readBit(formatDescription, 5) == 1);
        header.setUnsynchronisation(this.readBit(formatDescription, 6) == 1);
        header.setDataLengthIndicator(this.readBit(formatDescription, 7) == 1);

        return header;
    }

    /**
     * Compute size from bytes : 4 X %0xxx xxxx
     */
    private int computeSize(byte[] bytes)
    {
        return (bytes[0] << 21) | (bytes[1] << 14) | (bytes[2] << 7) | bytes[3];
    }

    /**
     * Read bit with specified position in byte (beginning with MSB left).
     */
    private int readBit(byte value, int position)
    {
        if (position < 0 || position > 7) {
            throw new RuntimeException(String.format("Invalid position to read byte : %d", position));
        }

        return (value >> (7 - position)) & 1;
    }
}
