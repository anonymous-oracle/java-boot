package SecondsAndMinutesChallenge.src;

public class App {
    public static void main(String[] args) {
        System.out.println(timeFormatter(85, 102));
        System.out.println(timeFormatter(3691));
     

    }

    public static String timeFormatter(double minutes, double seconds) {
        if (seconds < 0 || minutes < 0) {
            System.out.println("Please enter a valid input");
            return "";
        }
        minutes += (int) (seconds / 60);
        byte remainingSeconds = (byte) (seconds % 60);
        byte hours = (byte) (minutes / 60);
        minutes = minutes % 60;
        return hours + "h " + (byte) minutes + "m " + remainingSeconds + "s";
    }

    public static String timeFormatter(double seconds) {
        byte minutes = (byte) (seconds / 60);
        byte remainingSeconds = (byte) (seconds % 60);
        return timeFormatter(minutes, remainingSeconds);
    }
}
