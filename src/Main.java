import Classes.InvalidOperationException;
import Classes.Music;
import Classes.Playlist;
import Classes.User;

public class Main {
    public static void main(String[] args) {
        try {
            //خواننده ها و آهنگ هاشون
            User mohsenLorestani = new User("Mohsen Lorestani", "12345678");
            Music bacheNane = new Music("bache nane" , mohsenLorestani);

            User ebi = new User("Ebi", "87654321");
            Music khanomGol = new Music("Khanom Gol" , ebi);
            Music harigheSabz = new Music("Harighe Sabz" , ebi);

            User darioush = new User("Darioush" , "darioush1234");
            Music cheshmMan = new Music("Cheshm Man" , darioush);
            Music soghot = new Music("Soghot" , darioush);
            Music yavarHamisheMomen  = new Music("Yavar Hamise Momen" , darioush);

            //یوزر ها
            User arya = new User("Arya", "13852006");
            User alireza = new User("Alireza", "alireza1384");
            User amir = new User("Amir", "amir1383");

            //متد پلی
            arya.playMusic(bacheNane);
            arya.playMusic(khanomGol);
            arya.playMusic(harigheSabz);
            arya.playMusic(cheshmMan);
            arya.playMusic(soghot);
            arya.playMusic(yavarHamisheMomen); //کاربر عادی نمی تواند بیشتر از 5 بار آهنگ پلی کند
            System.out.println();

            //متد فالو
            arya.follow(alireza);
            arya.follow(amir);
            alireza.follow(amir);
            alireza.follow(arya);
            amir.follow(alireza);
            amir.follow(arya);

            //متد آنفالو
            amir.unfollow(alireza);

            //لیست فالوور ها و فالویینگ ها
            System.out.println(arya.getFollowerList());
            System.out.println(arya.getFollowingList());
            System.out.println(alireza.getFollowerList());
            System.out.println(alireza.getFollowingList());
            System.out.println(amir.getFollowerList());
            System.out.println(amir.getFollowingList());
            System.out.println();

            //ساختن یک پلی لیست برای کاربر عادی
            arya.createPlaylist("arya 's playlist");
            System.out.println();

            //تبدیل کاربر عادی به پریمیوم
            arya.buyPremium(arya , 5);

            //ساخت پلی لیست و تست متد هاش
            arya.createPlaylist("my playlist");
            System.out.println(arya.getPlaylists());

            Playlist p = arya.getPlaylist("my playlist");
            p.editTitle("my playlist 1" , "13852006");//عوض کردن اسم پلی لیست
            System.out.println(arya.getPlaylists());

            p.addMusic(bacheNane , "13852006");
            p.addMusic(yavarHamisheMomen , "13852006");
            p.addMusic(harigheSabz , "13852006");
            p.addMusic(cheshmMan , "13852006");
            p.addMusic(soghot , "12345678");
            System.out.println();

            p.removeMusic(bacheNane , "13852006");
            p.removeMusic(khanomGol , "13852006");//حذف آهنگی که در پلی لیست نیست
            p.removeMusic(harigheSabz , "12345678");//پسورد اشتباه
            System.out.println();

            p.playPlaylist();
            System.out.println();
            p.shufflePlaylist();
            System.out.println();

            Music searchedMusicInPlaylist1 = p.searchInPlaylist("cheshm Man");
            System.out.println(searchedMusicInPlaylist1.getTitle() + " " + searchedMusicInPlaylist1.getSinger().getUsername());
            Music searchedMusicInPlaylist2 = p.searchInPlaylist("yavar hamise momen" , "Darioush");
            System.out.println(searchedMusicInPlaylist2.getTitle() + " " + searchedMusicInPlaylist2.getSinger().getUsername());
            System.out.println();

            //متد های سرچ
            Music searchedMusic1 = Music.search("khanom gol");
            System.out.println(searchedMusic1.getTitle() + " " + searchedMusic1.getSinger().getUsername());
            Music searchedMusic3 = Music.search("Yavar Hamise Momen" , "Darioush");
            System.out.println(searchedMusic3.getTitle() + " " + searchedMusic3.getSinger().getUsername());

        }
        catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
