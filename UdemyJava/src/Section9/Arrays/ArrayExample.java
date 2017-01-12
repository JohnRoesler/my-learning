package src.Section9.Arrays;

import java.util.Scanner;

/**
 * Created by john on 12/17/16.
 */



public class ArrayExample {

    // this is from example
    /*private static Scanner scanner = new Scanner(System.in);*/

    public static void main(String[] args) {
        printArray(sortArray(getIntegers(3)));


        //this is from example
        /*int[] myIntegers = getIntegers(5);

        double average = calcAverage(myIntegers);*/
    }


    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integers:");
        Scanner scanner = new Scanner(System.in);
        int[] intInput = new int[number];
        for (int i = 0;i < intInput.length;i++){
            intInput[i] = scanner.nextInt();
        }
        return intInput;
    }

    public static void printArray(int[] array) {
        System.out.print("The sorted integers in the array are: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if ((i + 1) != array.length) {
                if ((i + 2) == array.length) {
                    System.out.print(" & ");
                    continue;
                }
                System.out.print(", ");
            }
        }
        System.out.print("\n");
    }
    //John's solution
    /*public static int[] sortArray(int[] array){
        int[] sortedArray = new int[array.length];
        for (int x = 0;x < array.length;x++) {
            int counter = 0;
            for (int i = 0; i < array.length; i++) {

                if (array[x] > array[i]) {
                    counter += 1;
                }
            }
            sortedArray[array.length - 1 - counter] = array[x];
        }
        return sortedArray;
    }*/

    //Brenda's solution
/*
    public static int[] sortArray(int[] array){
        int[] sortedArray = new int[array.length];

        for (int x = 0;x < array.length;x++) {
            int copy = 0;
            for (int i = 0;i < array.length; i ++){
                if (x > 0){
                    if (array[i] > copy && array[i] < sortedArray[x-1] ){
                        copy = array[i];
                    }
                }else {
                    if (array[i] > copy){
                        copy = array[i];
                    }
                }

            }
            sortedArray[x] = copy;
        }
        return sortedArray;
    }
*/

    //Instructors solution
    public static int[] sortArray(int[] array){
        /*int[] sortedArray = new int[array.length];
        for (int i=0;i<sortedArray.length;i++){
            sortedArray[i] = array[i];
        }*/
        int[] sortedArray = java.util.Arrays.copyOf(array,array.length);
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            for (int i=0;i<array.length-1; i++){
                if (sortedArray[i] < sortedArray[i+1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }


    //this is from example
/*
    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integer values:\r");
        int[] values = new int[number];

        for (int i = 0; i < values.length; i++){
            values[i] = scanner.nextInt();
        }
        System.out.print("Integer values typed: ");
        for (int i = 0; i < values.length; i++){
            System.out.print(values[i]);
            if((i + 1) != values.length){
                if((i+ 2) == values.length){
                    System.out.print(" & ");
                    continue;
                }
                System.out.print(", ");
            }
        }
        System.out.print("\n");
        return values;

    }

    public static double calcAverage(int[] intInputs){
        double sum = 0;
        for (int i = 0; i < intInputs.length; i++){
            sum += intInputs[i];
        }
        System.out.println("The average of the integers is: " + sum/intInputs.length);
        return sum/intInputs.length;

    }
*/

}
