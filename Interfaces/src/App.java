public class App {
    public static void main(String[] args) {
        // DeskPhone phone;
        ITelephone phone; // this generalizes it with the interface
        phone = new DeskPhone(5615569);
        phone.powerOn();
        phone.callPhone(12346);

    }
}
