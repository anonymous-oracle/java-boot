import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.name = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return this.name;
    }

    public ArrayList<Customer> getCustomerList() {
        return this.customers;
    }

    public boolean newCustomer(String customerName, double initialAmount) {
        if (this.findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName) {
        Customer checkedCustomer;
        for (int i = 0; i < this.customers.size(); i++) {
            checkedCustomer = this.customers.get(i);
            if (checkedCustomer.getName().equals(customerName)) { // the reason equals is used here is because the String
                                                              // class is not a primitive datatype
                return checkedCustomer;
            }
        }
        return null;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = this.findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }
}
