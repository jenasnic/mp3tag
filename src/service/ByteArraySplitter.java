package service;

import java.util.Arrays;

public class ByteArraySplitter
{
    protected byte[] bytes;
    protected int current = 0;

    public ByteArraySplitter(byte[] bytes)
    {
        this.bytes = bytes;
    }

    public byte[] getNextRange(int size)
    {
        byte[] nextRange = Arrays.copyOfRange(this.bytes, current, current + size);
        this.current += size;

        return nextRange;
    }

    public int getCurrent()
    {
        return this.current;
    }
}
