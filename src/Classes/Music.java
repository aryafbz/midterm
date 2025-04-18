package Classes;

import java.io.IOException;
import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStreams;
    private static ArrayList<Music> allMusics = new ArrayList<Music>();


    public Music(String title, User singer) {
        this.setTitle(title);
        this.setSinger(singer);
        this.setNumberOfStreams(0);
        allMusics.add(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSinger(User singer) {
        this.singer = singer;
    }

    public User getSinger() {
        return singer;
    }

    public void setNumberOfStreams(int numberOfStreams) {
        this.numberOfStreams = numberOfStreams;
    }

    public int getNumberOfStreams() {
        return numberOfStreams;
    }

    public void play() {
        this.numberOfStreams++;
        System.out.println("Playing music " + this.getTitle() + " by " + this.getSinger().getUsername());
    }

    public static Music search(String title) {
        for (Music music : allMusics) {
            if (music.getTitle().equalsIgnoreCase(title)) {
                return music;
            }
        }
        return null;
    }

    public static Music search(String title, String singerName) {
        for (Music music : allMusics) {
            if (music.getTitle().equalsIgnoreCase(title) && music.getSinger().getUsername().equalsIgnoreCase(singerName)) {
                return music;
            }
        }
        return null;
    }

    public static ArrayList<Music> getAllMusics() {
        return allMusics;
    }
}
