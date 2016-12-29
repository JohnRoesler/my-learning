package src.Car;

/**
 * Created by Z001W4M on 12/7/2016.
 */
public class Account {

    private int number;
    private double balance;
    private String name;
    private String email;
    private long phone;


    public Account(){
        this((int) (Math.random()*90000000 + 10000000), 0, "Default name","Default email", 8008675309L);
        System.out.println("Called the default constructor");
    }

    public Account(int number, double balance) {
        this(number, balance, "Default name","Default email", 8008675309L);
        System.out.println("Called the partial constructor");
    }

    public Account(int number, double balance, String name, String email, long phone) {
        this.number = number;
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.phone = phone;
        System.out.println("Called the full constructor");
    }

    public void deposit(int accNum, double amount){
        if (accNum == this.number){
            this.balance += amount;
            System.out.println("Balance: " + this.balance);
        }else{
            System.out.println("You must provide the valid account number");
        }
    }

    public void withdraw(int accNum, double amount){
        if (accNum == this.number){
            if (this.balance >= amount){
                this.balance -= amount;
            System.out.println("Withdrawl: " + amount + ". Balance: " + this.balance);
            }else {
                System.out.println("You cannot withdraw more than your balance of: " + this.balance);
            }
        }else{
            System.out.println("You must provide the valid account number");
        }
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
