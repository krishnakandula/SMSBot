package data.models;

/**
 * Created by krishnakandula on 1/20/17.
 */
public class Contact {
    private int id;
    private String name;
    private String phoneNumber;

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
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(getName()+ "|").append(getPhoneNumber()).append("]");
        return builder.toString();
    }
}
