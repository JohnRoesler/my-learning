package src.Interfaces;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Z001W4M on 1/4/2017.
 */
public class Main {

    public static void main(String[] args) {
        Player john = new Player("john",10,15);
        System.out.println(john.toString());
        saveObject(john);

        john.setHitPoints(8);
        System.out.println(john);
        john.setWeapon("Stormbringer");
        saveObject(john );
        //loadObject(john );
        System.out.println(john);

        ISaveable werewolf = new Monster("Werewolf", 20,40);
        System.out.println(werewolf);
        System.out.println("Strength is: " + ((Monster) werewolf).getStrength());
        //this is better way to do it - interface name = new implementation()
        saveObject(werewolf);

        /*IDataStore myFileCabinet = new FileCabinet();
        ArrayList<String> testString = new ArrayList<String>();
        testString.add("one");
        testString.add("two");
        testString.add("three");
        testString.add("four");
        myFileCabinet.storeValues(testString);

        System.out.println(myFileCabinet.toString());

        List<String> testString2 = new ArrayList<String>();
        testString2 = myFileCabinet.returnValues();

        IDataStore myHardDrive = new HardDrive();
        myHardDrive.storeValues(readValues());
        System.out.println(myHardDrive.toString());*/

    }

    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose: \n" +
                "0 - quit\n" +
                "1 - enter string");

        while (!quit){
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index,stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave){
        for (int i=0; i<objectToSave.write().size(); i++){
            System.out.println("Saving " + objectToSave.write().get(i) +
                    " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad){
        ArrayList<String > values = readValues();
        objectToLoad.read(values);
    }

}
