package com.gamezone;

import com.gamezone.persistence.SalePersistence;
import com.gamezone.service.SaleService;
import com.gamezone.ui.UserInterface;
import com.gamezone.persistence.CustomerDAO;
import com.gamezone.persistence.SellerDAO;
// import com.gamezone.persistence.ProductDAO;

/**
 *  Clase principal, conexión entre las capas de arquitectura persistencia, lógica y UI
 * 
 * @author ALVARO
 */
public class Main {
    
    
    SellerDAO SellerDAO = new SellerDAO();
    CustomerDAO CustomerDAO = new CustomerDAO();
//    ProductDAO ProductDAO = new ProductDAO();
    
//    CustomerService CustomerService = new CustomerService(SellerDAO);     
//    SellerService SellerService = new SellerService(CustomerDAO);
//    ProductService ProductService = new ProductService(ProductDAO);
    
//    SalePersistence salePersistence = new salePersistence(personService, productService);
//    SaleService saleService = new (salePersistence, personDAO, productDAO);
//
    
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.setVisible(true);
    }
}
