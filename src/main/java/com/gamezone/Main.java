package com.gamezone;

import com.gamezone.persistence.SalePersistence;
import com.gamezone.service.SaleService;
import com.gamezone.ui.MainFrame;
import com.gamezone.persistence.CustomerPersistence;
import com.gamezone.persistence.SellerPersistence;
// import com.gamezone.persistence.ProductDAO;
/**
 *  Clase principal, conexión entre las capas de arquitectura persistencia, lógica y UI
 * 
 * @author ALVARO
 */
public class Main {
    
    
    SellerPersistence SellerDAO = new SellerPersistence();
    CustomerPersistence CustomerDAO = new CustomerPersistence();
//    ProductDAO ProductDAO = new ProductDAO();
    
//    CustomerService CustomerService = new CustomerService(SellerPersistence);     
//    SellerService SellerService = new SellerService(CustomerPersistence);
//    ProductService ProductService = new ProductService(ProductDAO);
    
//    SalePersistence salePersistence = new salePersistence(personService, productService);
//    SaleService saleService = new (salePersistence, personDAO, productDAO);
//
    
    public static void main(String[] args) {
        MainFrame ui = new MainFrame();
        ui.setVisible(true);
    }
}
