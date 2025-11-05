package Activities;

class CheckerBoard {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i % 2 == 0) {
                    System.out.print("x ");
                } else {
                    System.out.print(" x");
                }
            }
            System.out.println();
        }
    }
}