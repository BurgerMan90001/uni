
public class CasigayPaulA2Q1 {
    public static void main(String[] args) {
        String word = "smithing";

        System.out.println("max index: " + (word.length() - 1));

        String drawnOutWord = drawOut(word, 2);

        System.out.println(drawnOutWord);

    }

    static void testSuite() {

    }

    static String drawOut(String word, int index) {
        char test = word.charAt(index);
        // get the first half of the word
        String firstHalf = word.substring(0, index);
        // get the second half of the word
        String secondHalf = word.substring(index, word.length());
        // put the indexed char and put in between first and second halves
        String drawnOutWord = firstHalf + test + secondHalf;

        return drawnOutWord;
    }

    static String upsetting(String word) {
        return "";
    }

    static String punching(String word) {
        return "";
    }

    static String welding(String word) {
        return "";
    }

    static String stamping(String word) {
        return "";
    }

}