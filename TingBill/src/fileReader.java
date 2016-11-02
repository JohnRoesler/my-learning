/**
 * Created by Z001W4M on 10/28/2016.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileReader {


    //This method takes the filename and the type(min, msg, or mb) and the persons name and returns the usage
    public int parseFile(String filename, String type, String name){

        int returnValue = 0;
        int column1 = 0;
        int column2 = 0;

        if(type == "min"){
            column1 = 4;
            column2 = 11;
        }else if (type == "msg"){
            column1 = 3;
        }else if (type == "mb"){
            column1 = 2;
            column2 = 4;
        }

        String line = "";
        String[] splitLine;
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                line = cleanLineOfCommasInsideQuotes(line);
                splitLine = line.split(",");
                if (name.equals(splitLine[column1])){
                    if (type == "msg"){
                        returnValue += 1;
                    }else{
                    returnValue = returnValue + Integer.parseInt(splitLine[column2]);
                    }
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }


        return returnValue;
    }

    //This method removes commas that are inside of quotation marks to allow for splitting the CSV on commas
    //Without removing, the data will split in places we don't want it to e.g. "City, State"
    public String cleanLineOfCommasInsideQuotes(String line){
        String outputLine = "";
        char[] splitLine;
        boolean insideQuote = false;
        splitLine = line.toCharArray();
        outputLine = "";
        for (char character : splitLine) {
            if (character == '"'){
                insideQuote = !insideQuote;
                outputLine = outputLine + Character.toString(character);
            } else if (insideQuote == true && character == ','){
                continue;
            } else {
                outputLine = outputLine + Character.toString(character);
            }
        }
        return outputLine;
    }
}
