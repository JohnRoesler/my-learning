package src.LinkedList;

/**
 * Created by Z001W4M on 1/3/2017.
 */
public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }


    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}
