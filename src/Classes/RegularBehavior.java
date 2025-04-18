package Classes;


public class RegularBehavior implements UserBehavior{
    private int playingLimit = 5;


    @Override
    public void createPlaylist(String Title, User Owner) {
        try {
            throw new InvalidOperationException("You can't create a playlist as a regular user");
        }
        catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void playMusic(Music music) {
        try {
            if (this.playingLimit > 0) {
                if (Music.getAllMusics().contains(music)) {
                    music.play();
                    this.playingLimit--;
                }
                else {
                    throw new InvalidOperationException("Music is not registered");
                }
            }
            else{
                throw new InvalidOperationException("you can't play more than 5 songs");
            }
        }
        catch (InvalidOperationException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void buyPremium(User owner, int month) {
        PremiumBehavior behavior = new PremiumBehavior(month);
        owner.setBehavior(behavior);
    }
}
