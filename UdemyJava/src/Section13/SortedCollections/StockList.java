package src.Section13.SortedCollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String,StockItem> list;

    public StockList() {
        this.list = new HashMap<>();
    }

    public int addStock(StockItem item){
        if(item != null){
            //check if already have quantity of this item
            StockItem inStock = list.getOrDefault(item.getName(),item);
            //check if there are already stocks of this item, adjust the quantity
            //if there is already stock, adjust the passed item to include the current quantity
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }
            //update the map with the item, either a new one, or overwriting an existing
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);

        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)){
            inStock.adjustStock(-quantity);
            inStock.adjustReserved(-quantity);
            return quantity;
        }

        return 0;
    }

    public int reserveStock(String item, int quantity){
        StockItem itemReserved = list.getOrDefault(item, null);

        if ((itemReserved != null) && (itemReserved.quantityInStock() >= quantity) && (quantity > 0)){
            itemReserved.adjustReserved(quantity);
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(String item, int quantity){
        StockItem itemReserved = list.getOrDefault(item, null);

        if ((itemReserved != null) && (itemReserved.getQuantityReserved() >= quantity) && (quantity > 0)){
            itemReserved.adjustReserved(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String, StockItem> items(){
        return Collections.unmodifiableMap(list);
    }

    public Map<String, Double> priceList(){
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : list.entrySet()){
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()){
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ". There are " + stockItem.quantityInStock() +
                    " in stock. Value of items: " + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + String.format("%.2f", totalCost);
    }
}
