package view;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.NumberException;
import exceptions.giftSuggestionException;
import model.Toys;

/*
 * This class is responsible for displaying the menu and prompting the user for input
 * @Author: Ghassan, Akram, and Mohamed
 * @Version: 1.0
 * @Date: 2024, March 10
 */
public class AppMenu {

    // This is the scanner object
    Scanner input = new Scanner(System.in);

    // This method displays the main menu
    public void displayMenu() {
        System.out.println("How We May Help You?\n");
        System.out.println("(1)\tSearch Inventory and purchase a Toy");
        System.out.println("(2)\tAdd New Toy");
        System.out.println("(3)\tRemove Toy");
        System.out.println("(4)\tGet Gift Suggestion");
        System.out.println("(5)\tSave & Exit\n");
        System.out.println("Enter Option:");
    }

    // This method displays the search menu
    public void displaySearchMenu() {
        System.out.println("Find Toys with?\n");
        System.out.println("(1)\tSerial Number (SN)");
        System.out.println("(2)\tToy Name");
        System.out.println("(3)\tToy Type");
        System.out.println("(4)\tBack to Main Menu\n");
        System.out.println("Enter Option:");
    }

    /**
     * This method prompts the user to enter the serial number and returns the input
     * 
     * @return user input
     */
    public String promoteSerialNumberInput() {
        System.out.println("Enter Serial Number (SN):");
        return input.nextLine();
    }

    /**
     * This method prompts the user to enter the toy name and returns the input
     * 
     * @return user input
     */
    public String promoteToyNameInput() {
        System.out.println("Enter Toy Name:");
        String name = input.nextLine();

        name.toLowerCase();
        return name;
    }

    /**
     * This method prompts the user to enter the toy type and returns the input
     * 
     * @return user input
     */
    public String promoteToyTypeInput() {
        System.out.println("Enter Toy Type:");
        return input.nextLine();
    }

    /**
     * This method prompts the user to select a toy from the search results and
     * returns the SNNumber of the selected toy
     * 
     * @param foundToys
     * @return SNNumber
     */
    public String searchResultPrompt(ArrayList<Toys> foundToys) {
        String SNNumber = null;
        int i;

        System.out.println("Here are the search results\n");
        // Display the search results
        for (i = 0; i < foundToys.size(); i++) {
            System.out.printf("(%d)\t%s\n", i + 1, foundToys.get(i).getName());
        }
        i++;
        System.out.printf("(%d)\tBack To Search Menu\n", i);
        System.out.println("Enter option to purchase: ");

        // Prompt the user to select a toy from the search results to purchase or go
        // back to the search menu
        String option = input.nextLine();
        if (option.equals(Integer.toString(i))) {
            return null;
        } else {
            Toys selectedToy = foundToys.get(Integer.parseInt(option) - 1);
            SNNumber = selectedToy.getSN();
        }

        return SNNumber;
    }

