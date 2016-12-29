package src.Car;

import java.util.Arrays;

/**
 * Created by Z001W4M on 12/5/2016.
 */
public class Car {

    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    private String[] validModel = {"carrera","911","cayanne","fusion"};

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setModel(String model) {
        String checkModel = model.toLowerCase();
        if(Arrays.asList(validModel).contains(checkModel)){
            this.model = model;
        }else {
            this.model = "Unknown";
        }

    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getDoors() {
        return doors;
    }

    public int getWheels(){
        return wheels;
    }

    public String getColor() {
        return color;
    }

    public String getEngine() {
        return engine;
    }
}
