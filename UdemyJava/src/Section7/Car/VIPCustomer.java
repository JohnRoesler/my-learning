package src.Section7.Car;

/**
 * Created by Z001W4M on 12/8/2016.
 */
public class VIPCustomer {

    String name;
    int credit;
    String email;

    public VIPCustomer() {
        this("Update name", 0, "Update email");
    }

    public VIPCustomer(String name, String email) {
        this(name, 1000, email);
    }

    public VIPCustomer(String name, int credit, String email) {
        this.name = name;
        this.credit = credit;
        this.email = email;
        System.out.println(this.name + " " + this.credit + " " + this.email);
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public String getEmail() {
        return email;
    }
}
