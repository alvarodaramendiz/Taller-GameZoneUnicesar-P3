package model;

public class Customer extends Person{
    private String eMail;
    //private Purchase purchase;

    public Customer() {
    }
    
    public Customer(String eMail, String name, long iD, long contactNumber) {
        super(name, iD, contactNumber);
        this.eMail = eMail;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    //Metodos de clase Customer: addPurchase, searchPurchase, removePurchase
}
