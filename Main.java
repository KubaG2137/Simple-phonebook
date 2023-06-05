package contacts;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Action> actionMap = new HashMap<>();
        actionMap.put("add", new ActionAdd());
        actionMap.put("list", new ActionList());
        actionMap.put("search", new ActionSearch());
        actionMap.put("count", new ActionCount());
        boolean status = true;
        do {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            String command = scanner.next();
            switch (command) {
                case "exit":
                    status = false;
                    break;
                case "add", "list", "search", "count":
                    Action action = actionMap.get(command);
                    action.execute();
                    break;
                default:
                    System.out.println("Action unavailable");
            }
        } while (status);
    }
}