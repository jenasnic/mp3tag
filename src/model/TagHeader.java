package model;

public class TagHeader
{
    protected String name;
    protected int version;
    protected int revision;
    protected boolean unsynchronisation;
    protected boolean extendedHeader;
    protected boolean experimentalIndicator;
    protected boolean footerPresent;
    protected int size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public boolean isUnsynchronisation() {
        return unsynchronisation;
    }

    public void setUnsynchronisation(boolean unsynchronisation) {
        this.unsynchronisation = unsynchronisation;
    }

    public boolean isExtendedHeader() {
        return extendedHeader;
    }

    public void setExtendedHeader(boolean extendedHeader) {
        this.extendedHeader = extendedHeader;
    }

    public boolean isExperimentalIndicator() {
        return experimentalIndicator;
    }

    public void setExperimentalIndicator(boolean experimentalIndicator) {
        this.experimentalIndicator = experimentalIndicator;
    }

    public boolean isFooterPresent() {
        return footerPresent;
    }

    public void setFooterPresent(boolean footerPresent) {
        this.footerPresent = footerPresent;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
