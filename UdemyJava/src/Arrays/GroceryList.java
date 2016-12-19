package src.Arrays;

import java.util.ArrayList;

/**
 * Created by Z001W4M on 12/19/2016.
 */
public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item){
        groceryList.add(item);
        System.out.println("You added " + item + " to the grocery list.");
    }

    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " in your in your grocery list.");
        for(int i = 0;i < groceryList.size();i++){
            System.out.println((i+1)+ ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryList(int position, String newItem){
        String temp = groceryList.get(position);
        groceryList.set(position,newItem);
        System.out.println("You replaced " + temp + " with " + newItem + " on your list" +
                " in position " + (position+1) + ".");
    }

    public void removeItem(int position){
        groceryList.remove(position);
    }

    public String findItem(String searchItem){
        //boolean exists = groceryList.contains(searchItem);
        int position = groceryList.indexOf(searchItem);

        if (position >= 0){
            return groceryList.get(position);
        }
        return "Item is not in the list";
    }

}
