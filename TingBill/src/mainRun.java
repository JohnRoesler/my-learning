/**
 * Created by Z001W4M on 10/28/2016.
 */
public class mainRun {

    public static void main (String[] args){

        fileReader myReader = new fileReader();
        int test = myReader.parseFile("C:\\Users\\Z001W4M\\Downloads\\messages3756518.csv","msg","John");
        System.out.println(test);

    }
}
