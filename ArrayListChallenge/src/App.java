import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PhoneBook contacts = new PhoneBook();
        boolean quit = false;
        int action;
        startPhone();
        printActionsList();
        while (!quit) {
            action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
            case 0:
                System.out.println("\nShutting down...");
                quit = true;
                break;

            case 1:
                contacts.listContacts();
                break;

            case 2:
                System.out.println("Enter the name of the contact to be created");
                String name = scanner.nextLine();
                System.out.println("Enter the number of the contact");
                String number = scanner.nextLine();
                contacts.createContact(name, number);
                System.out.println("Contact created");
                break;
            case 3:
                System.out.println("Enter the name of the contact to be updated");
                String contactName = scanner.nextLine();
                System.out.println("Enter new name");
                String newName = scanner.nextLine();
                contacts.editNameByName(contactName, newName);
                System.out.println("Contact updated");
                break;
            case 4:
                System.out.println("Enter the name of the contact to be removed");
                String removedName = scanner.nextLine();
                contacts.removeContactByName(removedName);
                System.out.println("Contact removed");
                break;
            case 5:
                System.out.println("Enter the name of the contact to be searched");
                String findName = scanner.nextLine();
                if (contacts.findByName(findName)) {
                    System.out.println("Contact exists");
                } else {
                    System.out.println("Contact does not exist");
                }
                break;
            case 6:
                printActionsList();
                break;
            }
        }
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActionsList() {
        System.out.println("\nAvailable actions\nPress: ");
        System.out.println("0 - to shutdown\n" + "1 - to print contacts\n" + "2 - to add a new contact\n"
                + "3 - to update existing contact\n" + "4 - to remove an existing contact\n"
                + "5 - query if an existing contact exists\n" + "6 - to print the list of available actions");
    }
}
