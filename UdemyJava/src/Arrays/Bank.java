package src.Arrays;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Z001W4M on 12/27/2016.
 */


public class Bank {

    private ArrayList<Branch> branch;
    private Scanner scanner = new Scanner(System.in);

    public Bank() {
        this.branch = new ArrayList<Branch>();
    }

    public String newBranch (){
        System.out.println("Enter the new branch name: ");
        String branchName = scanner.nextLine();
        this.branch.add(new Branch(branchName));
        System.out.println("New branch created: " + branchName);
        System.out.println("Current branch selected: " + branchName);
        return branchName;
    }

    public void listBranches(){
        if (branch.size() == 0){
            System.out.println("No branches exist!");
        }
        for (int i = 0; i < branch.size(); i++){
            System.out.println("Branch #" + (i+1) + ": " + branch.get(i).getName());
        }
    }

    public void listCustomers(int branchPosition){
        if (branchPosition < 0){
            System.out.println("You must first create a branch");
            return;
        }
        branch.get(branchPosition).listCustomers();
    }

    public void listTransactions(int branchPosition, int customerPosition){
        if (branchPosition < 0 && customerPosition < 0){
            System.out.println("Select a branch/customer!");
            return;
        }
        branch.get(branchPosition).listTransactions(customerPosition);
    }

    public int selectBranch (){
        System.out.println("Enter the name of the branch to select: ");
        String branchName = scanner.nextLine();
        System.out.println("Current branch selected: " + branchName);
        return findBranchPosition(branchName);
    }

    public String addNewCustomer(int branchPosition){
        if (branchPosition < 0){
            System.out.println("You must first create a branch");
            return "";
        }
        System.out.println("Enter the customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter the initial deposit: ");
        double beginBalance = scanner.nextDouble();
        scanner.nextLine();
        branch.get(branchPosition).addNewCustomer(customerName,beginBalance);
        System.out.println("At branch: " + branch.get(branchPosition).getName() + "... \nCreated new customer, " +
                customerName + ", with an initial transaction of $" + beginBalance);
        System.out.println("Current customer selected: " + customerName);
        return customerName;
    }

    public void addCustomerTransaction (int branchPosition, int customerPosition){
        if (branchPosition < 0 && customerPosition < 0){
            System.out.println("Select a branch/customer!");
            return;
        }
        System.out.println("Enter the transaction amount: ");
        double transaction = scanner.nextDouble();
        scanner.nextLine();
        branch.get(branchPosition).newTransaction(transaction,customerPosition);
        System.out.println("Transaction recorded for $" + transaction);
    }

    private int findBranchPosition(String name){
        for (int i = 0; i < branch.size(); i++){
            if (branch.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    private int findCustomerPosition(String name, int branchPosition){
        return branch.get(branchPosition).findCustomerPosition(name);
    }

    public int selectCustomer(int branchPosition){
        if (branchPosition < 0){
            System.out.println("You must first create/select a branch");
            return -1;
        }
        System.out.println("Enter the name of the customer to select:");
        String customerName = scanner.nextLine();
        System.out.println("Current customer selected: " + customerName);
        return findCustomerPosition(customerName,branchPosition);
    }

    public void printInstructions(){
        System.out.println("Hello, welcome to the bank, please select one of the following options: \n" +
                "0 - Print instructions\n" +
                "1 - Create a branch\n" +
                "2 - Select a created branch\n" +
                "3 - Create a customer\n" +
                "4 - Select a created customer\n" +
                "5 - Add a transaction\n" +
                "6 - List branches\n" +
                "7 - List customers\n" +
                "8 - List customer transactions\n" +
                "9 - Leave bank" );
    }

    public void talkToTeller(){
        boolean flag = true;
        int choice = 0;
        int currentBranch = -1;
        String currentBranchName;
        int currentCustomer = -1;
        String currentCustomerName;
        this.printInstructions();

        while (flag){
            System.out.println("Enter a choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    currentBranchName = newBranch();
                    currentBranch = findBranchPosition(currentBranchName);
                    break;
                case 2:
                    currentBranch = selectBranch();
                    currentBranchName = branch.get(currentBranch).getName();
                    break;
                case 3:
                    currentCustomerName = addNewCustomer(currentBranch);
                    currentCustomer = findCustomerPosition(currentCustomerName,currentBranch);
                    break;
                case 4:
                    currentCustomer = selectCustomer(currentBranch);
                    currentCustomerName = branch.get(currentBranch).getBranchCustomer().get(currentCustomer).getName();
                    break;
                case 5:
                    addCustomerTransaction(currentBranch,currentCustomer);
                    break;
                case 6:
                    listBranches();
                    break;
                case 7:
                    listCustomers(currentBranch);
                    break;
                case 8:
                    listTransactions(currentBranch,currentCustomer);
                    break;
                case 9:
                    flag = false;
                    System.out.println("Thanks for visiting the bank!");
                    break;
            }



        }

    }

}
