/*
* COMP 1010 SECTION A02
* INSTRUCTOR: Emanuel Wiens 
* STUDENT NAME: Paul Casigay
* STUDENT NUMBER: 8061457
* ASSIGNMENT: 2
* QUESTION: 1
*
* PURPOSE: Performs smithing operations on words with techniques like welding, stamping, punching, and shrinking.
*/
public class CasigayPaulA2Q1 {
    public static void main(String[] args) {
        String word1 = "smithing";
        String word2 = "SMITHING";
        String die = "hear";
        // word = "tEsT";
        // word = "SmiTHiNg";
        // word = "SmiiTHiNG";

        String drawnOutWord = drawOut(word1, 2);
        String shrunkWord = shrink(word2, 4, 7);
        String upsetWord = upset(word1, 4, 7);
        String punchedWord = punch(word1, 5);

        System.out.print("Result of drawing out \"" + drawnOutWord + "\": ");
        System.out.print("Result of shrinking \"" + shrunkWord + "\": ");
        System.out.print("Result of upsetting \"" + upsetWord + "\": ");
        System.out.print("Result of punching \"" + punchedWord + "\": ");

        System.out.println(" ---Testing stamp method");

        // testing for index out of bounds crashes
        testStamp(word1, die, "", 0);
        testStamp(word1, die, "", 1);
        testStamp(word1, die, "", 2);
        testStamp(word1, die, "", 3);
        testStamp(word1, die, "", 4);
        // testing for index out of bounds crashes
        testStamp(word1, die, "", word1.length() - 1);

        testSuite();

        System.out.println("Program terminated successfully.");
    }

    static void testSuite() {

    }

    static void testStamp(String word, String die, String expected, int startIndex) {
        String stampedWord = stamp(word, die, startIndex);
        System.out.print("Result of stamping \"" + word + "\": ");
        System.out.print(stampedWord);
        System.out.println(", Expected: " + expected);
    }
    /*
     * 
     * static void printTest(String methodName, String testedWord) {
     * System.out.print("Result of " + methodName + " \"" + testedWord + "\": ");
     * }
     */

    // duplicates a character in a word at the specified index
    static String drawOut(String word, int index) {
        char character = word.charAt(index);

        String firstPart = word.substring(0, index);
        String secondPart = word.substring(index, word.length());
        // put the indexed char and put in between first and second halves
        String drawnOutWord = firstPart + character + secondPart;

        return drawnOutWord;
    }

    // changes all letters in specified range to lowercase
    static String shrink(String word, int startIndex, int endIndex) {
        String firstPart = word.substring(0, startIndex);
        // get the specified range of the word and convert to lowercase
        String secondPart = word.substring(startIndex, endIndex).toLowerCase();
        // get the rest of the word after the specified range
        String thirdPart = word.substring(endIndex, word.length());

        String shrinkedWord = firstPart + secondPart + thirdPart;

        return shrinkedWord;
    }

    // changes all letters in specified range to uppercase
    static String upset(String word, int startIndex, int endIndex) {
        String firstPart = word.substring(0, startIndex);
        // get the specified range of the word and convert to lowercase
        String secondPart = word.substring(startIndex, endIndex).toUpperCase();
        // get the rest of the word after the specified range
        String thirdPart = word.substring(endIndex, word.length());

        String upsetWord = firstPart + secondPart + thirdPart;

        return upsetWord;
    }

    // creates a space in a word at the specified index
    static String punch(String word, int index) {
        String firstPart = word.substring(0, index);
        String secondPart = word.substring(index, word.length());
        // put a space in between first and second halves
        String drawnOutWord = firstPart + " " + secondPart;

        return drawnOutWord;
    }

    // concatenates words together like welding metal
    static String weld(String firstWord, String secondWord) {
        String weldedWord = firstWord + secondWord;
        return weldedWord;
    }

    // stamps an 'die' word into a word at the specified starting index
    static String stamp(String word, String die, int startIndex) {
        String firstPart = word.substring(0, startIndex);
        // stamp the die to the first part of the word
        String stampedWord = firstPart + die;

        stampedWord = reduce(stampedWord, word.length());

        String secondPart = word.substring(stampedWord.length(), word.length());
        stampedWord += secondPart;

        return stampedWord;
    }

    // shortens a string to specified length.
    static String reduce(String word, int length) {
        // to avoid index out of bounds exception by using substring
        String reducedWord = String.format("%." + length + "s", word);
        return reducedWord;
    }

}