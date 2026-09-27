package com.gamezone.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Dominio de venta que incorpora las transacciones de venta entre vendedor y cliente
 * @author ALVARO
 */
public final class Sale {
    
    public class AmountOfProduct { // Clase que agrupa unidades y producto en una misma estructura
        
        private Product soldProduct; // Producto vendido
        private int productAmount; // Unidades del producto vendido

        public AmountOfProduct() {
        }

        public AmountOfProduct(Product soldProduct, int productAmount) {
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
    private ArrayList<AmountOfProduct> productTrack; // 
    private Seller seller; // Vendedor que genera la venta
    private Customer customer; // Consumidor o Cliente que realiza la compra
    private String appliedPromotion; // Nombre de la promoción aplicada a la venta
    private double promotionDiscount; // Valor de descuento promocional del valor total de la venta
    private double totalValue; // Valor total monetario de la venta
    
    // Constructores para inicialización parametrizada
    
    public Sale(long uId, LocalDate date, ArrayList<AmountOfProduct> productTrack, Seller seller, Customer customer, String appliedPromotion, double promotionDiscount) {
        this.uId = uId;
        this.date = date;
        this.productTrack = productTrack;
        this.seller = seller;
        this.customer = customer;
        this.appliedPromotion = appliedPromotion;
        this.promotionDiscount = promotionDiscount;
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

    public ArrayList<AmountOfProduct> getProductTrack() {
        return productTrack;
    }

    public void setProductTrack(ArrayList<AmountOfProduct> productTrack) {
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
    
    public double getTotalValue() {
        return totalValue;
    }
    
    public void setTotalValue(double total) {
        this.totalValue = total;
    }

    public String getAppliedPromotion() {
        return appliedPromotion;
    }

    public void setAppliedPromotion(String appliedPromotion) {
        this.appliedPromotion = appliedPromotion;
    }

    public double getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(double promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }
    
    
    public String receiptGen() {
        
        StringBuilder saleReceipt = new StringBuilder();
        int index = 0;
        
            saleReceipt.append("============== GAMEZONE UNICESAR FACTURA ==============");
            saleReceipt.append("IDENTIFICADOR    :   ").append(uId);
            saleReceipt.append("FECHA DE VENTA   :   ").append(date);
            saleReceipt.append("CLIENTE          :   ").append(customer);
            saleReceipt.append("VENDEDOR         :   ").append(seller);
            saleReceipt.append("================ PRODUCTOS ADQUIRIDOS =================");
        for (AmountOfProduct e: productTrack) {
            index++;
            saleReceipt.append("PRODUCTO  #").append(index).append("  : ").append(e.getSoldProduct());
            saleReceipt.append("CANTIDAD         : ").append(e.getProductAmount());
        }
            saleReceipt.append("===================== VALOR TOTAL =====================");
            saleReceipt.append("PROMOCIÓN        : ").append(appliedPromotion);
            saleReceipt.append("DESCUENTO        : ").append(promotionDiscount);
            saleReceipt.append("VALOR DE LA VENTA: ").append(totalValue/(1-promotionDiscount));
            saleReceipt.append("VALOR A PAGAR    : ").append(totalValue);
        return saleReceipt.toString();
    }
    /**
    * Checks if the sale is eligible for a return within 30 calendar days.
    *
    * @return true if the sale can be returned, false otherwise
    */
    public boolean canBeReturned() {
    LocalDate today = LocalDate.now();
    long days = java.time.temporal.ChronoUnit.DAYS.between(date, today);

    return days >= 0 && days <= 30;
}
}
