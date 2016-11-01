/**
 * Created by Z001W4M on 10/28/2016.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import com.opencsv.CSVReader;
import com.sun.istack.internal.NotNull;

public class fileReader {


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
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return returnValue;
    }

    public void testFile(String filename){

        CSVReader reader = null;
        char separator = ',';
        char quotechar = '"';

        try {
            reader = new CSVReader(new FileReader(filename), separator, quotechar);
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println(Arrays.toString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
