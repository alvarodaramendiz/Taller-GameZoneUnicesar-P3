package model;

public class Person {
    private String name;
    private long iD;
    private long contactNumber;

    public Person() {
    }

    public Person(String name, long iD, long contactNumber) {
        this.name = name;
        this.iD = iD;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getiD() {
        return iD;
    }

    public void setiD(long iD) {
        this.iD = iD;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    
}
