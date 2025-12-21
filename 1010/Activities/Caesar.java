package Activities;

public class Caesar {
    public static void main(String[] args) {
        String appleWord = "apple";
        String cipher = "ettpi";
        int key = 4;

        System.out.println(encrypt(appleWord, key));
        System.out.println(decrypt(cipher, key));

    }

    static int a = (int) 'a';
    static int z = (int) 'z';

    static String encrypt(String word, int key) {
        String cipher = "";
        int value;
        int difference;
        for (int i = 0; i < word.length(); i++) {
            value = word.charAt(i) + key;
            difference = z - value;

            if (difference < 0) {
                cipher += (char) (a - difference - 1);
            } else {
                cipher += (char) value;
            }

        }
        return cipher;
    }

    static String decrypt(String cipher, int key) {
        String plaintext = "";
        int value;
        int difference;
        for (int i = 0; i < cipher.length(); i++) {
            value = cipher.charAt(i) - key;
            difference = value - a;

            if (difference < 0) {
                plaintext += (char) (z + difference + 1);
            } else {
                plaintext += (char) value;
            }
        }
        return plaintext;
    }

}
