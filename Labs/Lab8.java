package Labs;

public class Lab8 {
    public static void main(String[] args) {
        int[] arr = { 1, 23, 5, 6, 8, 0, 0, 0 };

        // New array is [1, 5, 6]
        int[] filtered = filter2(arr, 5, 7);

        printArray(filtered, 3);

    }

    static int[] filter2(int[] arr, int length, int limit) {

        int filterCount = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] < limit) {
                filterCount++;
            }
        }

        int[] filterArr = new int[filterCount];

        int j = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] < limit) {
                filterArr[j] = arr[i];
                j++;
            }
        }
        return filterArr;

    }

    // Modify in place
    static int filter(int[] arr, int length, int limit) {
        int filterLength = length;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > limit) {
                // Delete it
                for (int j = i; j < filterLength - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                filterLength--;
            }
        }
        return filterLength;
    }

    static void printArray(int[] arr, int length) {
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
