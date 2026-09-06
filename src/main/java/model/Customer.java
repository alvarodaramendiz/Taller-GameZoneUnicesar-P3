package model;

//import java.util.ArrayList;

/**
 * Concret class for every seller in GameZone Unicesar
 * It extends from Person and contains specific customer information
 * 
 * @author EstefaniaMarquez
 */

public class Customer extends Person{
    private String eMail;
    //private ArrayList<Purchase> purchase;

    public Customer() {
    }
    
    /**
    * Creates a new Seller with the information of Person and the specific data of Seller
    * 
    * @param name the name of each customer
    * @param iD the identification number of each customer
    * @param contactNumber the contact number of each customer
    * @param eMail the email of each customer
    */ 
    
    public Customer(String eMail, String name, long iD, long contactNumber) {
        super(name, iD, contactNumber);
        this.eMail = eMail;
    }

    /**
    * Gets the personal eMail of each customer
    * @return the customer eMail 
    */
    
    public String geteMail() {
        return eMail;
    }
    
    /**
    * Sets the personal eMail of each customer
    * @param eMail sets the customer eMail 
    */

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
