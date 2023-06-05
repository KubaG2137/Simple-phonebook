package contacts;

public class ActionCount implements Action {
    @Override
    public void execute() {
        System.out.printf("The Phone Book has %d records.\n", Contacts.size());
    }
}
