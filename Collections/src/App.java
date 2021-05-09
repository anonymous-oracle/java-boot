public class App {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("PVR GOLD", 8, 12);
        // theatre.getSeats();
        if (theatre.reserveSeat("H12")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
        if (theatre.reserveSeat("H12")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
    }
}
