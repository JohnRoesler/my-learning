package src.InnerAbstract.AbstractClass;

/**
 * Created by Z001W4M on 1/6/2017.
 */
public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();
    public abstract void breath();

    public String getName() {
        return name;
    }
}
