package contacts;

class Organization extends Contact {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFields() {
        return getName() + getAddress() + getPhoneNumber();
    }
}
