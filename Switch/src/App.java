package Switch.src;

public class App {
    public static void main(String[] args) {
        int value = 5;
        switch (value) {
        case 1:
            System.out.println("Value is 1");
            break; // without the break statement, the program flow will flow through the next case
                   // statement
        case 2:
            System.out.println("Value is 2");
            break;
        case 3:
            System.out.println("Value is 3");
            break;
        case 4:
        case 5:
            System.out.println("Value is either 4 or 5 or 6");
            break;
        default:
            System.out.println("The value is not among 1, 2, 3, 4, 5, 6");
            break;
        }
        char letter = 'l';
        switch (letter) {
        case 'a':
            System.out.println("Letter a is a vowel");
            break; // without the break statement, the program flow will flow through the next case
                   // statement
        case 'e':
            System.out.println("Letter e is a vowel");
            break;
        case 'i':
            System.out.println("Letter i is a vowel");
            break;
        case 'o':
            System.out.println("Letter o is a vowel");
            break;
        case 'u':
            System.out.println("Letter u is a vowel");
            break;
        default:
            System.out.println("Letter is a consonent");
            break;
        }

    }
}
