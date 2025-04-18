package Classes;

public class PremiumBehavior implements UserBehavior {
    private int month;

    public PremiumBehavior(int month) {
        this.month = month;
    }


    @Override
    public void createPlaylist(String Title, User Owner) {
        Playlist playlist = new Playlist(Owner , Title);
        Owner.addPlaylists(playlist);
    }

    @Override
    public void playMusic(Music music) {
        try{
            if(Music.getAllMusics().contains(music)){
                music.play();
                return;
            }
            throw new InvalidOperationException("Music is not registered");
        }
        catch(InvalidOperationException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void buyPremium(User owner, int month) {
        this.month = this.month + month;
    }
}
