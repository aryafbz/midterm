package Classes;

import java.util.ArrayList;
import Classes.*;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList = new ArrayList<>() ;
    private ArrayList<User> followingList = new ArrayList<>() ;
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private UserBehavior behavior;
    private static ArrayList<User> allUsers = new ArrayList<>() ;

    public User(String username, String password)throws InvalidOperationException {
        this.setUsername(username);
        this.setPassword(password);
        this.setBehavior(new RegularBehavior());
        allUsers.add(this);
    }

    public void setUsername(String username) throws InvalidOperationException {
        if(username.isEmpty())
            throw new IllegalArgumentException("Username cannot be empty");
        for(User u : allUsers){
            if(u.getUsername().equals(username))
                throw new InvalidOperationException("User " + username + " already exists");
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) throws InvalidOperationException {
        if(password.isEmpty())
            throw new IllegalArgumentException("Password cannot be empty");
        if(password.length() < 8)
            throw new InvalidOperationException("Password must be at least 8 characters");
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }



    public void follow(User u) throws InvalidOperationException {
        if(this.equals(u))
            throw new InvalidOperationException("you can't follow yourself");

        if(!followingList.contains(u)){
            followingList.add(u);
            u.followerList.add(this);
            return;
        }
        throw new InvalidOperationException("User is already a follower");

    }

    public void unfollow(User u) throws InvalidOperationException {
        if(followingList.contains(u)) {
            followingList.remove(u);
            u.followerList.remove(this);
            return;
        }
        throw new InvalidOperationException("User is not in followers");
    }

    public String getFollowingList() {
        String s = this.username + " followings: ";
        for (User u : followingList) {
            s += u.getUsername() + " ";
        }
        return s;
    }

    public String getFollowerList() {
        String s = this.username + " followers: ";
        for(User u : followerList){
            s += u.getUsername() + " ";
        }
        return s;
    }

    protected void addPlaylists(Playlist playlist){
        this.playlists.add(playlist);
    }

    public String getPlaylists() {
        String s = this.username + " playlists: ";
        for (Playlist playlist : playlists) {
            s += playlist.getTitle();
        }
        return s;
    }

    public Playlist getPlaylist(String title) {
        for (Playlist playlist : playlists) {
            if(playlist.getTitle().equals(title))
                return playlist;
        }
        return null;
    }

    public void createPlaylist(String title , User owner){
        this.behavior.createPlaylist(title, owner);
    }

    public void playMusic(Music music) {
        this.behavior.playMusic(music);
    }

    public void buyPremium(User owner , int month){
        this.behavior.buyPremium(owner, month);
    }

}
