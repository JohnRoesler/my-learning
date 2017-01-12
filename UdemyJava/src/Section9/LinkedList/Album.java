package src.Section9.LinkedList;

import java.util.ArrayList;

/**
 * Created by Z001W4M on 1/3/2017.
 */
public class Album {

    private ArrayList<Song> album;
    private String albumTitle;

    public Album(String albumTitle) {
        this.album = new ArrayList<Song>();
        this.albumTitle = albumTitle;
    }

    public boolean addSong(Song newSong){
        if(findSong(newSong.getTitle()) == null){
            this.album.add(newSong);
            return true;
        }
        return false;
    }



    public ArrayList<Song> getAlbum() {
        return album;
    }


    public String getAlbumTitle() {
        return albumTitle;
    }

    private Song findSong(String title){
        for (Song checkedSong: this.album){
            if (checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

}
