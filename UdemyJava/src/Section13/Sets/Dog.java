package src.Section13.Sets;

public class Dog {

    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o instanceof Dog){
            String objName = ((Dog) o ).getName();
            return this.getName().equals(objName);
        }
        return false;
    }
}
