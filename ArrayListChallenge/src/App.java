public class App {
    public static void main(String[] args) {
        PhoneBook contacts = new PhoneBook();
        contacts.createContact("Blitz", "450-888-4597");
        contacts.createContact("Kraken", "450-825-3497");
        contacts.createContact("Kryptonian", "150-784-1907");
        contacts.listContacts();
        contacts.editNameByName("Kraken", "Kraken2");
        contacts.editNameByName("Kraken2", "Kraken");

        contacts.removeContactByName("Blitz");
        contacts.listContacts();
        
    }
}
