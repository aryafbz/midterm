package Classes;

import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private ArrayList<Music> playlist = new ArrayList<>();
    private String title;
    private User owner;

    public Playlist(User owner , String title) {
        this.setOwner(owner);
        this.setTitle(title);
    }


    private void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addMusic(Music music , String password) {
        try {
            if (this.getOwner().getPassword().equals(password)) {
                if (!(this.playlist.contains(music))) {
                    this.playlist.add(music);
                } else {
                    throw new InvalidOperationException("This music has already been added");
                }
            } else {
                throw new InvalidOperationException("Invalid password");
            }
        }catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeMusic(Music music , String password) {
        try {
            if (this.getOwner().getPassword().equals(password)) {
                if (this.playlist.contains(music)) {
                    this.playlist.remove(music);
                }
                else {
                    throw new InvalidOperationException("This music is not in the playlist");
                }
            } else {
                throw new InvalidOperationException("Invalid password");
            }
        }catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editTitle(String title , String password) throws InvalidOperationException {
        if(this.getOwner().getPassword().equals(password)) {
            if(!this.getTitle().equals(title)) {
                this.setTitle(title);
            }
            else {
                throw new InvalidOperationException("Same title");
            }
        }
        else {
            throw new InvalidOperationException("Invalid password");
        }
    }

    public Music searchInPlaylist(String title) {
        for (Music music : this.playlist) {
            if (music.getTitle().equalsIgnoreCase(title)) {
                return music;
            }
        }
        return null;
    }

    public  Music searchInPlaylist(String title, String singerName) {
        for (Music music : this.playlist) {
            if (music.getTitle().equalsIgnoreCase(title) && music.getSinger().getUsername().equalsIgnoreCase(singerName)) {
                return music;
            }
        }
        return null;
    }

    public void playPlaylist() {
        for (Music music : this.playlist) {
            System.out.println("Playing music " + music.getTitle() + " by " + music.getSinger().getUsername());
        }
    }

    public void shufflePlaylist() {
        Collections.shuffle(this.playlist);
        for (Music music : this.playlist) {
            System.out.println("Shuffling music " + music.getTitle() + " by " + music.getSinger().getUsername());
        }
    }
}
