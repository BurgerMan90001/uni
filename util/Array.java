package util;

public class Array {
    public static void print(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.print("]\n");
    }

    public static int delete(int[] arr, int filledIndex, int value) {
        int indexToDelete = search(arr, filledIndex, value);

        if (indexToDelete != -1) { // if we found the value in the array
            for (int i = indexToDelete; i < filledIndex - 1; i++) {
                arr[i] = arr[i + 1];
            }

            filledIndex--;
        }

        return filledIndex;
    }

    public static int search(int[] arr, int filledIndex, int value) {
        int found = -1;

        for (int i = 0; i < filledIndex && found == -1; i++) {
            if (arr[i] == value)
                found = i;
        }

        return found;
    }

    public static int insert(int[] arr, int filledIndex, int value) {
        arr[filledIndex] = value;
        filledIndex += 1;
        return filledIndex;
    }
}
