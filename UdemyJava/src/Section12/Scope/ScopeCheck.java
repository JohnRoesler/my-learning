package src.Section12.Scope;

public class ScopeCheck {
    public int publicVar = 0;
    private int varOne = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar + " - varOne = " + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo(){
        //scope insures that most local variable is used (most narrow scope)
        //if i or publicVar were not defined here, would check in next level
        //up in the enclosing block
        int varTwo = 2;
        for (int i=0; i <10; i++){
            //using this.varOne calls the varOne on line 8
            System.out.println(i + " times two is " + i * varTwo);
        }
    }

    public void useInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println("inner class varThree from outer class: " + innerClass.varThree);
    }

    public class InnerClass {
        //if we change this to public, then can access as scopeInstance.varThree in main class
        private int varThree = 3;

        public InnerClass() {
            System.out.println("Inner class created, varOne is " + varOne + " and varThree is " + varThree);
        }

        public void timesTwo(){
            System.out.println("varOne is still available here " + varOne);
            //int varOne = 2;
            for (int i=0; i <10; i++){
                //using ScopeCheck.this.varOne will call the varOne on line 8
                System.out.println(i + " times two is " + i * varThree);
            }
        }
    }
}
