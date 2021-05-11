import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() { // for comparators, a class has to
                                                                                // implemented
        // for comparisons unlike the compareTo
        // function
        @Override
        public int compare(Seat seat1, Seat seat2) {
            return Double.compare(seat1.getPrice(), seat2.getPrice());
        }
    };

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + numRows;
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12;
                if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00;
                } else if ((row > 'F') && (seatNum < 4 || seatNum > 9)) {
                    price = 7;
                }
                Seat seat = new Seat(row + String.format("%d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return this.theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(this.seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return this.seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        // Seat requestedSeat = null;
        // for (Seat seat : seats) {
        // if (seat.getSeatNumber().equals(seatNumber)) {
        // requestedSeat = seat;
        // break;
        // }
        // }
        // if (requestedSeat == null) {
        // System.out.println("There is no seat " + seatNumber);
        // return false;
        // }

        // return requestedSeat.reserve();
    }

    // for testing
    public void printSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber() + "\t" + seat.getPrice());
        }
    }

    public List<Seat> getSeats() {
        return this.seats;
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + this.seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Seat " + this.seatNumber + " reservation cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return this.seatNumber;
        }

        public double getPrice() {
            return this.price;
        }

        public String toString() {
            return this.getSeatNumber() + "\t" + this.getPrice();
        }
    }
}
