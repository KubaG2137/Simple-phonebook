package contacts;

import java.time.LocalDateTime;

public class Contact {

    private String name;
    private String phoneNumber;
    private LocalDateTime timeCreated;
    private LocalDateTime timeLastEdit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isNumberValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "[no number]";
            System.out.println("Wrong number format!");
        }
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDateTime getTimeLastEdit() {
        return timeLastEdit;
    }

    public void setTimeLastEdit(LocalDateTime timeLastEdit) {
        this.timeLastEdit = timeLastEdit;
    }

    private boolean isNumberValid(String phoneNumber){
        String regexPattern = "\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*";
        return phoneNumber.matches(regexPattern);
    }
}