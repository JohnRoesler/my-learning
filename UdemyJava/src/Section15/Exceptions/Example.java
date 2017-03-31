package src.Section15.Exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
            int result = divide();
    }

    private static int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            int result = x / y;
            System.out.println(x + " / " + y + " = " + result);
            return result;
        } catch (NoSuchElementException e){
            throw new NoSuchElementException("No suitable input");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Can't divide by zero");
        }

    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer: ");

        while (true){
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                //go through again
                s.next();
                System.out.println("Invalid input! Please enter an integer: ");
            }
        }

    }
}
