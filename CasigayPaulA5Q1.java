
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
    // Column names used for displaying
    final static String[] COLUMN_NAMES = { "ID", "Title", "Author", "Copies" };
    final static String WHITESPACE = "-30";
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

        length = displayMenu(scnr, bookIDs, titles, authors, copies, length);

        printMenuTitle("Program terminated.");
        scnr.close();
    }

    /*
     * Test books
     * Grey (Fifty Shades #4)
     * El James
     * 50
     * 
     * Naruto Vol. 14
     * Masashi Kishimoto
     * 9
     */
    static int addBook(Scanner scnr, int[] bookIDs,
            String[] titles, String[] authors, int[] copies, int length) {

        int addedCopiesNum = 0;

        printMenuTitle("Add a book");

        System.out.print("> Book title: ");
        String title = scnr.nextLine();

        System.out.print("> Author name: ");
        String author = scnr.nextLine();

        System.out.print("> Number of copies: ");
        String addedCopies = scnr.next();

        // If the input is a number
        if (isDigitsOnly(addedCopies)) {
            // Add copiesAdded as an int to total copies in database
            addedCopiesNum = Integer.parseInt(addedCopies);
            int id = booksAdded + BASE_ID_NUM;

            insert(bookIDs, length, id);
            insert(titles, length, title);
            insert(authors, length, author);
            insert(copies, length, addedCopiesNum);

            booksAdded++;
            length++;

            System.out.printf("---> Added book %s with id %d\n", title, id);
        } else {
            System.out.println("Input was not a number.");
        }

        return length;
    }

    static int removeBook(Scanner scnr, int[] bookIDs,
            String[] titles, String[] authors, int[] copies, int length) {

        printMenuTitle("Delete a book");
        System.out.print("Enter book id to delete: ");

        String bookID = scnr.next();

        if (isDigitsOnly(bookID)) {
            int bookIDNum = Integer.parseInt(bookID);
            // Search for the book by its id
            int bookIndex = search(bookIDs, length, bookIDNum);

            // If the book is found and there is a valid index
            if (bookIndex != -1) {
                // Delete its id, title, author and copy
                delete(bookIDs, length, bookIndex);
                delete(titles, length, bookIndex);
                delete(authors, length, bookIndex);
                delete(copies, length, bookIndex);
                // There is one less book
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

    static int searchBook(Scanner scnr, int[] bookIDs, String[] titles, String[] authors, int[] copies, int length) {
        int index = -1;

        printMenuTitle("Search for a book");

        System.out.println("Enter book id to search for: ");
        String bookID = scnr.next();

        if (isDigitsOnly(bookID)) {
            int bookIDNum = Integer.parseInt(bookID);
            // Search for the book by its id
            int bookIndex = search(bookIDs, length, bookIDNum);

            // If the book is found and there is a valid index
            if (bookIndex != -1) {
                printBookEntry(bookIDNum, titles[bookIndex], authors[bookIndex], copies[bookIndex]);
                System.out.println("---> Successfully deleted book");
            } else {
                System.out.println("Book id not found");
            }
        } else {
            System.out.println("Invalid ID");
        }
        return index;
    }

    static void updateBook() {

        printMenuTitle("Update a book");

    }

    static void printStatistics(int[] bookIDs,
            String[] titles, String[] authors, int[] copies, int length) {

        printMenuTitle("Statistics");
        // Print each column name with whitespace
        for (int i = 0; i < COLUMN_NAMES.length; i++) {
            System.out.printf("%" + WHITESPACE + "s", COLUMN_NAMES[i]);
        }
        System.out.print("\n");
        for (int i = 0; i < length; i++) {
            // Print each book with whitespace
            printBookEntry(bookIDs[i], titles[i], authors[i], copies[i]);

            System.out.print("\n");
        }

    }

    // Prints a book entry with whitespace
    static void printBookEntry(int bookID, String title, String author, int numCopies) {
        System.out.printf("%" + WHITESPACE + "d", bookID);
        System.out.printf("%" + WHITESPACE + "s", title);
        System.out.printf("%" + WHITESPACE + "s", author);
        System.out.printf("%" + WHITESPACE + "d", numCopies);
        System.out.print("\n");
    }

    // Prints formated string with global whitespace
    static void printfString(String string) {
        System.out.printf("%" + WHITESPACE + "s", string);
    }

    // Prints formated string with global whitespace
    static void printfInteger(int num) {
        System.out.printf("%" + WHITESPACE + "d", num);
    }

    static int displayMenu(Scanner scnr, int[] bookIDs,
            String[] titles, String[] authors, int[] copies, int length) {

        boolean exitProgram = false;

        while (!exitProgram) {
            printMenuTitle("Library Inventory");
            System.out.println("1: Add book");
            System.out.println("2: Remove book");
            System.out.println("3: Search book");
            System.out.println("4: Update book");
            System.out.println("5: Statistics");
            System.out.println("6: Exit");
            System.out.print("Choose option (1-6): ");

            String input = scnr.nextLine();

            switch (input) {
                // Have the scanner advance to next line to correctly take input
                case "1":
                    length = addBook(scnr, bookIDs, titles, authors, copies, length);
                    scnr.nextLine();
                    break;
                case "2":
                    length = removeBook(scnr, bookIDs, titles, authors, copies, length);
                    scnr.nextLine();
                    break;
                case "3":
                    searchBook(scnr, bookIDs, titles, authors, copies, length);
                    break;
                case "4":
                    updateBook();
                    break;
                case "5":
                    printStatistics(bookIDs, titles, authors, copies, length);
                    break;
                case "6":
                    exitProgram = true;
                    break;
                default:
                    System.out.println("Not a valid input");
                    break;
            }
        }
        return length;
    }

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

    static int insert(int[] arr, int length, int number) {
        arr[length] = number;
        length++;
        return length;
    }

    static int insert(String[] arr, int length, String item) {
        arr[length] = item;
        length++;
        return length;
    }

    static int orderedInsert(int[] arr, int length, int number) {
        boolean biggestNum = true;
        int index = -1;
        for (int i = 0; i < length && index == -1; i++) {
            // If the chosen number is less than found number in array
            if (number < arr[i]) {
                // It is not the biggest
                biggestNum = false;
                index = i;
            }
        }

        // If there is empty array
        if (length == 0) {
            arr[0] = number;
        } else if (biggestNum) {
            arr[length] = number;
        } else {
            for (int i = length + 1; i > index; i--) {
                // Shift each item to the left once
                arr[i] = arr[i - 1];
            }
            arr[index] = number;
        }
        length++;
        return length;

    }

    static int delete(int[] arr, int length, int index) {
        // int index = search(arr, length, number);
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

    static int delete(String[] arr, int length, int index) {
        // int index = search(arr, length, number);
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

    static void printArray(int[] arr, int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                System.out.print(", " + arr[i]);
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("]\n");
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
