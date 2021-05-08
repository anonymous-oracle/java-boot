public class App {
    public static void main(String[] args) {
        String privateVar = "this is private to main()";
        ScopeCheck scopeInstance = new ScopeCheck();
        System.out.println("scopeInstance privateVar is " + scopeInstance.getPrivatVar());
        System.out.println(privateVar);
        System.out.println("scopeInstance privateVar is " + scopeInstance.getPrivatVar());
        scopeInstance.timesTwo();
        System.out.println("****************************************************");
        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();
        // FINAL KEYWORD: can also be used in
        final int num = 1; // can be used to declare constants when initialized or can be assigned a value
                           // only once after declaration without initialization

        System.out.println(num);
        // num = 2;
        System.out.println(num);

    }
}
