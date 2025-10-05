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

        // System.out.println("max index: " + (word.length() - 1));

        String drawnOutWord = drawOut(word1, 2);
        String shrunkWord = shrinking(word2, 4, 7);
        String upsetWord = upsetting(word1, 4, 7);
        String punchedWord = punching(word1, 5);
        String stampedWord = stamping(word1, die, 1);

        System.out.println(drawnOutWord);
        System.out.println(shrunkWord);
        System.out.println(upsetWord);
        System.out.println(punchedWord);
        System.out.println(stampedWord);
        System.out.println("Program terminated successfully.");
    }

    static void testSuite() {

    }

    static String drawOut(String word, int index) {
        char character = word.charAt(index);
        // get the first half of the word
        String firstPart = word.substring(0, index);
        // get the second half of the word
        String secondPart = word.substring(index, word.length());
        // put the indexed char and put in between first and second halves
        String drawnOutWord = firstPart + character + secondPart;

        return drawnOutWord;
    }

    static String shrinking(String word, int startIndex, int endIndex) {
        // get the first half of the word
        String firstPart = word.substring(0, startIndex);
        // get the specified range of the word and convert to lowercase
        String secondPart = word.substring(startIndex, endIndex).toLowerCase();
        // get the rest of the word after the specified range
        String thirdPart = word.substring(endIndex, word.length());
        // concatenate the string
        String shrinkedWord = firstPart + secondPart + thirdPart;

        return shrinkedWord;
    }

    static String upsetting(String word, int startIndex, int endIndex) {
        // get the first half of the word
        String firstPart = word.substring(0, startIndex);
        // get the specified range of the word and convert to lowercase
        String secondPart = word.substring(startIndex, endIndex).toUpperCase();
        // get the rest of the word after the specified range
        String thirdPart = word.substring(endIndex, word.length());
        // concatenate the string
        String upsetWord = firstPart + secondPart + thirdPart;

        return upsetWord;
    }

    static String punching(String word, int index) {
        // get the first half of the word
        String firstPart = word.substring(0, index);
        // get the second half of the word
        String secondPart = word.substring(index, word.length());
        // put a space in between first and second halves
        String drawnOutWord = firstPart + " " + secondPart;

        return drawnOutWord;
    }

    static String welding(String firstWord, String secondWord) {
        // concatenate the words to weld them together
        String weldedWord = firstWord + secondWord;
        return weldedWord;
    }

    static String stamping(String word, String die, int startIndex) {
        int originalWordLength = word.length();
        int test = startIndex + die.length();
        // int yes = (test - word.length());
        // test = test - (test % word.length());

        String firstPart = word.substring(0, startIndex);

        String stampedWord = firstPart + die;
        // int yes = startIndex + die.length();
        System.out.println(stampedWord.length());
        String secondPart = word.substring(startIndex, word.length());
        stampedWord += secondPart;

        // stampedWord = stampedWord.substring(0, yes);

        // int test = startIndex + die.length();

        // System.out.println(yes);
        // int test = stampedWord.length();

        // String first = stampedWord.substring(0, die.length() + 1);
        // String second = stampedWord.substring(test - die.length() + 1,
        // stampedWord.length());

        // stampedWord = first + second;
        // stampedWord = stampedWord.substring(die.length() + 1, test - die.length());

        // return stampedWord.substring(0, originalWordLength);
        // return stampedWord.substring(0, firstPart.length() + die.length());

        return stampedWord;
    }

}