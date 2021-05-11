import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("PVR GOLD", 8, 12);
        // theatre.printSeats();
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

        List<Theatre.Seat> priceSeats = new ArrayList<>();
        priceSeats.add(theatre.new Seat("B00", 13));
        priceSeats.add(theatre.new Seat("E00", 11));
        priceSeats.add(theatre.new Seat("A00", 12));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        
        for (Theatre.Seat seat : priceSeats) {
            System.out.println(seat);
        }
    }
}
