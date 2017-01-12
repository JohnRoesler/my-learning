package src.Section12.SeriesTest;

//exported package as JAR file ->> Project Structure, Artifacts, +, JAR, from modules with dependencies
//then to add external library ->> Libraries, +, Java, browse to location, out\...\.jar
import src.Section12.Challenge.Series;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++){
            System.out.println(Series.nSum(i));
        }

        for (int i = 0; i <= 10; i++){
            System.out.println(Series.factorial(i));
        }

        for (int i = 0; i <= 10; i++){
            System.out.println(Series.fibonacci(i));
        }
    }

}
