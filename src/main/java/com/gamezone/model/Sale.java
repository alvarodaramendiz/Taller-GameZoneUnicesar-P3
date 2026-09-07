package com.gamezone.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Dominio de venta que incorpora las transacciones de venta entre vendedor y cliente
 * @author ALVARO
 */
public class Sale {
    
    public class amountOf_product { // Clase que agrupa unidades y producto en una misma estructura
        
        private Product soldProduct; // Producto vendido
        private int productAmount; // Unidades del producto vendido

        public amountOf_product() {
        }

        public amountOf_product(Product soldProduct, int productAmount) {
            this.soldProduct = soldProduct;
            this.productAmount = productAmount;
        }

        public Product getSoldProduct() {
            return soldProduct;
        }

        public void setSoldProduct(Product soldProduct) {
            this.soldProduct = soldProduct;
        }

        public int getProductAmount() {
            return productAmount;
        }

        public void setProductAmount(int productAmount) {
            this.productAmount = productAmount;
        }
        
        
    }
    
    private long uId; // Identificador único de transacción
    private LocalDate date; // Guardado de fecha local en formato año - mes - día
    private ArrayList<amountOf_product> productTrack; // 
    private Seller seller; // Vendedor que genera la venta
    private Customer costumer; // Consumidor o Cliente que realiza la compra
    
    // Constructores para inicialización vacía y parametrizada
    
    public Sale() {
    }

    public Sale(long uId, LocalDate date, Seller seller, Customer costumer) {
        this.uId = uId;
        this.date = date;
        this.productTrack = new ArrayList<>();
        this.seller = seller;
        this.costumer = costumer;
    }
    
    // Getters y setters para acceder a las variables de instancia

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<amountOf_product> getProduct() {
        return productTrack;
    }

    public void setProductTrack(ArrayList<amountOf_product> productTrack) {
        this.productTrack = productTrack;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Customer getCostumer() {
        return costumer;
    }

    public void setCostumer(Customer costumer) {
        this.costumer = costumer;
    }
    
    
    // Espacio para desarrollar posibles comportamientos del objeto personalizados
    
}
