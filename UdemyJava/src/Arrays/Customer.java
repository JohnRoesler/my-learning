package src.Arrays;

import java.util.ArrayList;

/**
 * Created by Z001W4M on 12/27/2016.
 */
public class Customer {

    private ArrayList<Double> transactions;
    private String name;

    public Customer(String name, double initialDeposit) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        this.transactions.add(initialDeposit);
    }

    public void changeName(String newName){
        this.name = newName;
    }

    public void newTransaction(double transaction){
        this.transactions.add(transaction);
    }

    public void listTransactions(){
        if (transactions.size() == 0){
            System.out.println("No transactions exist!");
        }
        for (int i = 0; i < transactions.size(); i++){
            System.out.println("Transaction #" + (i+1) + ": $" + transactions.get(i));
        }
    }

    public String getName() {
        return name;
    }
}
