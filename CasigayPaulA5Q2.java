
/*
* COMP 1010 SECTION A02
* INSTRUCTOR: Emanuel Wiens 
* STUDENT NAME: Paul Casigay
* STUDENT NUMBER: 8061457
* ASSIGNMENT: 5
* QUESTION: 2
*
* PURPOSE: Unscrambles a secret code
*/

import java.util.Scanner;

public class CasigayPaulA5Q2 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // First, get user input for number of letters
        getNumLetters(scnr);

        System.out.println("Program terminated.");
        scnr.close();
    }

    /*
     * First step, get user input for number of letters in secret word
     */
    static void getNumLetters(Scanner scnr) {
        System.out.print("Enter the number of letters in secret word: ");
        String numLettersInput = scnr.next();
        // Advance scanner to next line for next input
        scnr.nextLine();

        getScramblePattern(scnr, numLettersInput);
    }

    /*
     * Next, get user input for scramble pattern, the original positions of each
     * letter.
     */
    static void getScramblePattern(Scanner scnr, String numLettersInput) {
        if (isDigitsOnly(numLettersInput)) {
            int numLetters = Integer.parseInt(numLettersInput);

            System.out.printf("Enter the scrambling pattern (1-%d): ", numLetters);
            String scramblePattern = scnr.nextLine();

            // Check if scramble pattern is valid
            if (isValidPattern(numLetters, scramblePattern)) {

                // If it is valid, it can be safely coverted to an int array
                int[] numPattern = toIntArray(scramblePattern, numLetters);

                // Then get the scrambled word
                getScrambledWord(scnr, numPattern, numLetters);
            }
        } else {
            printError("Number of letters is not a number");
        }

    }

    /*
     * Then, get user input for the scrambled word. Checks if the scramble pattern
     * has a number out of range before getting scrambled word.
     */
    static void getScrambledWord(Scanner scnr, int[] numPattern, int numLetters) {
        // If there isnt a number greater than the array's length
        if (!numberOutOfRange(numPattern)) {
            // Get user input for scrambled word
            System.out.print("Enter the scrambled word: ");
            String scrambledWord = scnr.next();

            // Get the original unscrambled word and print it
            printOriginalWord(scrambledWord, numPattern, numLetters);
        }
        // There is a number greater than the array's length
        else {
            printError("Number out of range.");
        }
    }

    /*
     * Last step, unscrambles a scrambled word from and prints it
     */
    static void printOriginalWord(String scrambledWord, int[] numPattern, int numLetters) {
        if (scrambledWord.length() == numLetters) {
            String originalWord = unscrambleWord(numPattern, scrambledWord);
            System.out.printf("Original word: %s\n", originalWord);
        } else {
            printError("Scrambled word length does not match number of letters");
        }
    }

    /***
     * Is true if a string only contains digits
     * It can also contain spaces
     ***/
    static boolean isDigitsOnly(String string) {
        boolean isDigitsOnly = true;
        for (int i = 0; i < string.length(); i++) {
            // isDigitsOnly is true until there is non digit in the string or not a space
            if (!Character.isDigit(string.charAt(i))
                    && !(string.charAt(i) == ' ')) {
                isDigitsOnly = false;
            }
        }
        return isDigitsOnly;
    }

    /***
     * Is true when a pattern string does not have duplicates,
     * does not have a number bigger than the pattern's length,
     * matches the amount of characters inputed, and
     * only contains numeric entries.
     ***/
    static boolean isValidPattern(int numLetters, String pattern) {
        boolean isValidPattern = true;

        // If the scramble pattern is non-numeric
        if (!isDigitsOnly(pattern)) {
            // The pattern is invalid
            isValidPattern = false;
            printError("Pattern has contains non-numeric entries");
        }
        // If the scramble pattern has more or less characters than number of letters
        else if (numLetters != amountOfNumbers(pattern)) {
            isValidPattern = false;
            printError("Pattern length does not match specified length");
        } else {

            // Can convert to int array since its all numbers and length is correct
            int[] patternArr = toIntArray(pattern, numLetters);

            // If there is duplicates, the pattern is invalid
            if (hasDuplicates(patternArr)) {
                isValidPattern = false;
                printError("Pattern has duplicates");
            }
        }

        return isValidPattern;
    }

    static int amountOfNumbers(String pattern) {
        int count = 1;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    /*
     * Converts a string with numbers separated by spaces into an int array
     */
    static int[] toIntArray(String scramblePattern, int length) {
        int[] arr = new int[length];
        int nextSpaceIndex = scramblePattern.indexOf(' ');

        for (int i = 0; i < length; i++) {
            nextSpaceIndex = scramblePattern.indexOf(' ');
            String numString;
            // If there are no more spaces
            if (nextSpaceIndex == -1) {
                // Get the last number if there is no space characters left
                numString = scramblePattern.substring(0, scramblePattern.length());
            } else {
                // Get the first number
                numString = scramblePattern.substring(0, nextSpaceIndex);
            }
            // Set array entry to number
            arr[i] = Integer.parseInt(numString);
            // Remove the first number in the string
            scramblePattern = scramblePattern.substring(nextSpaceIndex + 1, scramblePattern.length());

        }
        return arr;
    }

    /*
     * Checks if a number in an int array is bigger than the length
     */
    static boolean numberOutOfRange(int[] arr) {
        boolean numberOutOfRange = false;
        for (int i = 0; i < arr.length && !numberOutOfRange; i++) {
            if (arr[i] > arr.length) {
                numberOutOfRange = true;
            }
        }
        return numberOutOfRange;
    }

    /*
     * Checks if a number in an int array is bigger than the length
     */
    static String unscrambleWord(int[] numPattern, String word) {
        String unscrambledWord = "";
        // Start and one and end at the words length
        for (int i = 1; i <= word.length(); i++) {
            int index = search(numPattern, i);
            unscrambledWord += word.charAt(index);
        }

        return unscrambledWord;
    }

    /*
     * Gets the index of the specified number. The index is -1 if not found.
     */
    static int search(int[] arr, int number) {
        int index = -1;
        for (int i = 0; i < arr.length && index == -1; i++) {
            if (arr[i] == number) {
                index = i;
            }
        }
        return index;
    }

    /*
     * Checks for duplicate numbers in an integer array.
     * Is true if there is and false if not.
     */
    static boolean hasDuplicates(int[] arr) {
        boolean hasDuplicates = false;
        for (int i = 0; i < arr.length; i++) {
            int currNum = arr[i];

            for (int j = 0; j < arr.length; j++) {
                if (i != j && currNum == arr[j]) {
                    hasDuplicates = true;
                }
            }
        }
        return hasDuplicates;
    }

    // Prints an error for invalid input with a reason
    static void printError(String error) {
        System.out.printf("Invalid input. %s\n", error);
    }
}
