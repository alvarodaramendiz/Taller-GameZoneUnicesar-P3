package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Customer;
import utilities.PlainArchives;

 /**
  * Data Access Object (DAO) responsible for the persistence of Customer objects.
  * It provides methods to search, save, and list customers using the project's
  * persistence storage.
  *
  * @author EstefaniaMarquez
  */
public class CustomerDAO {

    /**
     * Saves a single Customer record by appending it to the persistence file.
     * The record is stored in the format: ID|name|email|contactNumber.
     *
     * @param customer the Customer record to be saved.
     */
    public void saveCustomer(Customer customer) {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(PlainArchives.CUSTOMERS, true))) {
            bw.write(customer.toText());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error: Failed to save the customer record.");
        }
    }

    /**
     * Retrieves all Customer records stored in the persistence file. Each
     * record is read and converted into a Customer object.
     *
     * @return an ArrayList containing all stored Customer records.
     */
    
    public ArrayList<Customer> listCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(PlainArchives.CUSTOMERS))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] infoCustomer = line.split("\\|");
                long contactNumber, iD;
                contactNumber = Long.parseLong(infoCustomer[3]);
                iD = Long.parseLong(infoCustomer[0]);
                customers.add(new Customer(infoCustomer[2], infoCustomer[1], iD, contactNumber));
            }
        } catch (IOException e) {
            System.out.println("Error: Failed to list the customers record.");
        }
        return customers;
    }

    /**
     * Searches for a Customer by its ID among the stored Customer records.
     *
     * @param id the ID of the Customer to search for.
     * @return the Customer with the specified ID, or {@code null} if no
     * matching Customer is found.
     */
    public Customer searchCustomer(long id) {
        ArrayList<Customer> customers = listCustomers();
        for (Customer currentC : customers) {
            if (id == currentC.getiD()) {
                return currentC;
            }
        }
        return null;
    }
    
}
