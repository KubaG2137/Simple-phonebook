package contacts;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ActionAdd implements Action {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("[add] Enter the type (person, organization): ");
        String type = scanner.next();
        LocalDateTime.now().withSecond(0).withNano(0);
        switch (type) {
            case "person":
                Person person = new Person();
                System.out.print("Enter the name: ");
                person.setName(scanner.next());
                System.out.print("Enter the surname: ");
                person.setSurname(scanner.next());
                System.out.print("Enter birth date: ");
                scanner.nextLine();
                person.setBirthDate(scanner.nextLine());
                System.out.print("Enter the gender (M, F): ");
                person.setGender(scanner.nextLine());
                System.out.print("Enter the number: ");
                person.setPhoneNumber(scanner.nextLine());
                person.setTimeCreated(LocalDateTime.now().withSecond(0).withNano(0));
                person.setTimeLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
                Contacts.addContact(person);
                break;
            case "organization":
                Organization org = new Organization();
                System.out.print("Enter the organization name: ");
                scanner.nextLine();
                org.setName(scanner.nextLine());
                System.out.print("Enter the address: ");
                org.setAddress(scanner.nextLine());
                System.out.print("Enter the number: ");
                org.setPhoneNumber(scanner.nextLine());
                org.setTimeCreated(LocalDateTime.now().withSecond(0).withNano(0));
                org.setTimeLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
                Contacts.addContact(org);
        }
        System.out.println("The record added.\n");
    }
}