package contacts;

public class Person extends Contact {

    private String surname;
    private String birthDate;
    private String gender;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        if (isDateValid(birthDate)){
            this.birthDate = birthDate;
        } else {
            System.out.println("Bad birth date!");
            this.birthDate = "[no data]";
        }

    }

    public String getFields() {
        return getName() + getSurname() + getGender() + getBirthDate() + getPhoneNumber();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender.equals("F") || gender.equals("M")){
            this.gender = gender;
        } else {
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        }
    }

    private boolean isDateValid(String date){
        String regexPattern = "\\d+-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1])";
        return date.matches(regexPattern);
    }
}
