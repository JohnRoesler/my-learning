package src.Section13.Collections.Example;

//created by Tim Buchalka Udemy Complete Java Developer Course

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater("Olympian", 8, 12);
        theater.getSeats();
        if(theater.reserveSeat("D12")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
        if(theater.reserveSeat("D12")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
        if(theater.reserveSeat("B13")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        List<Theater.Seat> priceSeats = new ArrayList<>(theater.getSeats());
        priceSeats.add(theater.new Seat("B00", 13));
        priceSeats.add(theater.new Seat("A00", 13));
        Collections.sort(priceSeats, theater.PRICE_ORDER);
        printList(priceSeats);

        //this is a shallow copy, so the list references the same seat objects
//        List<Theater.Seat> seatCopy = new ArrayList<>(theater.seats);
//        printList(seatCopy);

//        seatCopy.get(1).reserve();
//
//        if(theater.reserveSeat("A02")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sorry, seat is taken");
//        }

//        Collections.shuffle(seatCopy);

//        System.out.println("printing seatCopy");
//        printList(seatCopy);
//
//        System.out.println("printing theater.seats");
//        printList(theater.seats);


        //min and max functions in Collections
        /*Theater.Seat minSeat = Collections.min(seatCopy);
        Theater.Seat maxSeat = Collections.max(seatCopy);

        System.out.println("min seat " + minSeat.getSeatNumber());
        System.out.println("max seat " + maxSeat.getSeatNumber());*/

//        sortList(seatCopy);
//        System.out.println("sorted seat copy");
//        printList(seatCopy);

    }

    public static void printList(List<Theater.Seat> List){
        for (Theater.Seat seat : List) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("=========================================");
    }

    //bubble sort method
    public static void sortList(List<? extends Theater.Seat> List){
        for (int i = 0; i < List.size(); i++){
            for (int j = i + 1; j < List.size(); j++){
                if (List.get(i).compareTo(List.get(j)) > 0){
                    Collections.swap(List, i, j);
                }
            }
        }
    }
}
