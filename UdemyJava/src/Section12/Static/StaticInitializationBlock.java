package src.Section12.Static;

public class StaticInitializationBlock {

    //can have as many as you want, are called in order listed in class
    //called before constructor and can initialize final variables

    public static final int test;

    static {
        System.out.println("Static initialization block called");
        test = 1;
    }

    static {

    }

    public StaticInitializationBlock() {
    }

    public void test(){
        System.out.println("test method run");
    }
}
