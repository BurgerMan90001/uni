package A5;

/*
* COMP 1010 SECTION A02
* INSTRUCTOR: Emanuel Wiens 
* STUDENT NAME: Paul Casigay
* STUDENT NUMBER: 8061457
* ASSIGNMENT: 5
* QUESTION: 1
*
* PURPOSE: Library database
*/

import java.util.Scanner;

public class CasigayPaulA5Q1 {
    // unique IDs of books start at 1000 and increases by 1 for each book
    final static int BASE_ID_NUM = 1000;
    // Column names used for displaying book statistics
    final static String[] COLUMN_NAMES = { "ID", "Title", "Author", "Copies" };
    // Whitespace for printing columns
    final static String WHITESPACE = "-25";
    // Total amount of books added to the database.
    static int booksAdded = 0;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        final int DATABASE_SIZE = 500;

        // Parallel arrays to form database
        int[] bookIDs = new int[DATABASE_SIZE];
        String[] titles = new String[DATABASE_SIZE];
        String[] authors = new String[DATABASE_SIZE];
        int[] copies = new int[DATABASE_SIZE];

        // Number of unique books in database
        int length = 0;

        displayMenu(scnr, bookIDs, titles, authors, copies, length);

        printMenuTitle("Program terminated.");
        scnr.close();
    }

    static void displayMenu(Scanner scnr, int[] bookIDs,
            String[] titles, String[] authors, int[] copies, int length) {

        boolean exitProgram = false;

        // Loop while input is not 6 (Exit)
        while (!exitProgram) {
            printMenuTitle("Library Inventory");
            System.out.println("1: Add book");
            System.out.println("2: Remove book");
            System.out.println("3: Search book");
            System.out.println("4: Update book");
            System.out.println("5: Statistics");
            System.out.println("6: Exit");

            String input = getInput(scnr, "option (1-6)");

            switch (input) {
                case "1":
                    length = addBook(scnr, bookIDs, titles, authors, copies, length);
                    break;
                case "2":
                    length = removeBook(scnr, bookIDs, titles, authors, copies, length);
                    break;
                case "3":
                    searchBook(scnr, bookIDs, titles, authors, copies, length);
                    break;
                case "4":
                    updateBook(scnr, bookIDs, titles, authors, copies, length);
                    break;
                case "5":
                    printStatistics(bookIDs, titles, authors, copies, length);
                    break;
                case "6":
                    // Stop the while loop and exit the program
                    exitProgram = true;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }

    static int addBook(Scanner scnr, int[] bookIDs,
            String[] titles, String[] authors, int[] copies, int length) {

        printMenuTitle("Add a book");

        // Get id from total books added + 1000
        int id = booksAdded + BASE_ID_NUM;

        /*
         * Get input for book title, author, and number of copies.
         * And, insert the book's id, title, author and copies at the first available
         * index.
         */
        add(bookIDs, length, id);
        String title = insert(scnr, "book title", titles, length);
        insert(scnr, "author name", authors, length);
        insert(scnr, "number of copies", copies, length);

        // Increment database length and total number of books added
        booksAdded++;
        length++;

        System.out.printf("---> Added book %s with id %d\n", title, id);

        // Update length of database
        return length;
    }

    static int removeBook(Scanner scnr, int[] bookIDs,
            String[] titles, String[] authors, int[] copies, int length) {

        printMenuTitle("Delete a book");
        String bookID = getInput(scnr, "book id to delete");

        if (isDigitsOnly(bookID)) {
            int bookIDNum = Integer.parseInt(bookID);
            // Search for the book by its id
            int bookIndex = search(bookIDs, length, bookIDNum);

            // If the book is found and there is a valid index
            if (bookIndex != -1) {
                // Delete its id, title, author and copies
                delete(bookIDs, length, bookIndex);
                delete(titles, length, bookIndex);
                delete(authors, length, bookIndex);
                delete(copies, length, bookIndex);

                // There is one less book in the database
                length--;
                System.out.println("---> Successfully deleted book");
            } else {
                System.out.println("Book id not found");
            }
        } else {
            System.out.println("Invalid ID");
        }

        return length;
    }

    /*
     * Searches for a book by the specified book id.
     * If found, print the book's title, author, and number of copies.
     */
    static void searchBook(Scanner scnr, int[] bookIDs, String[] titles,
            String[] authors, int[] copies, int length) {

        printMenuTitle("Search for a book");

        String bookID = getInput(scnr, "book id to search for");

        int bookIndex = findIDIndex(bookIDs, bookID, length);

        // If the book id was found in the database,
        if (bookIndex != -1) {
            // Print the column names
            printColumnNames();
            // Print the book's information
            printBookEntry(bookIDs[bookIndex], titles[bookIndex], authors[bookIndex], copies[bookIndex]);
        }
    }

    static void updateBook(Scanner scnr, int[] bookIDs, String[] titles,
            String[] authors, int[] copies, int length) {
        printMenuTitle("Update a book");

        System.out.print("Enter book id to update for: ");
        String bookID = scnr.nextLine();

        boolean didUpdateBook = false;

        int bookIndex = findIDIndex(bookIDs, bookID, length);

        // If the book id was found in the database,
        if (bookIndex != -1) {

            // Ask which element to modify
            if (shouldBeUpdated(scnr, "new book title")) {
                String title = getInput(scnr, "new book title");

                titles[bookIndex] = title;
                didUpdateBook = true;
            }
            if (shouldBeUpdated(scnr, "new author name")) {
                String author = getInput(scnr, "new author name");

                authors[bookIndex] = author;
                didUpdateBook = true;
            }
            if (shouldBeUpdated(scnr, "new number of copies")) {

                insert(scnr, "new number of copies", copies, bookIndex);
                didUpdateBook = true;

            }
            if (didUpdateBook) {
                System.out.printf("---> Updated book %s with id %d\n", titles[bookIndex], bookIDs[bookIndex]);
            }
        }
    }

    /***
     * Returns the book's index in the database by its id.
     * Returns -1 if id is not a number or does not exist.
     ***/
    static int findIDIndex(int[] bookIDs, String bookID, int length) {
        int bookIndex = -1;
        // Check if the bookID input only contains numbers
        if (isDigitsOnly(bookID)) {
            int bookIDNum = Integer.parseInt(bookID);
            // Search for the book by its id in the bookIDs array
            bookIndex = search(bookIDs, length, bookIDNum);

            // If the book is not found
            if (bookIndex == -1) {
                System.out.println("Book id not found");
            }
        } else {
            System.out.println("Invalid ID");
        }
        return bookIndex;
    }

    /***
     * Gets user input for a number and checks if it is actually a number.
     * Then inserts the number in the array at the index.
     * Returns -1 if insert was unssuccessful or number if successful.
     ***/
    static int insert(Scanner scnr, String itemName, int[] arr, int index) {
        String input = getInput(scnr, itemName);
        int inputNum;

        // If the input is a number
        if (isDigitsOnly(input)) {
            inputNum = Integer.parseInt(input);
            arr[index] = inputNum;
        } else {
            System.out.println(itemName + " is not a number");
            inputNum = insert(scnr, itemName, arr, index);
        }
        return inputNum;
    }

    /***
     * Prompts the user for a specific item and then reads the next line.
     * Inserts the string in the array at the index.
     * Returns the user input as a string.
     ***/
    static String insert(Scanner scnr, String prompt, String[] arr, int index) {
        String input = getInput(scnr, prompt);
        arr[index] = input;
        return input;
    }

    /***
     * Prompts the user for a specific item and then reads the next line.
     * Returns the user input as a string.
     ***/
    static String getInput(Scanner scnr, String prompt) {
        System.out.printf("> Enter %s: ", prompt);
        String input = scnr.nextLine();
        return input;
    }

    /***
     * Asks user if an item should be updated. User should answer yes or no.
     * Returns true if yes and false if no.
     ***/
    static boolean shouldBeUpdated(Scanner scnr, String item) {
        System.out.printf("Should the %s be updated? (yes, no): ", item);
        String answer = scnr.nextLine();
        boolean shouldBeUpdated;

        switch (answer) {
            case "yes":
                shouldBeUpdated = true;
                break;
            case "no":
                shouldBeUpdated = false;
                break;
            default:
                System.out.println("Input is not yes or no");
                // Ask for yes or no again
                shouldBeUpdated = shouldBeUpdated(scnr, item);
                break;

        }
        return shouldBeUpdated;
    }

    static void printStatistics(int[] bookIDs,
            String[] titles, String[] authors, int[] copies, int length) {

        printMenuTitle("Statistics");

        // Print each column name with whitespace
        printColumnNames();

        // Then print each book entry in database with whitespace
        for (int i = 0; i < length; i++) {
            printBookEntry(bookIDs[i], titles[i], authors[i], copies[i]);
        }

        System.out.print("\n");
        printStatistic("Total books: ", length);
        printStatistic("Total number of copies: ", sum(copies, length));
        printStatistic("Average copies per book: ", average(copies, length));

    }

    static void printStatistic(String statisticName, int statistic) {
        System.out.printf("### %s: %d ###\n", statisticName, statistic);
    }

    /***
     * Prints each column name with whitespace and starts a new line.
     ***/
    static void printColumnNames() {
        for (int i = 0; i < COLUMN_NAMES.length; i++) {
            System.out.printf("%" + WHITESPACE + "s", COLUMN_NAMES[i]);
        }
        // New line after printing column names
        System.out.print("\n");
    }

    // Prints a book entry with whitespace
    static void printBookEntry(int bookID, String title, String author, int numCopies) {
        System.out.printf("%" + WHITESPACE + "d", bookID);
        System.out.printf("%" + WHITESPACE + "s", title);
        System.out.printf("%" + WHITESPACE + "s", author);
        System.out.printf("%" + WHITESPACE + "d", numCopies);
        System.out.print("\n");
    }

    /***
     * Prints a fancy menu title for the specified title name.
     ***/
    static void printMenuTitle(String titleName) {
        System.out.print("\n");
        System.out.printf("--- %s ---\n", titleName);
        System.out.print("\n");
    }

    /*
     * Array methods
     */

    static int search(int[] arr, int length, int number) {
        int index = -1;
        for (int i = 0; i < length && index == -1; i++) {
            if (arr[i] == number) {
                index = i;
            }
        }
        return index;
    }

    /***
     * Adds a int entry to the end of a partially filled int array.
     ***/
    static int add(int[] arr, int length, int number) {
        arr[length] = number;
        length++;
        return length;
    }

    /***
     * Adds a String entry to the end of a partially filled String array.
     ***/
    static int add(String[] arr, int length, String item) {
        arr[length] = item;
        length++;
        return length;
    }

    /***
     * Returns the sum of all numbers in an int array.
     ***/
    static int sum(int[] arr, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /***
     * Returns the average of all numbers in an int array.
     * Returns 0 if the array length is 0.
     ***/
    static int average(int[] arr, int length) {
        int average = 0;
        // Avoid division by zero
        if (length != 0) {
            average = sum(arr, length) / length;
        }
        return average;
    }

    /***
     * Deletes an entry in an integer array at the specified index.
     ***/
    static int delete(int[] arr, int length, int index) {
        // If the number was found in the array
        if (index != -1 && index < length) {
            for (int i = index; i < length - 1; i++) {
                // Shift each item to the left once
                arr[i] = arr[i + 1];
            }
            length--;
        }
        return length;
    }

    /***
     * Deletes an entry in a String array at the specified index.
     ***/
    static int delete(String[] arr, int length, int index) {

        // If the number was found in the array
        if (index != -1 && index < length) {
            for (int i = index; i < length - 1; i++) {
                // Shift each item to the left once
                arr[i] = arr[i + 1];
            }
            length--;
        }
        return length;
    }

    /***
     * Is true if a string only contains digits
     ***/
    static boolean isDigitsOnly(String string) {
        boolean isDigitsOnly = true;
        for (int i = 0; i < string.length(); i++) {
            // isDigitsOnly is true until there is non digit in the string
            if (!Character.isDigit(string.charAt(i))) {
                isDigitsOnly = false;
            }
        }
        return isDigitsOnly;
    }
}
