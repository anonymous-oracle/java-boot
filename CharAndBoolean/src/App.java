package CharAndBoolean.src;

public class App {
    public static void main(String[] args) {
        char myChar = 'D';
        System.out.println(myChar);
        myChar = '\u0044'; // unicode for 'D'
        System.out.println(myChar);

        // printing literal 'char' type values
        System.out.println('\u0404');
        System.out.println('\u00a9'); // same as '\u00A9'

        boolean myTrueVal = true;
        boolean myFalseVal = false;

        boolean isPersonAdult = true;
        
    }
}
