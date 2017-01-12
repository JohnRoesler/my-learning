package src.Section9.Arrays;

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
        System.out.println("You have " + groceryList.size() + " items in your in your grocery list.");
        for(int i = 0;i < groceryList.size();i++){
            System.out.println((i+1)+ ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryList(String currentItem, String newItem){
        int position = findItem(currentItem);
        if (position >=0){
            modifyGroceryList(position, newItem);
        }
    }

    private void modifyGroceryList(int position, String newItem){
        String temp = groceryList.get(position);
        groceryList.set(position,newItem);
        System.out.println("You replaced " + temp + " with " + newItem + " on your list.");
    }

    private void removeItem(int position){
        groceryList.remove(position);

    }
    public void removeItem(String item){
        int position = findItem(item);
        if (position >=0){
            removeItem(position);
            System.out.println(item + " was removed from the grocery list");
        }else {
            System.out.println(item + " was not on the grocery list.");
        }
    }

    private int findItem(String searchItem){
        return groceryList.indexOf(searchItem);

        /*//boolean exists = groceryList.contains(searchItem);
        int position = groceryList.indexOf(searchItem);

        if (position >= 0){
            return groceryList.get(position);
        }
        return null;*/
    }

    public boolean onGroceryList(String searchItem){
        int position = findItem(searchItem);
        if (position >= 0){
            return true;
        }
        return false;
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }
}
