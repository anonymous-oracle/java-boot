public class Printer {
    private int tonerLevel;
    private int numPagesPrinted;
    private boolean isDuplex;
    private int tonerLimit;

    public Printer(int tonerLevel, boolean isDuplex) {
        this.tonerLevel = tonerLevel;
        this.tonerLimit = this.tonerLevel;
        this.isDuplex = isDuplex;
        this.numPagesPrinted = 0;
    }

    private boolean refillAlert() {
        System.out.println("Refill toner to adequate level");
        return false;
    }

    private void adjustPageAndTonerParams(int pages, int tonerUsage) {
        this.numPagesPrinted += pages;
        this.tonerLevel -= tonerUsage;
    }

    private boolean tonerChecker(int limit) {
        if (this.tonerLevel <= limit) {
            return this.refillAlert();
        }
        return true;
    }

    public boolean printPage() {
        boolean response;
        if (this.isDuplex) {
            response = this.tonerChecker(1);
            this.adjustPageAndTonerParams(2, 2);
        } else {
            response = this.tonerChecker(0);
            this.adjustPageAndTonerParams(1, 1);
        }
        System.out.println("Printing page...");
        return response;

    }

    public int getTonerLevel() {
        return this.tonerLevel;
    }

    public void fillToner(int refillAmount) {
        if (this.tonerLevel + refillAmount <= this.tonerLimit) {
            this.tonerLevel += refillAmount;
        } else {
            this.tonerLevel = this.tonerLimit;
        }
        System.out.println("TONER REFILLED");
        System.out.println("Toner level now: " + this.tonerLevel);
    }

}
