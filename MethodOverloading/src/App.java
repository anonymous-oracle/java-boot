package MethodOverloading.src;


// IN THE NEED FOR METHOD OVERLOADING, ALWAYS IMPLEMENT A GENERIC METHOD AND WHEN CREATING OVERLOADED METHODS
// CALL THE GENERIC METHOD APPROPRIATELY SO THAT THERE IS NO REPITITION OF CODE


public class App {
    public static void main(String[] args) {
        calculateScore("abc", 500);
        calculateScore(500);
        calculateScore();
        convertFeetAndInchesToCentimeters(6, 0);
        convertFeetToCentimeters(13.33);
        convertInchesToCentimeters(156);
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed Player scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No name, no score");
        return 0;
    }

    public static double convertFeetAndInchesToCentimeters(double feet, double inches) {
        if ((feet < 0) || (inches < 0)) {
            System.out.println("Please enter non-negative input");
            return -1;
        }
        double centimeters = (feet * 12) * 2.54;
        centimeters += (inches * 2.54);
        System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " centimeters");
        return centimeters;

    }

    public static double convertFeetToCentimeters(double feet) {
        if (feet < 0) {
            System.out.println("Please enter non-negative input");
            return -1;
        }
        return convertFeetAndInchesToCentimeters(feet, 0);

    }

    public static double convertInchesToCentimeters(double inches) {
        if (inches < 0) {
            System.out.println("Please enter non-negative input");
            return -1;
        }
        int feet = (int) (inches / 12);
        int remainingInches = (int) (inches % 12);
        return convertFeetAndInchesToCentimeters(feet, remainingInches);

    }

}
