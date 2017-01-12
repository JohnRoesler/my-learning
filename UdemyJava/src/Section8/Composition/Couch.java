package src.Section8.Composition;

/**
 * Created by john on 12/11/16.
 */
public class Couch {

    private String brand;
    private String model;
    private String cost;
    private Cushions newCushions;

    public Couch(String brand, String model, String cost, Cushions newCushions) {
        this.brand = brand;
        this.model = model;
        this.cost = cost;
        this.newCushions = newCushions;
    }
}
