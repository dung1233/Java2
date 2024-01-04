package Java2.addressbook;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class AddressBook {
    private static Map<String,Contact> contacts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    public void runAddressBook() {
        int choice;
        do {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    findContactByName();
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
    }
    private void addContact() {
        System.out.print("Enter person's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter person's phone number: ");
        String phone = scanner.nextLine();
        Contact contact = new Contact(name, phone);
        contacts.put(name, contact);
        System.out.println("Contact added successfully!");
    }
    private void findContactByName() {
        System.out.print("Enter the name to find: ");
        String name = scanner.nextLine();
        Contact contact = contacts.get(name);
        if (contact != null) {
            System.out.println("Phone number: " + contact.getPhone());
        } else {
            System.out.println("Not found");
        }
    }
    private void displayContacts() {
        System.out.println("All Contacts in the Address Book:");
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println("Contact Name: " + entry.getKey() + ", Phone Number: " + entry.getValue().getPhone());
        }
    }
}

