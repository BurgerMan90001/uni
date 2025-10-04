package Labs;
//COMP 1010 Fall 2025 Lab 3, Level 1 Template

import java.util.Scanner;

class Lab03Level1 {

    public static void main(String[] args) {

        Scanner keyIn = new Scanner(System.in);

        System.out.print("Please enter some words: ");

        // String input = keyIn.nextLine();
        String input = "This is a test woow";

        // TO DO: Replace "first" with call to method to get first word
        String firstWord = getFirstWord(input);

        // TO DO: Replace "last" with call to method to get last word
        String lastWord = getLastWord(input);

        // TO DO: Replace "middle" with call to method to get middle word
        String middleWord = getMiddleWord(input);

        System.out.println("The first word was \"" + firstWord +
                "\", the last word was \"" + lastWord
                + "\", and the middle word was \"" + middleWord + "\".");

        keyIn.close();

        System.out.println("Program terminated normally.");
    }

    // TO DO: Add user-defined methods to get the first, last, and middle words from
    // a String.
    // HINT: Make sure a search for a space never returns -1, so that you always use
    // valid indices when getting a substring.
    static String getFirstWord(String string) {
        String firstWord;
        int firstSpaceIndex = string.indexOf(' ');
        // System.out.println(string.length());
        /*
         * if (firstSpaceIndex == -1 && string.length() > 1) {
         * firstWord = string.substring(0, string.length() - 1);
         * } else if (firstSpaceIndex == -1 && string.length() <= 1) {
         * firstWord = "empty string";
         * } else {
         * firstWord = string.substring(0, firstSpaceIndex);
         * }
         */
        firstWord = string.substring(0, firstSpaceIndex);
        return firstWord;
    }

    static String getLastWord(String string) {
        String lastWord;
        lastWord = "";

        // increment by 1 to remove the space
        int lastSpaceIndex = string.lastIndexOf(' ') + 1;

        lastWord = string.substring(lastSpaceIndex, string.length());

        return lastWord;
    }

    static String getMiddleWord(String string) {
        int middleIndex = string.length() / 2;

        String first = string.substring(0, middleIndex);
        String second = string.substring(middleIndex, string.length());

        int firstSpaceIndex = first.lastIndexOf(' ');
        int lastSpaceIndex = second.indexOf(' ') + first.length();

        String middleWord = string.substring(firstSpaceIndex, lastSpaceIndex);

        return middleWord;
    }
}