package contacts;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Edit {
    public static void edit (Contact contact) {
        Scanner scanner = new Scanner(System.in);
        String command;
        if (contact instanceof Person) {
            System.out.print("Select a field (name, surname, birth, gender, number): ");
            command = scanner.next();
            System.out.print("Enter " + command + ": ");
            scanner.nextLine();
            String value = scanner.nextLine();
            switch (command) {
                case "name" -> contact.setName(value);
                case "surname" -> ((Person) contact).setSurname(value);
                case "birth" -> ((Person) contact).setBirthDate(value);
                case "gender" -> ((Person) contact).setGender(value);
                case "number" -> contact.setPhoneNumber(value);
            }
            contact.setTimeLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
        } else if (contact instanceof Organization) {
            System.out.print("Select a field (address, number): ");
            command = scanner.next();
            System.out.print("Enter " + command + ": ");
            scanner.nextLine();
            String value = scanner.nextLine();
            switch (command) {
                case "address" -> ((Organization) contact).setAddress(value);
                case "number" -> contact.setPhoneNumber(value);
            }
        }
        System.out.println("Saved\n");
    }
}
