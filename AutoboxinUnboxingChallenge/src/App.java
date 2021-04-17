public class App {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank("SBI");
        bank.addBranch("Mysore");
        bank.listBranches();
        bank.addCustomerToBranch("Mysore", "Lafoot", 58959);
        // bank.listBranches(true);
    }
}
