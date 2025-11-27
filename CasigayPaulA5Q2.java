
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

        String test = "3 2";
        int[] arr = toIntArray(test, 5);
        printArray(arr, 5);
        System.out.println(amountOfNumbers(test));

        System.out.print("Enter the number of letters in secret word: ");
        String numLettersInput = scnr.next();
        scnr.nextLine();

        if (isDigitsOnly(numLettersInput)) {
            int numLetters = Integer.parseInt(numLettersInput);

            System.out.printf("Enter the scrambling pattern (1-%d): ", numLetters);
            String scramblePattern = scnr.nextLine();

            if (isValidPattern(numLetters, scramblePattern)) {

                // Can safely covert pattern string to an int array
                int[] numPattern = toIntArray(scramblePattern, numLetters);

                // If there isnt a number greater than the array's length
                if (!numberOutOfRange(arr)) {
                    System.out.print("Enter the scrambled word: ");
                    String scrambledWord = scnr.next();

                    // String unscrambledWord = unScrambleWord(noSpacesPattern, scrambledWord);
                } else {
                    System.out.println("Invalid input. Number out of range.");

                }
                printArray(numPattern, numLetters);

            } else {
                System.out.println("Invalid input. ");
            }

        } else {
            System.out.println("Invalid input");
        }

        scnr.close();

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
            System.out.println("Pattern has contains non-numeric entries");
        }
        // If the scramble pattern has more or less characters than number of letters
        else if (numLetters != amountOfNumbers(pattern)) {
            isValidPattern = false;
            System.out.println("Pattern length does not match specified length");
        } else {

            // Can convert to int array since its all numbers and length is correct
            int[] patternArr = toIntArray(pattern, numLetters);

            // If there is duplicates, the pattern is invalid
            if (hasDuplicates(patternArr)) {
                isValidPattern = false;

                System.out.println("Pattern has duplicates");
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

    static int[] toIntArray(String scramblePattern, int length) {
        int[] arr = new int[length];
        int nextSpaceIndex = scramblePattern.indexOf(' ');

        for (int i = 0; i < length; i++) {
            nextSpaceIndex = scramblePattern.indexOf(' ');
            String numString;
            // If there is another space
            if (nextSpaceIndex != -1) {
                // Get the first number
                numString = scramblePattern.substring(0, nextSpaceIndex);
            } else {
                // Get the last number if there is no space characters left
                numString = scramblePattern.substring(0, scramblePattern.length());
            }
            // Set array entry to number
            arr[i] = Integer.parseInt(numString);
            // Remove the first number in the string
            scramblePattern = scramblePattern.substring(nextSpaceIndex + 1, scramblePattern.length());

        }
        return arr;
    }

    static boolean numberOutOfRange(int[] arr) {
        boolean numberOutOfRange = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr.length) {
                numberOutOfRange = true;
            }
        }
        return numberOutOfRange;
    }

    static String unScrambleWord(String noSpacesPattern, String word) {
        String unScrambledWord = "";

        for (int i = 0; i < noSpacesPattern.length(); i++) {
            int position = noSpacesPattern.charAt(i);
            System.out.print(position);
        }

        return unScrambledWord;
    }

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

    static String removeSpaces(String string) {
        String stringNoSpaces = "";
        boolean isNotSpace;
        for (int i = 0; i < string.length(); i++) {
            isNotSpace = !(string.charAt(i) == ' ');
            if (isNotSpace) {
                stringNoSpaces += string.charAt(i);
            }
        }
        return stringNoSpaces;
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
}
