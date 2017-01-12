package src.Section8.Polymorphism;

/**
 * Created by Z001W4M on 12/13/2016.
 */
public class BMW extends Car{
    public BMW(int cylinders, String name) {
        super(cylinders, name, "BMW");
    }

    @Override
    public void accelerate(int speed) {
        super.accelerate(speed);
        System.out.println(this.getMake());
    }

    @Override
    public void brake() {
        this.setSpeed(0);
        System.out.println("The " + this.getMake() + " has come to a stop");
    }
}
