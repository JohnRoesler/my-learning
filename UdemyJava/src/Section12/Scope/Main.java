package src.Section12.Scope;

public class Main {

    public static void main(String[] args) {
        String varFour = "this is private to main()";

        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.useInner();
        System.out.println("scopeInstance varOne = " + scopeInstance.getVarOne());
        System.out.println(varFour);
        scopeInstance.timesTwo();

        System.out.println("===========================");

        ScopeCheck.InnerClass InnerClass = scopeInstance.new InnerClass();
        InnerClass.timesTwo();
    }
}
