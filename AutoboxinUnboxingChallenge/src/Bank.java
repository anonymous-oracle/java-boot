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

    public ArrayList<Branch> getCustomerList() {
        return this.branches;
    }

    public void addBranch(String branchName) {
        Branch newBranch = new Branch(name);
        this.branches.add(newBranch);
    }

    public int searchBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            if (this.branches.get(i).getBranchName() == branchName) {
                return i;
            }
        }
        return -1;
    }

    public boolean branchExists(String name) {
        if (this.searchBranch(name) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Branch getBranch(String branchName) {
        int branchInd = this.searchBranch(branchName);
        if (branchInd == -1) {
            return null;
        }
        return this.branches.get(branchInd);
    }

    public Customer addCustomerToBranch(String branchName, String customerName) {
        Branch branch = this.getBranch(branchName);
        return branch.addCustomer(customerName);
    }

    public void addCustomerToBranch(String branchName, String customerName, double amount) {
        Customer newCustomer = this.addCustomerToBranch(branchName, customerName);
        newCustomer.addTransaction(amount);
    }

    public void listBranches(boolean listCustomers) {
        Branch branch;
        System.out.println("======================================");
        for (int i = 0; i < this.branches.size(); i++) {
            branch = this.branches.get(i);
            System.out.println(branch.getBranchName().toUpperCase());
            if (listCustomers) {
                System.out.println("Listing customers:");
                branch.listCustomers();
            }
            System.out.println("======================================");
        }
    }

    public void listBranches() {
        this.listBranches(false);
    }

}
