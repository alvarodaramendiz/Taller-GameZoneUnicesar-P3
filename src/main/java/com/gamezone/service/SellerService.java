package com.gamezone.service;

import com.gamezone.model.Seller;
import com.gamezone.model.Shift;
import com.gamezone.persistence.SellerDAO;
import java.util.ArrayList;

/**
 *
 * Service class responsible for managing seller operations. It validates
 * seller information and coordinates the interaction between the application
 * logic and the seller persistence layer.
 *
 *
 * @author EstefaniaMarquez
 */

public class SellerService {

    private SellerDAO sellerDAO;

    /**
     * Validates the information provided for a seller.
     *
     * @param employeeCode the unique employee code of the seller.
     * @param shift the work shift assigned to the seller.
     * @param name the name of the seller.
     * @param iD the identification number of the seller.
     * @param contactNumber the contact number of the seller.
     * @throws IllegalArgumentException if any of the provided information
     * is invalid.
     */
    
    public void validateSeller(long employeeCode, Shift shift, String name,
            long iD, long contactNumber) {

        if (employeeCode <= 0) {
            throw new IllegalArgumentException(
                    "Employee code must be greater than zero");
        }

        if (shift == null) {
            throw new IllegalArgumentException("Shift cannot be null");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (name.matches(".*\\d.*")) {
            throw new IllegalArgumentException(
                    "Name cannot contain numbers");
        }

        if (iD <= 0) {
            throw new IllegalArgumentException(
                    "ID must be greater than zero");
        }

        if (contactNumber <= 0) {
            throw new IllegalArgumentException(
                    "Contact number must be greater than zero");
        }
    }

    /**
     * Registers a new seller after validating the provided information.
     * The seller is stored through the persistence layer if all information
     * is valid and the employee code is not already registered.
     *
     * @param employeeCode the unique employee code of the seller.
     * @param shift the work shift assigned to the seller.
     * @param name the name of the seller.
     * @param iD the identification number of the seller.
     * @param contactNumber the contact number of the seller.
     * @throws IllegalArgumentException if any of the provided information
     * is invalid or if a seller with the given employee code already exists.
     */
    
    public void registerSeller(long employeeCode, Shift shift, String name,
            long iD, long contactNumber) {

        validateSeller(employeeCode, shift, name, iD, contactNumber);

        if (searchSeller(employeeCode) != null) {
            throw new IllegalArgumentException(
                    "A seller with this employee code already exists");
        }

        Seller seller = new Seller(employeeCode, shift, name, iD, contactNumber);
        sellerDAO.saveSeller(seller);
    }

    /**
     * Updates an existing seller with the provided information.
     *
     * @param employeeCode the employee code of the seller to update.
     * @param shift the new work shift of the seller.
     * @param name the new name of the seller.
     * @param iD the new identification number of the seller.
     * @param contactNumber the new contact number of the seller.
     * @throws IllegalArgumentException if the seller does not exist or if
     * the provided information is invalid.
     */
    
    public void updateSeller(long employeeCode, Shift shift, String name,
            long iD, long contactNumber) {

        Seller seller = searchSeller(employeeCode);

        if (seller == null) {
            throw new IllegalArgumentException("Seller not found");
        }

        validateSeller(employeeCode, shift, name, iD, contactNumber);

        seller.setShift(shift);
        seller.setName(name);
        seller.setiD(iD);
        seller.setContactNumber(contactNumber);

        sellerDAO.updateSeller(seller);
    }

    /**
     * Deletes an existing seller from the persistence layer.
     *
     * @param employeeCode the employee code of the seller to delete.
     * @throws IllegalArgumentException if no seller with the given employee
     * code exists.
     */
    
    public void deleteSeller(long employeeCode) {

        Seller seller = searchSeller(employeeCode);

        if (seller == null) {
            throw new IllegalArgumentException("Seller not found");
        }

        sellerDAO.deleteSeller(employeeCode);
    }

    /**
     * Retrieves all sellers stored in the persistence layer.
     *
     * @return an ArrayList containing all stored sellers.
     */
    
    public ArrayList<Seller> listSellers() {
        return sellerDAO.listSellers();
    }

    /**
     * Searches for a seller by its employee code.
     *
     * @param employeeCode the employee code of the seller to search for.
     * @return the seller with the specified employee code, or {@code null}
     * if no matching seller is found.
     */
    
    public Seller searchSeller(long employeeCode) {
        return sellerDAO.searchSeller(employeeCode);
    }
}
