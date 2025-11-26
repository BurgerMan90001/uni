
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
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        final int DATABASE_SIZE = 500;

        // Parallel arrays to form database
        int[] bookIDs = new int[DATABASE_SIZE];
        String[] titles = new String[DATABASE_SIZE];
        String[] authors = new String[DATABASE_SIZE];
        int[] copies = new int[DATABASE_SIZE];

        int length = 0;

        String[] columns = { "BookIDs", "Titles", "Authors", "Copies" };

        length = displayMenu(scnr, bookIDs, titles, authors, copies, length);

        // Number of books in database
        /*
         * int copies = 0;
         * copies = addBook(scnr, bookIDs, titles, authors, copies);
         */
        System.out.println("Program terminated.");
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

        scnr.nextLine();
        // int id = 123;
        int addedCopiesNum = 0;

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
            int id = length;

            insert(bookIDs, length, id);
            insert(titles, length, title);
            insert(authors, length, author);
            insert(copies, length, addedCopiesNum);

            length++;

            System.out.printf("Added %s with id %d\n", title, id);
        } else {
            System.out.println("Input was not a number. Try again.");
            length = addBook(scnr, bookIDs, titles, authors, copies, length);
        }

        return length;
    }

    static void removeBook(int bookID) {

    }

    static int searchBook() {
        int index = -1;

        // for (int i = 0; i < )
        return index;
    }

    static void updateBook() {

    }

    static void printStatistics(int copies) {

    }

    static int displayMenu(Scanner scnr, int[] bookIDs,
            String[] titles, String[] authors, int[] copies, int length) {

        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("---- Library Inventory --- ");
            System.out.println("1: Add book");
            System.out.println("2: Remove book");
            System.out.println("3: Search book");
            System.out.println("4: Update book");
            System.out.println("5: Statistics");
            System.out.println("6: Exit");
            System.out.print("Choose option (1-6): ");

            // scnr.nextLine();
            String input = scnr.next();

            switch (input) {
                case "1":
                    length = addBook(scnr, bookIDs, titles, authors, copies, length);
                    break;
                case "2":
                    removeBook(0);
                    break;
                case "3":
                    searchBook();
                    break;
                case "4":
                    updateBook();
                    break;
                case "5":
                    printStatistics(0);
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

    static int delete(int[] arr, int length, int number) {
        int index = search(arr, length, number);
        // If the number was found in the array
        if (index != -1) {
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
