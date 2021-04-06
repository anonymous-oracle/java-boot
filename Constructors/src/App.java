package Constructors.src;

public class App {
    public static void main(String[] args) {
        Account account = new Account("18178187", 4184978, "abc", "abc@abc.com", "4894984869");
        System.out.println(account.getAccountNumber());
        Account newAccount = new Account();
        System.out.println(newAccount.getBalance());
    }
}
