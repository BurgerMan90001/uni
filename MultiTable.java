public class MultiTable {
    public static void main(String[] args) {
        boop();
    }

    static void table() {
        int numRow = 5;
        int numCol = 5;

        for (int i = 0; i < numRow; i++) {

        }
        for (int i = 1; i <= numRow; i++) {
            System.out.print(i + "|");
            for (int j = 1; j <= numCol; j++) {

                System.out.print((j * i) + " ");

            }
            System.err.println();
        }
    }

    static void boop() {
        int range = 5;

        for (int i = 1; i <= range; i++) {

            for (int j = 1; j <= range; j++) {

                if (j == 1) {
                    System.out.printf("%3d |", i * j);
                } else {

                    System.out.printf("%3d", i * j);
                }
                if (i == 1) {
                    // System.out.printf("%3d", i * j);
                    // System.out.printf("-");
                }
            }
            System.out.println();
        }
    }
}
