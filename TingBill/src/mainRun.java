import java.util.Arrays;

/**
 * Created by Z001W4M on 10/28/2016.
 */
public class mainRun {

    public static void main (String[] args){

        bill mybill = new bill();

        String[] test = mybill.obtainPeople();
        System.out.println(Arrays.toString(test));



    }
}
