package src.Section13.SortedCollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem,Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int add(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int remove(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            if ((inBasket > 0) && (inBasket >= quantity)) {
                if ((inBasket - quantity) == 0){
                    list.remove(item);
                    return inBasket - quantity;
                }
                list.put(item, inBasket - quantity);
                return inBasket - quantity;
            }
        }
        return -1;
    }

    public int checkOut(StockList stockList){
        for (Map.Entry<StockItem, Integer> item : list.entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        list.clear();
        return 0;
    }



    public Map<StockItem, Integer> items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() +
                ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + "\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
