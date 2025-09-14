/**
 * Stephanie Ortiz
 * CEN 3024 - Software Development 1
 * September 14th, 2025
 * Main.java
 * This class creates a Library System that is able to add, remove and list patrons.
 */

import java.util.List;
import java.util.Scanner;

    /**
     * method: LibrarySystem
     * parameters: none
     * return: none
     * purpose:
        */
public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        Scanner in = new Scanner(System.in);

        while (true) {

            showMenu();
            String choice = in.nextLine().trim();

            switch (choice) {
                case "1": {
                    // Loading Patrons from a file
                    System.out.println("Please enter the name of the Patron: ");
                    String path = in.nextLine().trim();
                    int count = librarySystem.loadFromFile(path);
                    System.out.println("Patron " + count + " loaded successfully!");
                    break;
                }
                case "2": {
                    // Add a new Patron Manually
                    System.out.println("ID (7 digits): ");
                    String id = in.nextLine().trim();
                    System.out.println("Name: ");
                    String name = in.nextLine().trim();
                    System.out.println("Address: ");
                    String address = in.nextLine().trim();
                    System.out.println("Fine (0-250): ");
                    String fineString = in.nextLine().trim();

                    try {
                        double fine = Double.parseDouble(fineString);
                        boolean ok = librarySystem.addPatron(new Patron(id, name, address, fine));
                        System.out.println(ok ? "Added." : "Not added, wrong entry or duplicate ID.");
                    } catch (NumberFormatException e) {
                        System.out.println("Uh oh! Something went wrong. Fine must be a number.");
                    }
                    break;
                }
                case "3": {
                    //Remove a patron by ID
                    System.out.println("ID (7 digits): ");
                    String id = in.nextLine().trim();
                    System.out.println(librarySystem.removeById(id) ? "Removed." : "ID not found in Library System.");
                    break;
                }
                case "4": {
                    // Show all Patrons in LMS
                    // Also a if/else if list doesnt have entries yet.
                    List<Patron> list = librarySystem.getAll();
                    if (list.isEmpty()) System.out.println("No patrons.");
                    else list.forEach(System.out::println);
                }
                break;

                case "5": {
                    //Exit the program
                    System.out.println("Exiting Library System, Have a good day!");
                    return;
                }
                default:
                    // Stops from crashing when input is not 1 through 5.
                    System.out.println("Wrong input. Please try again.");
            }
            System.out.println(); // just a blank line
        } // End While Loop

    } // End of Cases

    /**
     * method: showMenu
     * parameters: none
     * return: none
     * purpose: Show's the menu for LMS
     */
    private static void showMenu() {
        System.out.println("""
                1) Load Patron from Library System
                2) Add New Patron to Library System manually
                3) Remove Patron from Library System using ID (7 digits)
                4) Show All Patrons in List
                5) Exit Library System
                """);
        System.out.println("Choose an option: ");
    }
} // End Main