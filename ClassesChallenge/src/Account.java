package ClassesChallenge.src;

public class Account {
    private String accountNumber;
    private float balance;
    private String customerName;
    private String emailID;
    private String phoneNumber;

    public void setAccountNumber(String accNumber) {
        this.accountNumber = accNumber;
    }

    public void setBalance(double accBalance) {
        this.balance = (float) accBalance;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return (double) this.balance;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getEmailID() {
        return this.emailID;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void depositAmount(double amount) {
        this.balance += (float) amount;
        System.out.println("Updated Balance: " + this.balance);
    }

    public void withdrawAmount(double amount) {
        if (amount <= this.balance) {
            this.balance -= (float) amount;
            System.out.println("Withdrawal of " + amount + " successful");
        } else {
            System.out.println("Insufficient balance! Available balance: " + this.balance);
        }
    }

}
