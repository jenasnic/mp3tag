package model;

public class FrameHeader
{
    protected String id;
    protected int size;

//    protected byte statusMessages;
    protected boolean tagAlterPreservation;
    protected boolean fileAlterPreservation;
    protected boolean readOnly;

//    protected byte formatDescription;
    protected boolean groupingIdentity;
    protected boolean compression;
    protected boolean encryption;
    protected boolean unsynchronisation;
    protected boolean dataLengthIndicator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isTagAlterPreservation() {
        return tagAlterPreservation;
    }

    public void setTagAlterPreservation(boolean tagAlterPreservation) {
        this.tagAlterPreservation = tagAlterPreservation;
    }

    public boolean isFileAlterPreservation() {
        return fileAlterPreservation;
    }

    public void setFileAlterPreservation(boolean fileAlterPreservation) {
        this.fileAlterPreservation = fileAlterPreservation;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isGroupingIdentity() {
        return groupingIdentity;
    }

    public void setGroupingIdentity(boolean groupingIdentity) {
        this.groupingIdentity = groupingIdentity;
    }

    public boolean isCompression() {
        return compression;
    }

    public void setCompression(boolean compression) {
        this.compression = compression;
    }

    public boolean isEncryption() {
        return encryption;
    }

    public void setEncryption(boolean encryption) {
        this.encryption = encryption;
    }

    public boolean isUnsynchronisation() {
        return unsynchronisation;
    }

    public void setUnsynchronisation(boolean unsynchronisation) {
        this.unsynchronisation = unsynchronisation;
    }

    public boolean isDataLengthIndicator() {
        return dataLengthIndicator;
    }

    public void setDataLengthIndicator(boolean dataLengthIndicator) {
        this.dataLengthIndicator = dataLengthIndicator;
    }
}
