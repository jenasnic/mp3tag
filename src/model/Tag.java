package model;

import java.util.ArrayList;
import java.util.List;

public class Tag
{
    protected TagHeader header;
    protected List<Frame> frames = new ArrayList<Frame>();

    public TagHeader getHeader()
    {
        return header;
    }

    public void setHeader(TagHeader header)
    {
        this.header = header;
    }

    public List<Frame> getFrames()
    {
        return frames;
    }

    public void addFrame(Frame frame)
    {
        this.frames.add(frame);
    }
}
