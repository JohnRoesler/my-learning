package src.Section13.Sets;

public class Labrador extends Dog{

    public Labrador(String name) {
        super(name);
    }

//    best solution is to not override the labrador equals method
//    and then mark the parent class equals method as final
    /*@Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o instanceof Labrador){
            String objName = ((Labrador) o ).getName();
            return this.getName().equals(objName);
        }
        return false;
    }*/
}
