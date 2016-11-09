import org.apache.commons.lang.WordUtils;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Z001W4M on 11/1/2016.
 */
public class bill {

    String minFilename;
    String msgFilename;
    String mbFilename;
    String[] listOfPeople;
    HashMap<String, HashMap<int[], double[]>> people = new HashMap<String, HashMap<int[], double[]>>();

    public void calculateBill(){
        minFilename = obtainFileName("minutes");
        msgFilename = obtainFileName("messages");
        mbFilename = obtainFileName("megabytes");
        listOfPeople = obtainPeople();


    }

    //This takes the bill filenames in and passes the string path out
    public String obtainFileName(String type){
        String filename;
        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter the " + type + " full file path: ");
        filename = user_input.nextLine();
        return filename;
    }

    public String[] obtainPeople(){
        String listofpeople[];
        String inputlistofpeople;
        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter the names of people on the bill separated by commas");
        inputlistofpeople = user_input.nextLine();
        inputlistofpeople = inputlistofpeople.replaceAll(" ","");
        listofpeople = inputlistofpeople.split(",");
        for (int x = 0; x < listofpeople.length; x++){
            listofpeople[x] = WordUtils.capitalizeFully(listofpeople[x]);
        }
        return listofpeople;
    }

}
