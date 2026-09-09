package com.gamezone.service;

import com.gamezone.model.Customer;
import com.gamezone.persistence.CustomerDAO;
import java.util.ArrayList;

/**
 *
 * Service class responsible for managing customer operations. It validates
 * customer information and coordinates the interaction between the application
 * logic and the customer persistence layer.
 *
 *
 * @author EstefaniaMarquez
 */
public class CustomerService {

    private CustomerDAO customerDAO;

    /**
     * * Validates the information provided for a customer. 
     * 
     * @param eMail the email address of the customer. 
     * @param name the name of the customer. 
     * @param iD the identification number of the customer. 
     * @param contactNumber the contact number of the customer. 
     * @throws IllegalArgumentException if any of the provided information is 
     * invalid or if a customer with the given ID already exists.
     */
    
    public void validateCustomer(String eMail, String name, long iD, long contactNumber) {

        if (eMail == null || eMail.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        
        if (!eMail.contains("@") || !eMail.contains(".")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Name cannot contain numbers");
        }

        if (iD <= 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }

        if (contactNumber <= 0) {
            throw new IllegalArgumentException("Contact number cannot be negative");
        }

    }

    /**
     * Creates a new customer after validating the provided information. 
     * The customer is stored through the persistence layer if all information 
     * is valid and the ID is not already registered. 
     * @param eMail the email address of the customer. 
     * @param name the name of the customer. 
     * @param iD the identification number of the customer. 
     * @param contactNumber the contact number of the customer. 
     * @throws IllegalArgumentException if any of the provided information is 
     * invalid or if a customer with the given ID already exists.
     */
    
    public void registerCustomer(String eMail, String name, long iD, long contactNumber) {
        validateCustomer(eMail, name, iD, contactNumber);
        if (searchCustomer(iD) != null) {
            throw new IllegalArgumentException("A customer with this ID already exists");
        }
        Customer customer = new Customer(eMail, name, iD, contactNumber);
        customerDAO.saveCustomer(customer);
    }

    /**
     * Updates an existing customer with the provided information. * 
     * @param iD the identification number of the customer to update. 
     * @param eMail the new email address of the customer. 
     * @param name the new name of the customer. 
     * @param contactNumber the new contact number of the customer.
     * @throws IllegalArgumentException if the customer does not exist or if *
     * the provided information is invalid.
     */
    
    public void updateCustomer(long iD, String eMail, String name, long contactNumber) {
        Customer customer = searchCustomer(iD);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        validateCustomer(eMail, name, iD, contactNumber);
        customer.seteMail(eMail);
        customer.setName(name);
        customer.setContactNumber(contactNumber);
        customerDAO.updateCustomer(customer);
    }

    /**
     * Deletes an existing customer from the persistence layer.
     * @param iD the identification number of the customer to delete. 
     * @throws IllegalArgumentException if no customer with the given ID exists.
     */
    
    public void deleteCustomer(long iD) {
        Customer customer = searchCustomer(iD);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        customerDAO.deleteCustomer(iD);
    }

    /** 
     * Retrieves all customers stored in the persistence layer. 
     * 
     * @return an ArrayList containing all stored customers. 
     */
    
    public ArrayList<Customer> listCustomers() {
        return customerDAO.listCustomers();
    }
    
    /** * Searches for a customer by its identification number. 
     * 
     * @param iD the identification number of the customer to search for. 
     * @return the customer with the specified ID, or {@code null} if no matching 
     * customer is found. 
     */

    public Customer searchCustomer(long iD) {
        return customerDAO.searchCustomer(iD);
    }
}
