package src.FinalExercise;

/**
 * Created by Z001W4M on 12/13/2016.
 */
public class Main {

    public static void main(String[] args) {

        Hamburger myBurger = new Hamburger("Whole Wheat", "Bison");
        myBurger.addAddition("lettuce");
        myBurger.addAddition("SproutS");
        myBurger.calcCost();

        HealthyBurger myHealthyBurger = new HealthyBurger("Lamb");
        myHealthyBurger.addAddition("lettuce");
        myHealthyBurger.addAddition("SproutS");
        myHealthyBurger.addAddition("Bacon");
        myHealthyBurger.addAddition("Tomato");
        myHealthyBurger.addAddition("pickLe");
        myHealthyBurger.addAddition("onION");
        myHealthyBurger.calcCost();

        DeluxeBurger myDeluxeBurger = new DeluxeBurger("Pretzel", "Beef");
        myDeluxeBurger.calcCost();
        myDeluxeBurger.addAddition("");
    }
}
