package main;

import java.io.File;

import model.Frame;
import model.Tag;
import service.TagExtractor;

public class MainTest
{
    public static void main(String[] args)
    {
        try {
            TagExtractor te = new TagExtractor();

            File file = new File("/home/jc/Musique/ZZTEST/alpha/My Artist - My song 01.mp3");

            Tag tag = te.getTag(file);

            System.out.println("Tag : " + tag.getHeader().getName());
            System.out.println("Frame count : " + tag.getFrames().size());

            for (Frame frame : tag.getFrames()) {
                System.out.println(" - " + frame.getHeader().getId() + " (" + frame.getValueEncoding() + ")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayByte(byte b)
    {
        System.out.println(String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0'));
    }
}
