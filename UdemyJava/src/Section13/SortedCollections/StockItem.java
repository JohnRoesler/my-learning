package src.Section13.SortedCollections;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.0){
            this.price = price;
        }
    }

    public void adjustStock(int quantity){
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0){
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Entering StockItem.equals()");
        if (o == this){
            return true;
        }
        if (o == null || (o.getClass() != this.getClass())){
            return false;
        }
        String oName = ((StockItem) o).getName();
        return this.getName().equals(oName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem stockItem) {
        System.out.println("Entering StockItem.compareTo");
        if (this == stockItem){
            return 0;
        }
        if (stockItem == null){
            throw new NullPointerException();
        }
        return this.name.compareTo(stockItem.getName());
    }

    @Override
    public String toString() {
        return this.name + ": " + String.format("%.2f", this.price);
    }
}
