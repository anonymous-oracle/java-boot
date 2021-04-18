public class App {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI");
        bank.addBranch("Mysore");
        bank.addCustomer("Mysore", "Lafoot", 599);
        bank.addCustomer("Mysore", "Lafoot2", 589);
        bank.addCustomer("Mysore", "Lafoot3", 559);
        bank.addCustomer("Mysore", "Lafoot4", 959);

        bank.addBranch("Coorg");
        bank.addCustomer("Coorg", "Coorg Lafoot", 8949);

        bank.addCustomerTransaction("Mysore", "Lafoot2", 23.2);
        bank.addCustomerTransaction("Mysore", "Lafoot2", 14.2);
        bank.addCustomerTransaction("Mysore", "Lafoot4", 27.2);

        bank.listCustomers("Mysore", false);
        bank.listCustomers("Mysore", true);
    }
}
