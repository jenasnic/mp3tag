package model;

public class Frame
{
    protected FrameHeader header;
    protected byte[] value;

    public FrameHeader getHeader()
    {
        return header;
    }

    public void setHeader(FrameHeader header)
    {
        this.header = header;
    }

    public byte[] getValue()
    {
        return this.value;
    }

    public String getValueAsString()
    {
        return new String(this.value);
    }

    public void setValue(byte[] value)
    {
        this.value = value;
    }

    public String getValueEncoding()
    {
        switch ((int)this.value[0]) {
            case 0:
                return "ISO-8859-1";
            case 1:
                return "UTF-16";
            case 2:
                return "UTF-16BE";
            case 3:
                return "UTF-8";
            default:
                return "Unknown";
        }
    }
}
