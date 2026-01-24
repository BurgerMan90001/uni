package Labs;

public class Lab9 {
    public static void main(String[] args) {

        String[] arr = new String[10];
        arr[0] = "bac";
        arr[1] = "aabkokkk";
        arr[2] = "asdasd";
        arr[3] = "dw";
        arr[4] = "pff";

        int length = 5;

        // int order = arr[i].compareTo("abb");

        // System.out.println(order);
        boolean isAlphabetical = isAlphabetical(arr, length);
        boolean orderedLengths = orderedLengths(arr, length);
        int stringsWithChar = stringsWithChar(arr, length, 'a');

        System.out.println(isAlphabetical);
        System.out.println(orderedLengths);
        System.out.println(stringsWithChar);

        length = deleteThreshold(arr, length, 4);

        printArray(arr, 4);

    }

    // 1
    static boolean isAlphabetical(String[] arr, int length) {
        boolean isAlphabetical = true;
        for (int i = 0; i < length; i++) {
            if (arr[i + 1] != null) {
                int order = arr[i].compareTo(arr[i + 1]);
                if (!(order < 0)) {
                    isAlphabetical = false;
                }
            }
        }
        return isAlphabetical;
    }

    // 2
    static boolean orderedLengths(String[] arr, int length) {
        boolean orderedLengths = true;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i].length() > arr[i + 1].length()) {
                orderedLengths = false;
            }
        }
        return orderedLengths;
    }

    static int stringsWithChar(String[] arr, int length, char character) {
        int stringsWithChar = 0;
        for (int i = 0; i < length; i++) {
            String item = arr[i];
            for (int j = 0; j < item.length(); j++) {
                if (item.charAt(j) == character) {
                    stringsWithChar++;
                    break;
                }
            }
        }
        return stringsWithChar;
    }

    static int delete(String[] arr, int length, int index) {
        for (int j = index; j < length; j++) {
            arr[j] = arr[j + 1];
        }
        length--;
        return length;
    }

    static int deleteThreshold(String[] arr, int length, int threshold) {

        for (int i = 0; i < length; i++) {
            if (arr[i].length() < threshold) {
                // arr[i] = "aaaa";
                for (int j = i; j < length; j++) {
                    arr[j] = arr[j + 1];
                }
                length--;
            }
        }
        return length;
    }

    static void printArray(String[] arr, int length) {
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
