package src.Section9.Arrays;

import java.util.ArrayList;

/**
 * Created by Z001W4M on 12/27/2016.
 */
public class Branch {

    private String name;
    private ArrayList<Customer> branchCustomer;

    public Branch(String name) {
        this.name = name;
        this.branchCustomer = new ArrayList<Customer>();
    }

    public void addNewCustomer(String customerName, double beginBalance){
        branchCustomer.add(new Customer(customerName,beginBalance));

    }

    public void listCustomers(){
        if (branchCustomer.size() == 0){
            System.out.println("No customers exist!");
        }
        for (int i = 0; i < branchCustomer.size(); i++){
            System.out.println("Customer #" + (i+1) + ": " + branchCustomer.get(i).getName());
        }
    }

    public void listTransactions(int customerPosition){
        if (customerPosition < 0){
            System.out.println("You must first create a customer!");
            return;
        }
        branchCustomer.get(customerPosition).listTransactions();
    }

    public String getName() {
        return name;
    }

    public int findCustomerPosition(String name){
        for (int i = 0; i < branchCustomer.size(); i++){
            if (branchCustomer.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Customer> getBranchCustomer() {
        return branchCustomer;
    }
    public void newTransaction(double transaction, int customerPosition){
        branchCustomer.get(customerPosition).newTransaction(transaction);
    }


}
