package A2;

/*
* COMP 1010 SECTION A02
* INSTRUCTOR: Emanuel Wiens 
* STUDENT NAME: Paul Casigay
* STUDENT NUMBER: 8061457
* ASSIGNMENT: 2
* QUESTION: 1
*
* PURPOSE: Performs smithing operations on words with techniques such as welding, stamping, punching, and shrinking.
*/
public class CasigayPaulA2Q1 {
    public static void main(String[] args) {
        // lowercase and capitalized letters for showing shrink and upset
        String word1 = "smithing";
        String word2 = "SMITHING";
        String die = "die";

        testSuite(word1, word2, die);

        System.out.println("Program terminated successfully.");
    }

    static void testSuite(String word1, String word2, String die) {
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

        // testing for index out of bounds crashes
        String stampedWord = stamp(word1, die, 2);
        printResult(stampedWord, "smdieing");

        smithWord(word1, die);

        System.out.println("----> TEST SUITE END");
    }

    // performs all smithing operations consecutively on a single word
    static void smithWord(String word, String die) {
        System.out.println(" ----> Smithing the word \"" + word + "\"");

        String drawnOutWord = drawOut(word, 2);
        printResult(drawnOutWord);

        String shrunkWord = shrink(drawnOutWord, 4, 7);
        printResult(shrunkWord);

        String upsetWord = upset(shrunkWord, 4, 7);
        printResult(upsetWord);

        String weldedWord = weld(upsetWord, word);
        printResult(weldedWord);

        String punchedWord = punch(weldedWord, 5);
        printResult(punchedWord);

        String stampedWord = stamp(punchedWord, die, 2);

        System.out.println("Final result of smithWord: " + stampedWord);
    }

    // prints resulting word and the expected word
    static void printResult(String result, String expected) {
        System.out.println("Result:   " + result);
        System.out.println("Expected: " + expected);
    }

    // only prints resulting word
    static void printResult(String result) {
        System.out.println("Result: " + result);
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

    // creates a space in a word at the specified index
    static String punch(String word, int index) {
        String firstPart = word.substring(0, index);
        String secondPart = word.substring(index, word.length());
        // put a space in between first and second halves
        String punchedWord = firstPart + " " + secondPart;

        System.out.println(" > Punching \"" + word + "\" at " + index);

        return punchedWord;
    }

    // concatenates words together like welding metal
    static String weld(String firstWord, String secondWord) {
        String weldedWord = firstWord + secondWord;
        System.out.println(" > Welding \"" + firstWord + "\" with \"" + secondWord + "\"");

        return weldedWord;
    }

    /// stamps an 'die' word into a word at the specified starting index
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
}