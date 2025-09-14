/**
 * Stephanie Ortiz
 * CEN 3024 - Software Development 1
 * September 14th, 2025
 * Main.java
 * This class stores Partrons and double checks for errors.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class LibrarySystem {
    private final List<Patron> patrons = new ArrayList<>();

    public int loadFromFile(String path) {
        int added = 0;                           // How many patrons we will actually add
        BufferedReader br = null;                // Just declaring up here to keep things legible

        try {
            br = Files.newBufferedReader(Path.of(path));
            String line;

            while ((line = br.readLine()) != null) {

                // Split the line into exactly four parts (makes it so dashes inside are okay)
                String[] parts = line.split("-", 4);

                // Check we got all four spaces
                if (parts.length != 4) {
                    System.out.println("Oops! Error! Skipped wrong line: " + line);
                    continue;
                }

                // Clean up each of the pieces
                String id = parts[0].trim();
                String name = parts[1].trim();
                String address = parts[2].trim();
                String fineText = parts[3].trim();

                // Checking each piece, skipping when NOT valid
                if (!isValidId(id)) {
                    System.out.println("Oops! Error! Skipped wrong id: " + id);
                    continue;
                }

                if (!isValidFineString(fineText)) {
                    System.out.println("Oops! Error! Skipped wrong fine string: " + fineText);
                    continue;
                }

                if (hasDuplicateId(id)) {
                    System.out.println("Oops! Error! Skipped duplicated id: " + id);
                    continue;
                }

                // Converting book fine to a number
                double fine = Double.parseDouble(fineText);

                // Create the patron object
                Patron patron = new Patron(id, name, address, fine);
                // Add to our list
                patrons.add(patron);
                added++;
            }
        } catch (IOException e) {
            System.out.println("Oops! Error! Could not read the file " + e.getMessage());
        } finally {
            // Close reader if it was opened
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ignored) { }
            }
        }

        // Return how many were added
        return added;
    }

    // Adding a patron with manual input
    public boolean addPatron(Patron patron) {
        if (patron == null) return false;

        String id = patron.getId();
        double fine = patron.getFine();

        if (!isValidId(id)) return false;
        if (fine < 0 || fine > 250) return false;
        if (hasDuplicateId(id)) return false;

        patrons.add(patron);
        return true;
    }

    // Loop to remove
    public boolean removeById(String id) {
        for (int i = 0; i < patrons.size(); i++) {
            Patron patron = patrons.get(i);
            if (patron.getId().equals(id)) {
                patrons.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Patron> getAll() {
        return new ArrayList<>(patrons);
    }
    // ** HELPERS **
    // a few helper methods that support the main features, keeps the code clean.
    // Also helps to not repeat the same things over and over.
    // Prevents CRASHES.

    // Checks if the ID is EXACTLY 7 digits
    private boolean isValidId(String id) {
        return id != null && id.matches("\\d{7}");
    }

    // Checks if the book fine string can be turned into a number AND that number is between 0 and 250.
    private boolean isValidFineString(String fineText) {
        try {
            double f = Double.parseDouble(fineText);
            return f >= 0 && f <= 250;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // Checks for duplicate ID's and Prevents them as well
    private boolean hasDuplicateId(String id) {
        for (Patron patron : patrons) {
            if (patron.getId().equals(id)) return true;
        }
        return false;
    }
} // END LMS

























