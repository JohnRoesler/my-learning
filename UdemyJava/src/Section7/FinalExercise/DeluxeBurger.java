package src.Section7.FinalExercise;

/**
 * Created by Z001W4M on 12/16/2016.
 */
public class DeluxeBurger extends Hamburger{

    private String[] additions = {"", ""};
    private double chips;
    private double drink;

    public DeluxeBurger(String bun, String meat) {
        super(bun, meat);
        this.additions[0] = "Chips";
        this.additions[1] = "Drink";
        this.chips = 1.00;
        this.drink = 1.75;
    }

    @Override
    public void addAddition(String addition) {
        System.out.println("No additions allowed. " +
                "Deluxe burger comes with chips and a drink only.");
    }

    @Override
    public double calcCost() {
        double cost = this.getBaseBurger() + this.getChips() + this.getDrink();
        System.out.println("Base burger: " + this.getBaseBurger());
        System.out.println("Addition - chips: " + this.getChips());
        System.out.println("Addition - drink: " + this.getDrink());
        System.out.println("Total cost: " + cost);
        return cost;
    }

    @Override
    public String[] getAdditions() {
        return additions;
    }

    public double getChips() {
        return chips;
    }

    public double getDrink() {
        return drink;
    }
}
