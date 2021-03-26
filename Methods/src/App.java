package Methods.src;

public class App {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;
        int finalScore;
        finalScore = calculateScore(true, score, levelCompleted, bonus);
        printOut(finalScore);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        finalScore = calculateScore(true, score, levelCompleted, bonus);
        printOut(finalScore);

    }

    public static void printOut(int finalScore) {
        if (finalScore != -1) {
            System.out.println("Your final score was: " + finalScore);

        }
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;
        }
        return -1;
    }
}
