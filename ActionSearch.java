package contacts;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class ActionSearch implements Action {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        boolean status = true;
        String i ="";
        Map <Integer, Integer> indexMap = new HashMap<>();
        while (status){
            System.out.print("Enter search query: ");
            String query = scanner.next();
            int numberOfRecords = Contacts.searchNumber(query);
            System.out.printf("Found %d results:\n", numberOfRecords);
            indexMap = Contacts.search(query);
            System.out.print("[search] Enter action ([number], back, again): ");
            i = scanner.next();
            if (numberOfRecords == 0) {
                break;
            }
            if (i.matches("\\d+") || i.equals("back")){
                status = false;
            }
            if (i.matches("\\d+")){
                int index = indexMap.get(Integer.parseInt(i));
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
}
