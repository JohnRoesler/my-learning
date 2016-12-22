package src.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Z001W4M on 12/21/2016.
 */
public class MobilePhone {

    Scanner scanner = new Scanner(System.in);
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void powerOn(){
        boolean flag = true;
        printOptions();
        while (flag){
            System.out.println("Select a menu option: ");
            int selection = scanner.nextInt();
            scanner.nextLine();
            switch (selection){
                case 0:
                    printOptions();
                    break;
                case 1:
                    printContactList();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateExistingContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContacts();
                    break;
                case 6:
                    flag = false;
                    break;
            }


        }

    }
    private boolean contactExists(Contact contact){
        if(contacts.contains(contact)){
            return true;
        }
        return false;
    }

    private void printOptions(){
        System.out.println("Mobile phone menu options: \n" +
                "0 - Reprint the menu options\n" +
                "1 - Print the contact list\n" +
                "2 - Add a new contact\n" +
                "3 - Update an existing contact\n" +
                "4 - Remove a contact\n" +
                "5 - Search contact list\n" +
                "6 - Close the menu");
    }

    private void printContactList(){
        System.out.println("You have " + contacts.size() + " in your contact list: ");
        for (int i = 0; i < contacts.size(); i++){
            System.out.println("Name: " + contacts.get(i).getName() + " #: " + contacts.get(i).getNumber());
        }
    }

    private void addNewContact(){
        System.out.println("Enter the contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the contact number: ");
        String number = scanner.nextLine();
        if (contactExists(Contact.createContact(name,number))){
            System.out.println("A contact already exists with the same name and number.");
            return;
        }
        contacts.add(Contact.createContact(name, number));
        System.out.println("You created contact: " + name + " " + number);

    }

    private void updateExistingContact(){
        System.out.println("Enter the name or number of the contact to be updated: ");
        String nameNum = scanner.nextLine();
        int position = findContactPosition(nameNum);
        if (position < 0){
            System.out.println("No contact matched the name/number provided.");
            return;
        }
        System.out.println("Enter the new name (if no change enter blank): ");
        String newName = scanner.nextLine();
        System.out.println("Enter the new number (if no change enter blank: ");
        String newNumber = scanner.nextLine();
        if (newName.equals("") && !newNumber.equals("")){
            contacts.set(position, Contact.createContact(contacts.get(position).getName(),newNumber));
        }else if(!newName.equals("") && newNumber.equals("")){
            contacts.set(position, Contact.createContact(newName, contacts.get(position).getNumber()));
        }else if(!newName.equals("") && !newNumber.equals("")){
            contacts.set(position, Contact.createContact(newName,newNumber));
        }else {
            System.out.println("You did not enter a name or number.");
        }
    }

    private int findContactPosition(String nameNum){
        int position = 0;
        for (int i =0; i < contacts.size();i++){
            if (nameNum.equals(contacts.get(i).getName()) || nameNum.equals(contacts.get(i).getNumber())){
                position = i;
                return position;
            }
        }
        return -1;
    }

    private void removeContact(){
        System.out.println("Enter the contact name or number to be removed: ");
        String nameNum = scanner.nextLine();
        int position = findContactPosition(nameNum);
        if (position < 0){
            System.out.println("No contact matched the name/number provided.");
            return;
        }
        contacts.remove(position);
    }

    private void searchContacts(){
        System.out.println("Enter the contact name or number to search: ");
        String nameNum = scanner.nextLine();
        int position = findContactPosition(nameNum);
        if (position < 0){
            System.out.println("No contact matched the name/number provided.");
            return;
        }
        System.out.println("Contact list contains \nName: " + contacts.get(position).getName() + " #: " + contacts.get(position).getNumber());
    }

}
