package com.gamezone.model;

/**
 * Concret class for every seller in GameZone Unicesar
 * It extends from Person and contains specific customer information
 * 
 * @author EstefaniaMarquez
 */

public class Customer extends Person{
    private String eMail;

    public Customer() {
    }
    
    /**
    * Creates a new Customer with the information of Person and the specific data of Customer
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

    /**
     * Returns a String containing the object's data in the order and format
     * required for persistence.
     *
     * @return a String with the object's data formatted for persistence.
     */
    @Override
    
    public String toText() {
        return getiD() + "|" + getName() + "|" + eMail + "|" + getContactNumber();
    }
}
