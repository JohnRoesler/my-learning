package src.Section12.Challenge;

import java.util.Scanner;

public class X {

    private int x;

    private void scanner (){
        Scanner x = new Scanner(System.in);
        System.out.println("Enter an integer to get the multiplication table: ");
        this.x = x.nextInt();
        x.nextLine();
    }

    public void x(){
        scanner();
        for (int x = 0; x <= 12; x++){
            System.out.println(this.x + " x " + x + " = " + this.x * x);
        }
    }

}
