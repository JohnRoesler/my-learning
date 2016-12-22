package src.Arrays;

/**
 * Created by Z001W4M on 12/21/2016.
 */
public class Contact {

    private String name;
    private String number;

    private Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public static Contact createContact(String name, String number){
        return new Contact(name,number);
    }
}
