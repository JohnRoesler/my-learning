package src.InnerAbstract.AbstractClass;

/**
 * Created by Z001W4M on 1/3/2017.
 */
public class Main {

    public static void main(String[] args) {


        Dog dog = new Dog("Yorkie");
        dog.breath();
        dog.eat();

        Parrot parrot = new Parrot("Australian ringneck");
        parrot.breath();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();




    }

}
