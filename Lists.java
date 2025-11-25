public class Lists {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int arrLength = 0;

        arrLength = insert(arr, arrLength, 1);
        arrLength = insert(arr, arrLength, 2);
        arrLength = insert(arr, arrLength, 7);
        arrLength = insert(arr, arrLength, 2);
        arrLength = insert(arr, arrLength, 890238);

        printArray(arr, arrLength);

        int index = search(arr, arrLength, 26);
        System.out.println(index);
    }

    static int search(int[] arr, int length, int number) {
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (arr[i] == number) {
                index = i;
            }
        }
        return index;
    }

    static int insert(int[] arr, int length, int number) {
        arr[length] = number;
        length++;
        return length;
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
