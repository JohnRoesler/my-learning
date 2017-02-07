package src.Section13.AdventureGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));

//        Define the exits from each location
//        location 1
        tempExit = new HashMap<>();
        tempExit.put("W",2);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("N",5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));
//        location 2
        tempExit = new HashMap<>();
        tempExit.put("N",5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));
//        location 3
        tempExit = new HashMap<>();
        tempExit.put("W",1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));
//        location 4
        tempExit = new HashMap<>();
        tempExit.put("N",1);
        tempExit.put("W",2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));
//        location 5
        tempExit = new HashMap<>();
        tempExit.put("S",1);
        tempExit.put("W",2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));


        int loc = 1;
        while (true){
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0){
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are: ");
            for (String exit : exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            ArrayList<String> vocabulary = new ArrayList<>();
            vocabulary.add("NORTH");
            vocabulary.add("SOUTH");
            vocabulary.add("EAST");
            vocabulary.add("WEST");
            vocabulary.add("QUIT");
            //alternate, use a map "NORTH", "N" etc.

            if (direction.length() > 1){
                String[] words = direction.split(" ");
                for (String word : words){
                    if (vocabulary.contains(word)){
                        direction = "" + word.charAt(0);
                        break;
                    }
                }
            }



            if (exits.containsKey(direction)){
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
            if (!locations.containsKey(loc)){
                System.out.println("You cannot go in that direction");
            }
        }

    }
}
