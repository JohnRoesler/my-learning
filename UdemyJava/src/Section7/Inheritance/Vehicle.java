package src.inheritance;

/**
 * Created by Z001W4M on 12/8/2016.
 */
public class Vehicle {

    private int direction; //handle direction as degrees of 360
    private int speed;
    private String color;

    public Vehicle(int direction, int speed, String color) {
        this.direction = direction;
        this.speed = speed;
        this.color = color;
    }
    public Vehicle(){
        this(0,0,"Default");
    }

    public void accelerate (int speed){
        this.speed += speed;
    }
    public void decelerate (int speed){
        this.speed -= speed;
    }
    public void turn (int degreeTurned){
        this.direction += degreeTurned;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
