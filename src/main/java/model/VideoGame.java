package model;

/**
 * Represents a video game in the GameZone Unicesar store.
 * Adds specific attributes like platform, genre, and age rating.
 *
 * @author jahdiel
 */
public class VideoGame extends Product {

    private String platform;
    private String genre;
    private String ageRating; // ESRB rating system (America): "E" (Everyone), "E10+", "T" (Teen), "M" (Mature 17+), "AO" (Adults Only).

    /**
     * Creates a new VideoGame.
     *
     * @param platform the platform for the game
     * @param genre the genre of the game
     * @param ageRating the recommended age rating
     * @param productId the unique ID for the product
     * @param title the name of the product
     * @param price the selling price
     * @param stock the amount available in inventory
     */
    public VideoGame(String platform, String genre, String ageRating, String productId, String title, double price, int stock) {
        super(productId, title, price, stock);
        this.platform = platform;
        this.genre = genre;
        this.ageRating = ageRating;
    }

    /** @return the platform for the game */
    public String getPlatform() {
        return platform;
    }

    /** @return the genre of the game */
    public String getGenre() {
        return genre;
    }

    /** @return the age rating */
    public String getAgeRating() {
        return ageRating;
    }

    /** @param platform the platform to set */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /** @param genre the genre to set */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /** @param ageRating the age rating to set */
    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    /**
     * @return a full description of the video game details
     */
    @Override
    public String getDescription() {
        return getTitle() + " for " + platform + " (" + genre + ") - Classification: " + ageRating;
    }
}
