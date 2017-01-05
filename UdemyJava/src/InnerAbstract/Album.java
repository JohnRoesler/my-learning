package src.InnerAbstract;

import java.util.ArrayList;

/**
 * Created by Z001W4M on 1/3/2017.
 */
public class Album {

    //private ArrayList<Song> album;
    private innerSongList album;
    private String albumTitle;

    public Album(String albumTitle) {
        this.album = new innerSongList();
        this.albumTitle = albumTitle;
    }

    public boolean addSong(Song newSong){
        if(findSong(newSong.getTitle()) == false){
            this.album.addSong(newSong);
            return true;
        }
        return false;
    }

    public ArrayList<Song> getAlbum() {

        return album.getSongs();
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    private boolean findSong(String title){
        return album.findSong(title);
    }

    private class innerSongList{
        private ArrayList<Song> songs;

        public void addSong (Song newSong){
            songs.add(newSong);
        }

        public boolean findSong(String songName){
            if (songs.isEmpty()){
                System.out.println("The album is empty");
                return false;
            }
            for (int i = 0; i < songs.size(); i++){
                if (songs.get(i).getTitle().equals(songName)){
                    return true;
                }
            }
            System.out.println("Song not found on album");
            return false;
        }

        public ArrayList<Song> getSongs() {
            return songs;
        }
    }

}
