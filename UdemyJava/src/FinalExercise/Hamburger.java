package src.FinalExercise;

import java.util.HashMap;

/**
 * Created by Z001W4M on 12/14/2016.
 */
public class Hamburger {

    private String bun;
    private String meat;
    private double cost;
    private String[] additions = {"","","",""};

    private double Lettuce;
    private double Onion;
    private double Pickle;
    private double Tomato;
    private double Sprouts;
    private double Bacon;
    private double baseBurger;

    public Hamburger(String bun, String meat) {
        this.bun = bun;
        this.meat = meat;
        this.Lettuce = 0.25;
        this.Onion = 0.25;
        this.Pickle = 0.50;
        this.Tomato = 0.25;
        this.Sprouts = 0.50;
        this.Bacon = 0.75;
        this.baseBurger = 6.00;

    }

    public double calcCost(){
        double cost = this.getBaseBurger();
        System.out.println("Base burger: " + this.getBaseBurger());
        for (int x = 0; x < 4; x++){
            switch (this.getAdditions()[x]){
                case "lettuce":
                    cost += this.getLettuce();
                    System.out.println("Addition - lettuce: " + this.getLettuce());
                    break;
                case "onion":
                    cost += this.getOnion();
                    System.out.println("Addition - onion: " + this.getOnion());
                    break;
                case "pickle":
                    cost += this.getPickle();
                    System.out.println("Addition - pickle: " + this.getPickle());
                    break;
                case "tomato":
                    cost += this.getTomato();
                    System.out.println("Addition - tomato: " + this.getTomato());
                    break;
                case "sprouts":
                    cost += this.getSprouts();
                    System.out.println("Addition - sprouts: " + this.getSprouts());
                    break;
                case "bacon":
                    cost += this.getBacon();
                    System.out.println("Addition - bacon: " + this.getBacon());
                    break;
                case "":
                    break;
                default:
                    System.out.println("There was an error with the additions. Addition " +
                            this.getAdditions()[x] + " not found in price list");;
            }
        }
        System.out.println("Total cost: " + cost );
        return cost;
    }

    public void addAddition(String addition){
        for (int x = 0; x < 4; x++){
            if (additions[x] == ""){
                additions[x] = addition.toLowerCase();
                return;
            }
        }
        System.out.println("You already have 4 additions and cannot have more.");
    }

    public double getBaseBurger() {
        return baseBurger;
    }

    public String[] getAdditions() {
        return additions;
    }

    public double getLettuce() {
        return Lettuce;
    }

    public double getOnion() {
        return Onion;
    }

    public double getPickle() {
        return Pickle;
    }

    public double getTomato() {
        return Tomato;
    }

    public double getSprouts() {
        return Sprouts;
    }

    public double getBacon() {
        return Bacon;
    }

    public double getCost() {
        return cost;
    }

    public String getBun() {
        return bun;
    }

    public String getMeat() {
        return meat;
    }
}
