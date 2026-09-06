/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jahdiel
 */
public class VideoGame extends Product {
    private String platform;
    private String genre;
    private String ageRating; // Sistema ESRB (América): "E" (Everyone), "E10+", "T" (Teen), "M" (Mature 17+), "AO" (Adults Only).
    
    @Override
    public  String getDescription(){
    return getTitle() + " for " + platform + " ( " + genre +  " ) - clasification: " + ageRating;
    }
    
}
