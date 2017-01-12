package src.inheritance;

/**
 * Created by Z001W4M on 12/8/2016.
 */
public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String fur;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String fur) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.fur = fur;
        System.out.println("The dog constructor called");
    }

    private void chew(){
        System.out.println("The dog chew method called");
    }

    @Override
    public void eat() {
        System.out.println("The dog eat method called");
        this.chew();
        super.eat();
    }

    private void moveLegs(int speed){
        System.out.println("The dog moveLegs method called");
    }

    @Override
    public void move(int speed) {
        moveLegs(speed);
        super.move(speed);
    }

    public void walk(){
        System.out.println("The dog walk method called");
        move(5);
    }
    public void run(){
        System.out.println("The dog run method called");
        move(15);
    }
}
