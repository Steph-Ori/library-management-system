/**
 * Stephanie Ortiz
 * CEN 3024 - Software Development 1
 * September 14th, 2025
 * Patron.java
 * This class represents Patron.
 */


public class Patron {
    private final String id; // Should have 7 digits
    private String name;
    private String address;
    private double fine; // Should range from 0-250

    /**
     * method: Patron
     * parameters: String id, String name, String address, double fine
     * return: none
     * purpose: Makes a new Patron wtih id, name, address and fine.
     */
    public Patron(String id, String name, String address, double fine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fine = fine;

    }

    // Getters for Patron
    // Unused methods are for future use with new features

    /**
     * method: getId
     * parameters: none
     * return: String
     * purpose: returns Patrons ID.
     */
    public String getId() {
        return id;
    }
    // Place holder
    public String getName() {
        return name;
    }
    // Place holder
    public String getAddress() {
        return address;
    }

    /**
     * method: getFine
     * parameters: none
     * return: double
     * purpose: Get's the Patrons Fine amount.
     */
    public double getFine() {
        return fine;
    }

    // Setters for Patron
    // Unused Methods are for future use with new features

    // Place Holder
    public void setName(String name) {
        this.name = name;
    }
    // Place holder
    public void setAddress(String address) {
        this.address = address;
    }
    // Place holder
    public void setFine(double fine) {
        this.fine = fine;
    }

    /**
     * method: toString
     * parameters: none
     * return: String
     * purpose: Formats the String with Patrons info.
     */
    @Override
    public String toString() {
        return String.format("%s | %s | %s | %.2f", id, name, address, fine);
    }
} // End Code
