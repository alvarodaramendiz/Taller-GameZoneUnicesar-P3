package com.gamezone.model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Return {
    private String idReturn;
    private LocalDate date;
    private Sale sale;
    private ArrayList<Product> returnedProducts;
    private String returnReason;
    private double reimbursedAmount;

    public Return(String idReturn, LocalDate date, Sale sale, ArrayList<Product> returnedProducts, String returnReason, double reimbursedAmount) {
        this.idReturn = idReturn;
        this.date = date;
        this.sale = sale;
        this.returnedProducts = returnedProducts;
        this.returnReason = returnReason;
        this.reimbursedAmount = reimbursedAmount;
    }
    

    public String getIdReturn() {
        return idReturn;
    }

    public LocalDate getDate() {
        return date;
    }

    public Sale getSale() {
        return sale;
    }

    public ArrayList<Product> getReturnedProducts() {
        return returnedProducts;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public double getReimbursedAmount() {
        return reimbursedAmount;
    }


    public double calculateRefundAmount(){
        double finalAmount = 0;
        for (Product product : returnedProducts){
            finalAmount+= product.getPrice();
        }
        this.reimbursedAmount = finalAmount;
        return finalAmount;
    }
    
    
    public String generateReturnReceipt(){
        StringBuilder receipt = new StringBuilder();
         receipt.append("============== GAMEZONE UNICESAR RETURN ==============\n");
        receipt.append("IDENTIFIER     : ").append(idReturn).append("\n");
        receipt.append("RETURN DATE    : ").append(date).append("\n");
        receipt.append("ORIGINAL SALE  : ").append(sale.getuId()).append("\n");
        receipt.append("================ RETURNED PRODUCTS ===================\n");
        int index = 0;
        for (Product product : returnedProducts) {
            index++;
            receipt.append("PRODUCT #").append(index).append("       : ")
                    .append(product.getTitle())
                    .append(" - $").append(product.getPrice()).append("\n");
        }
        receipt.append("REASON             : ").append(returnReason).append("\n");
        receipt.append("REFUND AMOUNT  : $").append(reimbursedAmount).append("\n");
        return receipt.toString();
    }
    
}
