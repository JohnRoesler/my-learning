package src.Section13.SortedCollections;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 4);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45,7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

//        System.out.println(stockList.toString());

        Basket myBasket = new Basket("John");
        addToBasket(myBasket, "car", 1);
        System.out.println(myBasket);

        addToBasket(myBasket, "car", 1);
        System.out.println(myBasket);

        addToBasket(myBasket, "car", 1);
        System.out.println(myBasket);

        removeFromBasket(myBasket, "car", 1);
        System.out.println(myBasket);

//        add(myBasket, "tune", 1);
        addToBasket(myBasket, "juice", 12);
        addToBasket(myBasket, "vase", 13);
        System.out.println(myBasket);

        Basket testBasket = new Basket("Test");
        addToBasket(testBasket, "phone", 1);
        addToBasket(testBasket, "towel", 4);
        System.out.println(testBasket);

        removeFromBasket(testBasket, "towel", 2);
        removeFromBasket(testBasket, "towel", 3);
        System.out.println(testBasket);

        checkOut(myBasket);
        checkOut(testBasket);

        System.out.println(stockList);

        System.out.println(myBasket);
        System.out.println(testBasket);

//        System.out.println();
//        for (Map.Entry<String,Double> price : stockList.priceList().entrySet()){
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }
    }

    public static int addToBasket(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0){
            return basket.add(stockItem,quantity);
        }
        System.out.println("Insufficient stock of item: " + item);
        return 0;
    }

    public static int removeFromBasket(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.unreserveStock(item, quantity) != 0){
            return basket.remove(stockItem, quantity);
        }
        System.out.println("You can't remove more than you have!");
        return 0;
    }

    public static int checkOut(Basket basket){
        for (Map.Entry<StockItem, Integer> item : basket.items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        return basket.emptyBasket(stockList);
    }
}
