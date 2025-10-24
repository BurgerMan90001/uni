package tests;

public class A2 {
    public static void main(String[] args) {

    }

    static void printTestResult(String word, int index, String result, String expected) {
        System.out.print("Result of stamping \"" + word + "\" at index " + index + ": ");
        System.out.print(result);
        System.out.println(", Expected: " + expected);
    }

    static void printTestResult(String word, int indexOne, int indexTwo, String result, String expected) {
        System.out.print("Result of stamping \"" + word + "\"");
        System.out.print(" from index " + indexOne + " to " + indexTwo + ": ");
        System.out.print(result);
        System.out.println(", Expected: " + expected);
    }

    static void printTestResult(String word, String die, String result, String expected, int index) {

    }

    static void printTest(String methodName, String testedWord) {
        System.out.print("Result of " + methodName + " \"" + testedWord + "\": ");
    }
    /*
     * static void test(String word, String die) {
     * String drawnOutWord = drawOut(word, 2);
     * String shrunkWord = shrink(drawnOutWord, 4, 6);
     * String upsetWord = upset(shrunkWord, 0, 2);
     * String weldedWord = weld(upsetWord, "addon");
     * String punchedWord = punch(weldedWord, 3);
     * String stampedWord = stamp(punchedWord, die, 4);
     * 
     * System.out.println("Final result of smithWord: " + stampedWord);
     * }
     */

}
