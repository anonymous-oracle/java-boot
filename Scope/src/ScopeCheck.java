public class ScopeCheck {
    public int publicVar = 0;
    private int privateVar = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar + " : privateVar = " + privateVar);
    }

    public int getPrivatVar() {
        return this.privateVar;
    }

    public void timesTwo() {
        int privateVar = 2; // suppose this line is commented, then this function
        // will use the instance variable privateVar
        for (int i = 0; i < 10; i++) { // loop variable i will go out of scope after the loop finishes execution
            System.out.println(i + " times two is " + i * privateVar);
        }
    }

    public class InnerClass {
        public int privateVar = 3;

        public InnerClass() {
            System.out.println("InnerClass created, privateVar is " + privateVar);
        }

        public void timesTwo() {
            // int privateVar = 2; // suppose this line is commented, then this function
            // will use the instance variable privateVar
            for (int i = 0; i < 10; i++) { // loop variable i will go out of scope after the loop finishes execution
                // System.out.println(i + " times two is " + i * privateVar);
                System.out.println(i + " times two is " + i * ScopeCheck.this.privateVar);

            }
        }
    }
}