    public String[] addNewToyPrompt() {
        String[] userentry = new String[10];
        System.out.println("Note: The first digit of the serial number determines the type of the toy\n" +
                "0 or 1: Figures\n" +
                "2 or 3: Animals\n" +
                "4, 5, or 6: Puzzles\n" +
                "7, 8, or 9: Board Games");
        System.out.println("Enter Serial Number:");
        String serialInput = input.nextLine();
        String toyType = "";
        try {
            if (serialInput.charAt(0) == '0' || serialInput.charAt(0) == '1') {
                toyType = "Figures";
            } else if (serialInput.charAt(0) == '2' || serialInput.charAt(0) == '3') {
                toyType = "Animals";
            } else if (serialInput.charAt(0) == '4' || serialInput.charAt(0) == '5' || serialInput.charAt(0) == '6') {

                toyType = "Puzzles";
            } else if (serialInput.charAt(0) == '7' || serialInput.charAt(0) == '8' || serialInput.charAt(0) == '9') {

                toyType = "BoardGames";
            } 
            else if (serialInput.isEmpty()) {
                throw new NumberException("Serial number cannot be empty");
            }
            else {
                throw new NumberException("Invalid serial number");
            }
            userentry[0] = toyType;

        } catch (NumberException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enter Toy Name: ");
        String toyNameInput = input.nextLine();

        System.out.println("Enter Toy Brand: ");
        String toyBrandInput = input.nextLine();

        System.out.println("Enter Toy Price: ");
        String toyPriceInput = input.nextLine();
        double toyPrice;
        try {
            toyPrice = Double.parseDouble(toyPriceInput);
            if (toyPrice < 0) {
                throw new NumberException("Price cannot be negative! ");
            }
        } catch (NumberException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Price has to be a number");
        }

        System.out.println("Enter Available counts: ");
        String availableToysInput = input.nextLine();
        int availableToys;
        try {
            availableToys = Integer.parseInt(availableToysInput);
            if (availableToys < 0) {
                throw new NumberException("Available count cannot be negative");
            }
        } catch (NumberException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Available toys must be a number");
        }
        System.out.println("Enter appropriate age: ");
        String ageInput = input.nextLine();
        int age;
        try {
            age = Integer.parseInt(ageInput);
            if (age < 0) {
                throw new NumberException("Age cannot be negative");
            }
        } catch (NumberException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Age must be a number");
        }

        /*
         * If the toy is a board game, the user will be prompted to enter the minimum
         * and maximum number of players and the designer names
         */
        String minimumInput = "0";
        String maximumInput = "0";
        String desginerInput = "";

        if (serialInput.charAt(0) == '7' || serialInput.charAt(0) == '8' || serialInput.charAt(0) == '9'){
            System.out.println("Enter Minimum Number of Players: ");
            minimumInput = input.nextLine();
            int minimum;
            try {
                minimum = Integer.parseInt(minimumInput);
                if (minimum < 0) {
                    throw new NumberException("minimum cannot be negative");
                }
            } catch (NumberException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("minimum must be a number");
            }
            System.out.println("Enter Maxmimum Number of Players: ");
            maximumInput = input.nextLine();
            int maximum;
            try {
                maximum = Integer.parseInt(maximumInput);
                if (maximum < 0) {
                    throw new NumberException("Maximum cannot be negative");
                } else if (Integer.parseInt(minimumInput) >= maximum) {
                    throw new NumberException("Minimum cannot be greater than Maximum");
                }

            } catch (NumberException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("maximum must be a number");
            }
            System.out.println("Enter Designer Names(Use ',' to seperate the names if more than one name): ");
            desginerInput = input.nextLine();
        }

        input.close();

        if (serialInput.isEmpty() || toyNameInput.isEmpty() || toyBrandInput.isEmpty() || toyPriceInput.isEmpty()
                || availableToysInput.isEmpty() || ageInput.isEmpty()) {
            System.out.println("You have to fill the necessary fields");
        } 
        else if (serialInput == "7" || serialInput == "8" || serialInput == "9"
                && (minimumInput.isEmpty() || maximumInput.isEmpty() || desginerInput.isEmpty())) {
            System.out.println("You have to fill all the fields, Try again!");
            addNewToyPrompt();
        } 
        
        userentry[1] = serialInput;
        userentry[2] = toyNameInput;
        userentry[3] = toyBrandInput;
        userentry[4] = toyPriceInput;
        userentry[5] = availableToysInput;
        userentry[6] = ageInput;
        userentry[7] = minimumInput;
        userentry[8] = maximumInput;
        userentry[9] = desginerInput;

        return userentry;
    }

    /**
     * This method prompts the user to enter the serial number, name, brand, price,
     * available count and age appropriate of the toy
     * 
     * @return toy information
     */
    public String[] displayGiftSuggestion() {
        // This method prompts the user to enter the age, type, minimum price and
        // maximum price of the child
        String[] giftSuggestion = new String[4]; // age, type, minPrice, maxPrice

        System.out.println("Fill some information to get a gift suggestion\nNote: you can leave 2 fields empty");

        // Child age
        System.out.println("Enter the age of the child: ");
        String ageInput = input.nextLine();
        int age;
        try {
            age = Integer.parseInt(ageInput);
            if (age < 0) {
                throw new giftSuggestionException("Age cannot be negative");
            }
        } catch (giftSuggestionException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Age has to be a number");
        } finally {
            ageInput = "9";
        }

        // Toy type
        System.out.println("Enter the type of the toy: ");
        String type = input.nextLine();
        type.toLowerCase();

        // Minimum price
        System.out.println("Enter the minimum price: ");
        String minPriceInput = input.nextLine();
        try {
            Double minPrice = Double.parseDouble(minPriceInput);
            if (minPrice < 0) {
                throw new giftSuggestionException("Price cannot be negative");
            }
        } catch (giftSuggestionException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Price has to be a number");
        } finally {
            minPriceInput = "0";
        }

        // Maximum price
        System.out.println("Enter the maximum price: ");
        String maxPrice = input.nextLine();
        try {
            Double maxPriceInput = Double.parseDouble(maxPrice);
            if (maxPriceInput < 0) {
                throw new giftSuggestionException("Price cannot be negative");
            }
        } catch (giftSuggestionException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Price has to be a number");
        } finally {
            maxPrice = "10";
        }

        if (ageInput.isEmpty() && type.isEmpty() && minPriceInput.isEmpty() && maxPrice.isEmpty()) {
            System.out.println("You have to fill at least one field");
        } else {
            giftSuggestion[0] = ageInput;
            giftSuggestion[1] = type;
            giftSuggestion[2] = minPriceInput;
            giftSuggestion[3] = maxPrice;
        }

        return giftSuggestion;
    }
}
