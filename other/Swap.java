package other;
// Swap.java

public class Swap {
    public static void main(String[] args) {
        int a = 13;
        int b = 1;
        System.out.println("Before swap \ta: " + a + ", b: " + b);

        // with temp variable
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swap one \ta: " + a + ", b: " + b);

        // without temp
        a += b;
        b = a - b;
        a -= b;
        System.out.println("After swap two \ta: " + a + ", b: " + b);
    }
}
