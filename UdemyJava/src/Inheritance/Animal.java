package src.inheritance;

/**
 * Created by Z001W4M on 12/8/2016.
 */
public class Animal {
    private String name;
    private int brain;
    private int body;
    private int size;
    private int weight;

    public Animal(String name, int brain, int body, int size, int weight) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
        System.out.println("The animal constructor called");
    }

    public void eat(){
        System.out.println("The animal eat method called");
    }

    public void move(int speed){
        System.out.println("Animal is moving at " + speed);
    }

    public String getName() {
        return name;
    }

    public int getBrain() {
        return brain;
    }

    public int getBody() {
        return body;
    }

    public int getSize() {
        return size;
    }

    public int getWeitht() {
        return weight;
    }
}
