package Operators.src;

public class App {
    public static void main(String[] args) {
        int result = 1 + 2; // 1 + 2 = 3
        System.out.println(result);
        result = result - 1;
        System.out.println(result);
        result = result * 10;
        System.out.println(result);
        result = result / 5;
        System.out.println(result);
        result = result % 3; // gives out the remainder
        System.out.println(result);

        System.out.println(
                "============================INCREMENT/DECREMENT OPERATORS=====================================");

        // result = result + 1;
        System.out.println(result); // 1
        result++;
        System.out.println(result); // 2
        System.out.println(++result); // 3
        System.out.println(result); // 3
        System.out.println(result++); // 3
        System.out.println(result); // 4

        // if-else
        boolean isHuman = false;
        if (isHuman == false) {
            System.out.println("Not Human");
        } else {
            System.out.println("Is Human");
        }

        if (isHuman == true)
            System.out.println("will not be printed");
        System.out.println("will be printed");

        // logical operator
        int topScore = 100;
        if (topScore != 100) {
            System.out.println("Not equal to hundred");
        } else
            System.out.println("Is equal to hundred");
        int secondTopScore = 60;
        if ((secondTopScore < topScore) && (100 > topScore)) {
            System.out.println("Greater than second top score and less than 100");
        }
        if ((secondTopScore > topScore) || (100 < topScore)) {
            System.out.println("Either less than second top score and greater than 100");
        }

        // KEEP NOTE OF THE DIFFERENCE BETWEEN AN ASSIGNMENT OPERATOR AND A EQUALITY
        // OPERATOR
        // AN ASSIGNMENT OPERATION ALWAYS RETURNS THE VALUE ASSIGNED TO THE VARIABLE
        if (!isHuman) {
            System.out.println("is Human");
        }

        // TERNARY OPERATOR
        boolean isAlien = isHuman ? false : true;
        if (isAlien) {
            System.out.println("is Alien");
        }
        int ageOfPerson = 2;
        boolean isAdult = (ageOfPerson >= 18) ? true : false;
        // boolean isAdult = ageOfPerson >= 18 ? true : false;
        if (isAdult) {
            System.out.println("Is Adult");
        } else
            System.out.println("Is not Adult");

    }
}
