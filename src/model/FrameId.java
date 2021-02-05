package model;

public enum FrameId
{
    ALBUM("TALB"),
    GENRE("TCON"),
    ARTIST("TPE1"),
    TITLE("TIT2");

    protected String id;

    FrameId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }
}
