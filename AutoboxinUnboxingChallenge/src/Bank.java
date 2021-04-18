import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.name = bankName;
        this.branches = new ArrayList<Branch>();
    }

    public String getBankName() {
        return this.name;
    }

    private Branch findBranch(String branchName) {
        Branch checkedBranch;
        for (int i = 0; i < this.branches.size(); i++) {
            checkedBranch = this.branches.get(i);
            if (checkedBranch.getBranchName().equals(branchName)) { // the reason equals is used here is because the String
                                                           // class is not a primitive datatype
                return checkedBranch;
            }
        }
        return null;
    }

    public ArrayList<Branch> getBranchList() {
        return this.branches;
    }

    public boolean addBranch(String branchName) {
        if (this.findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }

        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = this.findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = this.findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = this.findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getBranchName());
            ArrayList<Customer> branchCustomers = branch.getCustomerList();
            Customer branchCustomer;
            for (int i = 0; i < branchCustomers.size(); i++) {
                branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + i + "]");
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("Amount " + transactions.get(j));
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
