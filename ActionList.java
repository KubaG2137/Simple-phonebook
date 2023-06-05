package contacts;

import java.util.Scanner;

public class ActionList implements Action{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Contacts.printAll();
        System.out.print("[list] Enter action ([number], back]: ");
        String command = scanner.next();
        if (command.matches("\\d+")) {
            int index = Integer.parseInt(command) -1;
            Contact contact = Contacts.getContact(index);
            Contacts.printRecord(contact);
            System.out.print("[record] Enter action (edit, delete, menu): ");
            String action = scanner.next();
            if (action.equals("edit")){
                Edit.edit(contact);
                Contacts.printRecord(contact);
            } else if (action.equals("delete")) {
                Contacts.remove(index);
                System.out.println("The record removed!\n");
            }
        }
    }
}
