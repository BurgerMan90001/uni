package Activities;

public class Lists {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 6, 1, 0 };
        int arrLength = arr.length - 1;

        /*
         * arrLength = insert(arr, arrLength, 1);
         * arrLength = insert(arr, arrLength, 2);
         * arrLength = insert(arr, arrLength, 7);
         * arrLength = insert(arr, arrLength, 2);
         * arrLength = insert(arr, arrLength, 10);
         * 
         * printArray(arr, arrLength);
         * 
         * int index = search(arr, arrLength, 26);
         * System.out.println(index);
         * 
         * arrLength = delete(arr, arrLength, 10);
         * printArray(arr, arrLength);
         */

        arrLength = orderedInsert(arr, arrLength, 10);
        // arrLength = orderedInsert(arr, arrLength, 10);
        printArray(arr, arrLength);

    }

    static int search(int[] arr, int length, int number) {
        int index = -1;
        for (int i = 0; i < length && index == -1; i++) {
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

    static int orderedInsert(int[] arr, int length, int number) {
        boolean biggestNum = true;
        int index = -1;
        for (int i = 0; i < length && index == -1; i++) {
            // If the chosen number is less than found number in array
            if (number < arr[i]) {
                // It is not the biggest
                biggestNum = false;
                index = i;
            }
        }

        // If there is empty array
        if (length == 0) {
            arr[0] = number;
        } else if (biggestNum) {
            arr[length] = number;
        } else {
            for (int i = length + 1; i > index; i--) {
                // Shift each item to the left once
                arr[i] = arr[i - 1];
            }
            arr[index] = number;
        }
        length++;
        return length;

    }

    static int delete(int[] arr, int length, int number) {
        int index = search(arr, length, number);
        // If the number was found in the array
        if (index != -1) {
            for (int i = index; i < length - 1; i++) {
                // Shift each item to the left once
                arr[i] = arr[i + 1];
            }
            length--;
        }
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
