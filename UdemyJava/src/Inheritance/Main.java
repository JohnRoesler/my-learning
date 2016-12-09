package Inheritance;

/**
 * Created by Z001W4M on 12/8/2016.
 */
public class Main {

    public static void main(String[] args) {

        Honda myCivic = new Honda(0,0,"Silver",1,4,"Civic LX");
        myCivic.changeGear(2);
        System.out.println(myCivic.getCurrentGear());

/*        Animal myAnimal = new Animal("Pooty", 1, 1, 10, 50);
        myAnimal.eat();

        Dog fido = new Dog("Fido", 5, 50, 2, 4, 1, 24, "Sleek");
        fido.eat();
        fido.run();
        fido.walk();*/
    }
}
