package src.Section9.LinkedList;

/**
 * Created by Z001W4M on 1/3/2017.
 */
public class Main {

    public static void main(String[] args) {

        Album WhiteAlbum = new Album("White Album");
        WhiteAlbum.addSong(new Song("While my guitar gently weeps", 4.37));
        WhiteAlbum.addSong(new Song("Rocky raccoon", 2.38));
        WhiteAlbum.addSong(new Song("Her majesty", 3.56));

        PlayList myPlayList = new PlayList("John's PlayList");
        myPlayList.addSong(WhiteAlbum.getAlbum().get(0));
        myPlayList.addSong(WhiteAlbum.getAlbum().get(2));
        myPlayList.addSong(WhiteAlbum.getAlbum().get(1));

        myPlayList.listSongs();
        myPlayList.playSongs();



    }

}
