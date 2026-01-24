package A2;
/*
* COMP 1010 SECTION A02
* INSTRUCTOR: Emanuel Wiens 
* STUDENT NAME: Paul Casigay
* STUDENT NUMBER: 8061457
* ASSIGNMENT: 2
* QUESTION: 2
*
* PURPOSE: Performs smithing operations on words with techniques such as welding, stamping, punching, and shrinking.
*/

import java.util.Scanner;

public class CasigayPaulA2Q2 {
    public static void main(String[] args) {
        // lowercase and capitalized letters for showing shrink and upset
        String word1 = "smithing";
        String word2 = "SMITHING";
        String die = "die";
        Scanner scnr = new Scanner(System.in);
        smithWord(word1, scnr);
        // testSuite(word1, word2, die);

        scnr.close();

        System.out.println("Program terminated successfully.");
    }

    static void testSuite(String word1, String word2, String die) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("----> TEST SUITE START");

        String drawnOutWord = drawOut(word1, 0);
        printResult(drawnOutWord, "ssmithing");

        String shrunkWord = shrink(word2, 4, 7);
        printResult(shrunkWord, "SMIThing");

        String upsetWord = upset(word1, 4, 7);
        printResult(upsetWord, "smitHINg");

        String weldedWord = weld(word1, word2);
        printResult(weldedWord, "smithingSMITHING");

        String punchedWord = punch(word1, 5);
        printResult(punchedWord, "smith ing");

        String stampedWord = stamp(word1, die, 6);
        printResult(stampedWord, "smdieing");

        smithWord(word1, scnr);

        System.out.println("----> TEST SUITE END");
    }

    static void smithWord(String word, Scanner scnr) {
        System.out.println(" ----> Smithing the word \"" + word + "\"");

        String drawnOutWord = drawOut(word, scnr);
        printResult(drawnOutWord);

        String shrunkWord = shrink(drawnOutWord, scnr);
        printResult(shrunkWord);

        String upsetWord = upset(shrunkWord, scnr);
        printResult(upsetWord);

        String weldedWord = weld(upsetWord, scnr);
        printResult(weldedWord);

        String punchedWord = punch(weldedWord, scnr);
        printResult(punchedWord);

        String stampedWord = stamp(punchedWord, scnr);

        System.out.println("Final result of smithWord: " + stampedWord);
    }

    // prints resulting word and the expected word
    static void printResult(String result, String expected) {
        System.out.println("Result:   " + result);
        System.out.println("Expected: " + expected);
    }

    // only prints resulting word
    static void printResult(String result) {
        System.out.println("Result:   " + result);
    }

    // duplicates a character in a word at the specified index
    static String drawOut(String word, int index) {

        char character = word.charAt(index);

        String firstPart = word.substring(0, index);
        String secondPart = word.substring(index, word.length());
        // put the indexed char and put in between first and second halves
        String drawnOutWord = firstPart + character + secondPart;

        System.out.println(" > Drawing out \"" + word + "\" at " + index);

        return drawnOutWord;
    }

    // overload method for user input
    static String drawOut(String word, Scanner scnr) {
        System.out.print("Draw out at index: ");
        int index = scnr.nextInt();

        return drawOut(word, index);
    }

    // changes all letters in specified range to lowercase
    static String shrink(String word, int startIndex, int endIndex) {
        System.out.println(" > Shrinking \"" + word + "\" at " + startIndex + " to " + endIndex);

        String firstPart = word.substring(0, startIndex);
        // get the specified range of the word and convert to lowercase
        String secondPart = word.substring(startIndex, endIndex).toLowerCase();
        // get the rest of the word after the specified range
        String thirdPart = word.substring(endIndex, word.length());

        String shrinkedWord = firstPart + secondPart + thirdPart;

        return shrinkedWord;
    }

    // overload method for user input
    static String shrink(String word, Scanner scnr) {
        // get user input
        System.out.print("Shrink start index: ");
        int startIndex = scnr.nextInt();
        System.out.print("Shink end index: ");
        int endIndex = scnr.nextInt();

        return shrink(word, startIndex, endIndex);
    }

    // changes all letters in specified range to uppercase
    static String upset(String word, int startIndex, int endIndex) {
        String firstPart = word.substring(0, startIndex);
        // get the specified range of the word and convert to lowercase
        String secondPart = word.substring(startIndex, endIndex).toUpperCase();
        // get the rest of the word after the specified range
        String thirdPart = word.substring(endIndex, word.length());

        String upsetWord = firstPart + secondPart + thirdPart;

        System.out.println(" > Upsetting \"" + word + "\" at " + startIndex + " to " + endIndex);

        return upsetWord;
    }

    // gets user input for start and end index
    static String upset(String word, Scanner scnr) {
        System.out.print("Upsetting start index: ");
        int startIndex = scnr.nextInt();
        System.out.print("Upsetting end index: ");
        int endIndex = scnr.nextInt();

        return upset(word, startIndex, endIndex);
    }

    // creates a space in a word at the specified index
    static String punch(String word, int index) {
        String firstPart = word.substring(0, index);
        String secondPart = word.substring(index, word.length());
        // put a space in between first and second halves
        String punchedWord = firstPart + " " + secondPart;

        System.out.println(" > Punching \"" + word + "\" at " + index);

        return punchedWord;
    }

    static String punch(String word, Scanner scnr) {
        System.out.print("Punch at index: ");
        int index = scnr.nextInt();

        return punch(word, index);
    }

    // concatenates words together like welding metal
    static String weld(String firstWord, String secondWord) {
        String weldedWord = firstWord + secondWord;
        System.out.println(" > Welding \"" + firstWord + "\" with \"" + secondWord + "\"");

        return weldedWord;
    }

    // gets user input for the second word
    static String weld(String firstWord, Scanner scnr) {
        System.out.print("Enter a word to weld to \"" + firstWord + "\": ");
        String secondWord = scnr.next();

        return weld(firstWord, secondWord);
    }

    // stamps an 'die' word into a word at the specified starting index
    static String stamp(String word, String die, int startIndex) {
        String firstPart = word.substring(0, startIndex);
        // stamp the die to the first part of the word
        String stampedWord = firstPart + die;
        // reduce the stamped word length to original word length
        stampedWord = String.format("%." + word.length() + "s", stampedWord);
        // get the rest after the stamped part and add it to the stamped word
        String secondPart = word.substring(stampedWord.length(), word.length());
        stampedWord += secondPart;

        System.out.println(" > Stamping \"" + word + "\" with \"" + die + "\" at " + startIndex + ": ");

        return stampedWord;
    }

    // gets user input for die and starting index. then stamps the word
    static String stamp(String word, Scanner scnr) {
        String temp = scnr.nextLine();

        System.out.print("Enter a stamping die: ");
        String die = scnr.nextLine();

        System.out.print("Enter the stamping index: ");
        int startIndex = scnr.nextInt();

        return stamp(word, die, startIndex);
    }
}