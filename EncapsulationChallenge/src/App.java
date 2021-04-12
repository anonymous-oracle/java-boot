public class App {
    public static void main(String[] args) throws Exception {
        Printer printer = new Printer(100, true);
        for (int i = 0; i <= 500; i += 2) {
            System.out.println("Toner level: " + printer.getTonerLevel());
            if (!printer.printPage()) {
                printer.fillToner(25);
            }
        }
    }
}
