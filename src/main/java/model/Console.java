package model;
/**
 * Represents a console in the GameZone Unicesar store.
 * Adds specific attributes like brand, model, and generation.
 *
 * @author jahdiel
 */
public class Console extends Product {
    private String brand;
    private String model;
    private String generation;
    
    /**
     * Creates a new Console.
     *
     * @param brand the brand of the console
     * @param model the specific model type
     * @param generation the console generation
     * @param productId the unique ID for the product
     * @param title the name of the product
     * @param price the selling price
     * @param stock the amount available in inventory
     */

    public Console(String brand, String model, String generation, String productId, String title, double price, int stock) {
        super(productId, title, price, stock);
        this.brand = brand;
        this.model = model;
        this.generation = generation;
    }

/** @return the brand of the console */
    public String getBrand() {
        return brand;
    }

    /** @return the specific model */
    public String getModel() {
        return model;
    }

    /** @return the console generation */
    public String getGeneration() {
        return generation;
    }

    /** @param brand the brand name to set */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /** @param model the model type to set */
    public void setModel(String model) {
        this.model = model;
    }

    /** @param generation the generation to set */
    public void setGeneration(String generation) {
        this.generation = generation;
    }

    /**
     * @return a full description of the console details
     */
    @Override
    public String getDescription() {
        return getTitle() + " - Brand: " + brand + " (Model: " + model + ") - Generation: " + generation;
    }
    /**
     * Converts this console into a text line for persistence, including
     * the common product attributes plus brand, model, and generation.
     *
     * @return a text representation of the console
     */
    @Override
    public String toText() {
        return "CONSOLE|" + super.toText() + "|" + brand + "|" + model + "|" + generation;
    }
    
}
