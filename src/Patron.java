
public class Patron {
    private final String id; // Should have 7 digits
    private String name;
    private String address;
    private double fine; // Should range from 0-250

    // These are the attributes for Patron
    public Patron(String id, String name, String address, double fine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fine = fine;

    }

    // Getters for Patron
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getFine() {
        return fine;
    }

    // Setters for Patron
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %.2f", id, name, address, fine);
    }
} // End Code
