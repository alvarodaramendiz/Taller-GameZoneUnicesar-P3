package persistence;

import model.Customer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CustomerDAO {
    //Acceso a Datos: CRUD, Persistencia, Métodos de Búsqueda
    
    private Customer customer;
    
    public void createCustomer(){
        String name, eMail;
        long iD, contactNumber;
        name = "Inserta el .getText acá XD";
        eMail = "Inserta el .getText acá";
        iD = 123456;
        contactNumber = 32020202;
        customer = new Customer(eMail, name, iD, contactNumber);
    }
    
    public Customer searchCustomer(long customerID){
        Customer actualC = null;
        return actualC;
    }
    
    public void updateCustomer(){
        
    }
    
    public void deleteCustomer(){
        
    }
    
    public void saveCustomers(){
        
    }
    
    public void loadCustomers(){
        
    }
}
