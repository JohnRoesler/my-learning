package src.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Z001W4M on 12/19/2016.
 */
public class Main {


    /*private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();*/

    public static void main(String[] args) {

        Bank myBank = new Bank();
        myBank.talkToTeller();

/*        MobilePhone myPhone = new MobilePhone();
        myPhone.powerOn();*/

        /*boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
                case 7:
                    processArrayList();
                    break;
            }
        }*/

    }

    /*public static void printInstructions(){
        System.out.println("\nEnter a number below: ");
        System.out.println("\t 0 - To print options again.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item on the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem(){
        System.out.println("Enter the grocery item to add: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.println("Enter the item to be replaced: ");
        String currentItem = scanner.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryList(currentItem,newItem);
    }

    public static void removeItem(){
        System.out.println("Enter the item to be removed: ");
        groceryList.removeItem(scanner.nextLine());

    }

    public static void searchForItem(){
        System.out.println("Enter the item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onGroceryList(searchItem)){
            System.out.println(searchItem + " is in our grocery list.");
        }else {
            System.out.println(searchItem + " is not in the grocery list");
        }
    }

    public static void processArrayList(){
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }*/

}
