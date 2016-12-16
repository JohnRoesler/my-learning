package src.FinalExercise;

/**
 * Created by Z001W4M on 12/16/2016.
 */
public class HealthyBurger extends Hamburger {

    private String[] healthyAdditions = {"","","","","",""};

    public HealthyBurger(String meat) {
        super("Brown rye", meat);
    }

    @Override
    public void addAddition(String addition) {
        for (int x = 0; x < 6; x++){
            if (healthyAdditions[x] == ""){
                healthyAdditions[x] = addition.toLowerCase();
                return;
            }
        }
        System.out.println("You already have 6 additions and cannot have more.");
    }

    @Override
    public double calcCost() {
        double cost = this.getBaseBurger();
        System.out.println("Base burger: " + this.getBaseBurger());
        for (int x = 0; x < 6; x++){
            switch (this.getHealthyAdditions()[x]){
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
                            this.getHealthyAdditions()[x] + " not found in price list");;
            }
        }
        System.out.println("Total cost: " + cost );
        return cost;
    }

    public String[] getHealthyAdditions() {
        return healthyAdditions;
    }
}

