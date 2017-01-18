package src.Section13.Collections.Example;

//created by Tim Buchalka Udemy Complete Java Developer Course

public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater("Olympian", 8, 12);
//        theater.getSeats();
        if(theater.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
        if(theater.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
    }
}
