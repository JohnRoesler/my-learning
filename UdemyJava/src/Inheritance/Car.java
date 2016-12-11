package src.inheritance;

/**
 * Created by Z001W4M on 12/8/2016.
 */
public class Car extends Vehicle {

    private int currentGear;
    private int doors;

    public Car(int direction, int speed, String color, int currentGear, int doors) {
        super(direction, speed, color);
        this.currentGear = currentGear;
        this.doors = doors;
    }

    public Car(int currentGear, int doors) {
        this.currentGear = currentGear;
        this.doors = doors;
    }

    public void changeGear(int newGear){
        this.currentGear = newGear;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}
