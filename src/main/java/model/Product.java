package model;

/**
 *
 * @author jahdiel
 */

public abstract class Product {
    private String productId;
    private String title;
    private double price;
    private int stock;

    public Product(String productId, String title, double price, int stock) {
        this.productId = productId;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

  
    
public abstract String getDescription();
    
    
}
    
