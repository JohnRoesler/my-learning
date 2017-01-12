package src.Section10.AbstractClass;

/**
 * Created by Z001W4M on 1/6/2017.
 */
public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("I'm not very good at that. Can I try swimming?");
    }
}
