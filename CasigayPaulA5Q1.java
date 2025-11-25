
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

        // Number of books in database
        int copies = 0;

        scnr.close();
    }

    static void printMenu(Scanner scnr) {
        System.out.println("1: Add book");
        System.out.println("2: Remove book");
        System.out.println("3: Search book");
        System.out.println("4: Update book");
        System.out.println("5: Statistics");
        System.out.println("6: Exit");
        System.out.print("(1-6)");

        scnr.nextLine();
        String input = scnr.next();

        switch (input) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
        }

    }
}
