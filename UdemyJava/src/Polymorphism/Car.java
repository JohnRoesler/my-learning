package src.Polymorphism;

/**
 * Created by Z001W4M on 12/13/2016.
 */
public class Car {
    private boolean engine;
    private int cylinders;
    private int wheels;
    private String name;
    private int speed;
    private String make;

    public Car(int cylinders, String name, String make) {
        this.cylinders = cylinders;
        this.name = name;
        this.engine = true;
        this.wheels = 4;
        this.speed = 0;
        if (make == ""){
            this.make = "car";
        }else{
            this.make = make;
        }


    }

    public void startEngine(){
        System.out.println("The car's engine has been started");
    }
    public void accelerate(int speed){
        this.speed = speed;
        System.out.println("The " + make + " is now going " + speed + "mph!");
    }
    public void brake(){
        this.speed = 0;
        System.out.println("The car has now stopped");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getMake() {
        return make;
    }

    public String getName() {
        return name;
    }
}
