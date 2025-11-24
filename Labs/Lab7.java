package Labs;

public class Lab7 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        // Create a new array that is the reverse of arr
        int[] reverse = reverse(arr);

        reverseInPlace(arr);

        // Reverse
        printArray(reverse);
        System.out.print("\n");
        // Reverse in place
        printArray(arr);

    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int[] reverse(int[] arr) {
        int[] reverse = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverse[i] = arr[arr.length - i - 1];
        }
        return reverse;
    }

    static void reverseInPlace(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int last = arr.length - i - 1;
            int first = i;

            int temp = arr[first];

            arr[first] = arr[last];
            arr[last] = temp;
        }
    }

}
