package contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Contacts {
    private static final ArrayList<Contact> contactsList = new ArrayList<>();

    public static int size() {
        return contactsList.size();
    }

    public static void printAll() {
        int i = 0;
        for (Object contact : contactsList) {
            i++;
            if (contact instanceof Person) {
                System.out.printf("%d. %s %s\n", i, ((Person) contact).getName(), ((Person) contact).getSurname());
            } else if (contact instanceof Organization) {
                System.out.printf("%d. %s\n", i, ((Organization) contact).getName());
            }
        }
        System.out.println();
    }

    public static void printRecord(Contact contact) {
        if (contact instanceof Person) {
            System.out.printf("""
                            Name: %s
                            Surname: %s
                            Birth date: %s
                            Gender: %s
                            Number: %s
                            Time created: %s
                            Time last edit: %s
                            
                            """, contact.getName(), ((Person) contact).getSurname(),
                    ((Person) contact).getBirthDate(), ((Person) contact).getGender(),
                    contact.getPhoneNumber(), contact.getTimeCreated().toString(),
                    contact.getTimeLastEdit().toString());
        } else if (contact instanceof Organization) {
            System.out.printf("""
                    Organization name: %s
                    Address: %s
                    Number: %s
                    Time created: %s
                    Time last edit: %s
                    
                    """, contact.getName(), ((Organization) contact).getAddress(),
                    contact.getPhoneNumber(), contact.getTimeCreated().toString(),
                    contact.getTimeLastEdit().toString());
        }
    }

    public static int searchNumber(String query) {
        int i = 0;
        String regex = "(?i).*"+query+".*";
        for (Object contact : contactsList) {
            if (contact instanceof Person) {
                if (((Person) contact).getName().matches(regex)
                        || ((Person) contact).getSurname().matches(regex)) {
                    i++;
                }
            } else if (contact instanceof Organization) {
                if (((Organization) contact).getName().matches(regex)) {
                    i++;
                }
            }
        }
        return i;
    }
    public static Map<Integer, Integer> search(String query) {
        int i = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        String regex = "(?i).*"+query+".*";
        for (Object contact : contactsList) {
            if (contact instanceof Person) {
                String str = ((Person) contact).getFields();
                if (str.matches(regex)) {
                    i++;
                    System.out.printf("%d. %s %s\n", i, ((Person) contact).getName(), ((Person) contact).getSurname());
                    indexMap.put(i, contactsList.indexOf(contact));
                }
            } else if (contact instanceof Organization) {
                String str = ((Organization) contact).getFields();
                if (str.matches(regex)) {
                    i++;
                    System.out.printf("%d. %s\n", i, ((Organization) contact).getName());
                    indexMap.put(i, contactsList.indexOf(contact));
                }
            }
        }
        System.out.println();
        return indexMap;
    }
    public static void remove(int index) {
        contactsList.remove(index -1);
    }

    public static Contact getContact (int index) {
        return contactsList.get(index);
    }
    public static void addContact (Contact contact) {
        contactsList.add(contact);
    }
}
