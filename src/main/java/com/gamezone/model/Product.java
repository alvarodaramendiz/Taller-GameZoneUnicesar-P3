package com.gamezone.model;

/**
 * Base class for all products in the GameZone Unicesar store.
 * Holds common attributes and behaviors shared by every item.
 *
 * @author jahdiel
 */
public abstract class Product {

    private String productId;
    private String title;
    private double price;
    private int stock;

    /**
     * Creates a new Product.
     *
     * @param productId the unique ID for the product
     * @param title the name of the product
     * @param price the selling price
     * @param stock the amount available in inventory
     */
    public Product(String productId, String title, double price, int stock) {
        this.productId = productId;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    /** @return the unique product ID */
    public String getProductId() {
        return productId;
    }

    /** @return the name of the product */
    public String getTitle() {
        return title;
    }

    /** @return the selling price */
    public double getPrice() {
        return price;
    }

    /** @return the amount available in inventory */
    public int getStock() {
        return stock;
    }

    /** @param productId the product ID to set */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /** @param title the product name to set */
    public void setTitle(String title) {
        this.title = title;
    }

    /** @param price the price to set */
    public void setPrice(double price) {
        this.price = price;
    }

    /** @param stock the stock amount to set */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets the full description of the product based on its subclass
     *
     * @return a text description of the product
     */
    public abstract String getDescription();
}
