public class ArrayActivityNov26 {
    public static void main(String[] args) {
        // Create your partially filled integer array here
        int[] myPartialArray = new int[100];
        int filledIndex = 0;

        // Hint, try adding more values to the list
        filledIndex = orderedInsert(myPartialArray, filledIndex, 2);
        filledIndex = orderedInsert(myPartialArray, filledIndex, 200);
        filledIndex = orderedInsert(myPartialArray, filledIndex, 12);
        filledIndex = orderedInsert(myPartialArray, filledIndex, 123);
        filledIndex = orderedInsert(myPartialArray, filledIndex, 100);

        // System.out.println(filledIndex);
        // myPartialArray[7] = 123;

        printArray(myPartialArray, filledIndex);
    }

    // TODO This method has 3 bugs. Can you fix them?
    // This method takes an array and inserts items in order from smallest to
    // largest
    // int[] arr - the array we are inserting the value
    // int filledIndex - how full the partially full array is
    // int value - the value we are inserting into the array
    // returns the
    static int orderedInsert(int[] arr, int filledIndex, int value) {
        // Assume we do not know where to insert this new int
        int insertIndex = -1;

        // Find where to insert the int by seeing if it is larger than all the other
        // ints
        for (int i = 0; i < filledIndex; i++) {
            if (arr[i] > value) {
                insertIndex = i;
                break;
            }
        }

        // The array is empty and we are adding the first int, or
        // The array is not empty and the int we are inserting is larger than all the
        // other values in the array
        if ((filledIndex == 0) || (filledIndex > 0 && insertIndex == -1)) {
            arr[filledIndex] = value;

            // The array is not empty, and the int we are inserting is not larger than all
            // the other integers
        } else if (filledIndex > 0 && insertIndex != -1) {
            // Starting from the last int, shift all the ints over by 1
            for (int i = filledIndex - 1; i + 1 > insertIndex; i--) {
                arr[i + 1] = arr[i];
            }

            // Then insert the int into the right spot in the array
            arr[insertIndex] = value;
        }

        filledIndex++;
        return filledIndex;
    }

    static int delete(int[] arr, int filledIndex, int value) {
        int indexToDelete = search(arr, filledIndex, value);

        if (indexToDelete != -1) { // if we found the value in the array
            for (int i = indexToDelete; i < filledIndex - 1; i++) {
                arr[i] = arr[i + 1];
            }

            filledIndex--;
        }

        return filledIndex;
    }

    static int search(int[] arr, int filledIndex, int value) {
        int found = -1;

        for (int i = 0; i < filledIndex && found == -1; i++) {
            if (arr[i] == value)
                found = i;
        }

        return found;
    }

    static int insert(int[] arr, int filledIndex, int value) {
        arr[filledIndex] = value;
        filledIndex += 1;
        return filledIndex;
    }

    static void printArray(int[] arr, int filledIndex) {
        System.out.print("[");
        for (int i = 0; i < filledIndex; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.print("]\n");
    }
}
