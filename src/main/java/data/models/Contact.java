package data.models;

/**
 * Created by krishnakandula on 1/20/17.
 */
public class Contact {
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(){
        this.id = generateRandomId();
    }

    private static int generateRandomId(){
        int min = 0; int max = 100000;
        int randomId = (int) ((Math.random()) * (max - min) + min);
        return randomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        String description = String.format("NAME: %s | NUMBER: %s", getName(), getPhoneNumber());
        return description;
    }
}
