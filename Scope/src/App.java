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
        // NOTE: IF THE final KEYWORD IS USED BEFORE THE class KEYWORD, THEN ANY TYPE OF
        // INHERITANCE OF THE CLASS IS NOT POSSIBLE

        // NOTE: WHEN INHERITING CLASSES, IF THE METHODS OF THE INHERITED CLASS MUST NOT
        // BE OVERWRITTEN, THEN IN THE PARENT CLASS, ADD final KEYWORD BEFORE THE RETURN
        // TYPE OF THE METHOD

        System.out.println(num);
        // num = 2;
        System.out.println(num);

    }
}
