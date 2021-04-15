import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<ContactClass> contactList = new ArrayList<ContactClass>();

    public void createContact(String name, String number) {
        ContactClass contact = new ContactClass(name, number);
        this.contactList.add(contact);
    }

    public void listContacts() {
        System.out.println("Contact list: ");
        for (int i = 0; i < this.contactList.size(); i++) {
            System.out.println(this.contactList.get(i).representationString());
        }
    }

    private int searchContactByName(String name) {
        for (int i = 0; i < this.contactList.size(); i++) {
            if (this.contactList.get(i).getName() == name) {
                return i;
            }
        }
        return -1;
    }

    private int searchContactByNumber(String number) {
        for (int i = 0; i < this.contactList.size(); i++) {
            if (this.contactList.get(i).getName() == number) {
                return i;
            }
        }
        return -1;
    }

    public void editNameByName(String name, String newName) {
        int foundIndex = this.searchContactByName(name);
        if (foundIndex != -1) {
            ContactClass contact = this.contactList.get(foundIndex);
            this.contactList.set(foundIndex, new ContactClass(newName, contact.getNumber()));
        }
    }

    public void editNameByNumber(String number, String newName) {
        int foundIndex = this.searchContactByNumber(number);
        if (foundIndex != -1) {
            ContactClass contact = this.contactList.get(foundIndex);
            this.contactList.set(foundIndex, new ContactClass(newName, contact.getNumber()));
        }
    }

    public void editNumberByName(String name, String newNumber) {
        int foundIndex = this.searchContactByName(name);
        if (foundIndex != -1) {
            ContactClass contact = this.contactList.get(foundIndex);
            this.contactList.set(foundIndex, new ContactClass(contact.getName(), newNumber));
        }
    }

    public void editNumberByNumber(String number, String newNumber) {
        int foundIndex = this.searchContactByNumber(number);
        if (foundIndex != -1) {
            ContactClass contact = this.contactList.get(foundIndex);
            this.contactList.set(foundIndex, new ContactClass(contact.getName(), newNumber));
        }
    }

    public void removeContactByName(String name) {
        int foundIndex = this.searchContactByName(name);
        if (foundIndex != -1) {
            this.contactList.remove(foundIndex);
        }
    }

    public void removeContactByNumber(String number) {
        int foundIndex = this.searchContactByName(number);
        if (foundIndex != -1) {
            this.contactList.remove(foundIndex);
        }
    }
}
