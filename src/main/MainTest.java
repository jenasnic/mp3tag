package main;

import java.io.File;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

import model.FrameHeader;
import model.TagHeader;
import service.TagExtractor;

public class MainTest
{
    public static void main(String[] args)
    {
        try {
            TagExtractor te = new TagExtractor();

            File file = new File("/home/jc/Musique/ZZTEST/alpha/My Artist - My song 01.mp3");

            byte[] bytes = FileUtils.readFileToByteArray(file);
            byte[] headerBytes = Arrays.copyOf(bytes, 10);

//            System.out.println("has ID : " + te.hasIdTag(bytes));

            TagHeader header = te.buildHeader(headerBytes);

//            System.out.println("Name : " + header.getName());
//            System.out.println("Version : " + header.getVersion());
//            System.out.println("Revision : " + header.getRevision());
//            System.out.println("ExperimentalIndicator : " + header.isExperimentalIndicator());
//            System.out.println("ExtendedHeader : " + header.isExtendedHeader());
//            System.out.println("FooterPresent : " + header.isFooterPresent());
//            System.out.println("Unsynchronisation : " + header.isUnsynchronisation());
//            System.out.println("Size : " + header.getSize());

            System.out.println("has footer : " + te.hasFooter(bytes, header.getSize()));

            FrameHeader frameHeader = te.buildFrameHeader(bytes, 10);
//            System.out.println("ID : " + frameHeader .getId());
//            System.out.println("Size : " + frameHeader .getSize());
//            System.out.println("tagAlterPreservation : " + frameHeader.isTagAlterPreservation());
//            System.out.println("fileAlterPreservation : " + frameHeader.isFileAlterPreservation());
//            System.out.println("readOnly : " + frameHeader.isReadOnly());
//            System.out.println("groupingIdentity : " + frameHeader.isGroupingIdentity());
//            System.out.println("compression : " + frameHeader.isCompression());
//            System.out.println("encryption : " + frameHeader.isEncryption());
//            System.out.println("unsynchronisation : " + frameHeader.isUnsynchronisation());
//            System.out.println("dataLengthIndicator : " + frameHeader.isDataLengthIndicator());

            String album = new String(Arrays.copyOfRange(bytes, 20, 20 + 9));
            System.out.println("album : " + album);
//            FrameHeader frameHeader = te.buildFrameHeader(bytes, 10);
//            System.out.println("ID : " + frameHeader .getId());
//            System.out.println("Size : " + frameHeader .getSize());
//
//            FrameHeader frameHeader = te.buildFrameHeader(bytes, 10);
//            System.out.println("ID : " + frameHeader .getId());
//            System.out.println("Size : " + frameHeader .getSize());
//
//            FrameHeader frameHeader = te.buildFrameHeader(bytes, 10);
//            System.out.println("ID : " + frameHeader .getId());
//            System.out.println("Size : " + frameHeader .getSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
