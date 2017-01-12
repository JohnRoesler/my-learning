package src.Section10.AbstractClass;

/**
 * Created by Z001W4M on 1/6/2017.
 */
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating");
    }

    @Override
    public void breath() {
        System.out.println("Breathe in, breathe out, repeat");
    }
}
