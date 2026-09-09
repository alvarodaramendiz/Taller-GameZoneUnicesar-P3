package com.gamezone.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Dominio de venta que incorpora las transacciones de venta entre vendedor y cliente
 * @author ALVARO
 */
public final class Sale {
    
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
    private Customer customer; // Consumidor o Cliente que realiza la compra
    private double totalValue; // Valor total monetario de la venta
    
    // Constructores para inicialización parametrizada
    
    public Sale(long uId, LocalDate date, ArrayList<amountOf_product> productTrack, Seller seller, Customer customer) {
        this.uId = uId;
        this.date = date;
        this.productTrack = productTrack;
        this.seller = seller;
        this.customer = customer;
        this.totalValue = 0;
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

    public ArrayList<amountOf_product> getProductTrack() {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCostumer(Customer costumer) {
        this.customer = costumer;
    }
    
    
    // Espacio para desarrollar posibles comportamientos del objeto personalizados
    
    public double saleTotalValue() {
        double resultValue = 0;
        for (amountOf_product p: productTrack) {
            double price;
            double amount;
            amount = p.getProductAmount();
            price = p.getSoldProduct().getPrice();
            resultValue+=(price*amount);
        }
        return resultValue;
    }
    
    public String receiptGen() {
        
        StringBuilder saleReceipt = new StringBuilder();
        int index = 0;
        
            saleReceipt.append("============== GAMEZONE UNICESAR FACTURA ==============");
            saleReceipt.append("IDENTIFICADOR  :   ").append(uId);
            saleReceipt.append("FECHA DE VENTA :   ").append(date);
            saleReceipt.append("CLIENTE        :   ").append(customer);
            saleReceipt.append("VENDEDOR       :   ").append(seller);
            saleReceipt.append("================ PRODUCTOS ADQUIRIDOS =================");
        for (amountOf_product e: productTrack) {
            index++;
            saleReceipt.append("PRODUCTO  #").append(index).append("  : ").append(e.getSoldProduct());
            saleReceipt.append("CANTIDAD       : ").append(e.getProductAmount());
        }
            saleReceipt.append("VALOR TOTAL    : ").append(totalValue);
        return saleReceipt.toString();
    }
}
