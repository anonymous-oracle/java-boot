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

    public boolean printPage() {
        if (this.isDuplex) {
            if (this.tonerLevel <= 1) {
                return this.refillAlert();
            }
            this.adjustPageAndTonerParams(2, 2);
        } else {
            if (this.tonerLevel <= 0) {
                return this.refillAlert();
            }
            this.adjustPageAndTonerParams(1, 1);
        }
        System.out.println("Printing page...");
        return true;

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
