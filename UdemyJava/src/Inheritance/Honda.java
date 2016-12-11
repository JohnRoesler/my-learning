package src.inheritance;

/**
 * Created by Z001W4M on 12/8/2016.
 */
public class Honda extends Car{

    private String model;

    public Honda(int direction, int speed, String color, int currentGear, int doors, String model) {
        super(direction, speed, color, currentGear, doors);
        this.model = model;
    }

    public Honda(int currentGear, int doors, String model) {
        super(currentGear, doors);
        this.model = model;
    }

    @Override
    public void changeGear(int newGear) {
        if (newGear >= 1 && newGear <=6 ){
            super.changeGear(newGear);
        }else {
            System.out.println("You can't shift into a gear that doesn't exist!");
        }

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
