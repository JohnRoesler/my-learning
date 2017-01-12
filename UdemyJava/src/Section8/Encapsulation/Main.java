package src.Section8.Encapsulation;

/**
 * Created by Z001W4M on 12/13/2016.
 */
public class Main {

    public static void main(String[] args) {
        Printer Epson4200 = new Printer(true);
        Printer Dell1400 = new Printer(false);

        Epson4200.print("Text",11,false);
        Dell1400.print("Text", 5, false);

    }



}
