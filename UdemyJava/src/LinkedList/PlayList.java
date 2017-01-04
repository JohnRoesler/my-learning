package src.LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by Z001W4M on 1/3/2017.
 */
public class PlayList {

    private LinkedList<Song> playlist;
    private String playListTitle;

    public PlayList(String playListTitle) {
        this.playlist = new LinkedList<Song>();
        this.playListTitle = playListTitle;
    }

    public void addSong (Song newSong){
        this.playlist.add(newSong);
    }

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }


    public String getPlayListTitle() {
        return playListTitle;
    }

    public void listSongs (){
        ListIterator<Song> songListIterator = this.playlist.listIterator();
        int counter = 0;
        while (songListIterator.hasNext()){
            counter += 1;
            System.out.println("Song #" + counter + ": " + songListIterator.next().toString());
        }
    }

    public void playSongs(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> songListIterator = this.playlist.listIterator();

        if (this.playlist.isEmpty()){
            System.out.println("You must first add songs to the playlist");
            return;
        } else {
            System.out.println("Now playing: " + songListIterator.next().toString());
            this.printMenu();
        }
        while (!quit){
            if (this.playlist.isEmpty()){
                System.out.println("You removed all the songs!\n" +
                        "You must quit and add songs to the playlist");
                quit = true;
                break;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit = true;
                    System.out.println("Playlist stopped");
                    break;
                case 1:
                    if (!goingForward){
                        if (songListIterator.hasNext()){
                            songListIterator.next();
                        }
                        goingForward = true;
                    }
                    if (songListIterator.hasNext()){
                        System.out.println("Now playing: " + songListIterator.next().toString());
                    } else {
                        System.out.println("You reached the end of the playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward){
                        if (!songListIterator.hasPrevious()){
                            System.out.println("You must play the next song in order to replay.");
                            break;
                        }
                        System.out.println("Now replaying: " + songListIterator.previous().toString());
                        songListIterator.next();
                    } else {
                        if (!songListIterator.hasNext()){
                            System.out.println("You must play the previous song in order to replay.");
                            break;
                        }
                        System.out.println("Now replaying: " + songListIterator.next().toString());
                        songListIterator.previous();
                    }
                    break;
                case 3:
                    if (goingForward){
                        if (songListIterator.hasPrevious()){
                            songListIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (songListIterator.hasPrevious()){
                        System.out.println("Now playing: " + songListIterator.previous().toString());
                    } else {
                        System.out.println("You reached the beginning of the playlist");
                        goingForward = true;
                    }
                    break;
                case 4:
                    if (goingForward){
                        if (!songListIterator.hasPrevious()){
                            System.out.println("You must play the next song in order to remove it.");
                            break;
                        }
                        System.out.println("Removed: " + songListIterator.previous().toString());
                        songListIterator.remove();
                    } else {
                        if (!songListIterator.hasNext()){
                            System.out.println("You must play the previous song in order to remove it.");
                            break;
                        }
                        System.out.println("Removed: " + songListIterator.next().toString());
                        songListIterator.remove();
                    }
                    break;
                case 5:
                    listSongs();
                    break;
                case 6:
                    this.printMenu();
                    break;
            }
        }
    }
    private void printMenu(){
        System.out.println("Enter a number:\n" +
                "0 - quit\n" +
                "1 - play next song\n" +
                "2 - replay current song\n" +
                "3 - play previous song\n" +
                "4 - remove current song\n" +
                "5 - list songs in playlist" +
                "6 - print menu again");
    }
}
