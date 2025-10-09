import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        test1();
    }

    static void q4() {
        int test = 3 / (2 + 1) % 2;
        int test2 = 3 % 2 + 1 % 2;
        double test3 = (4.5 / 2) % 3 - (5 / 2.0);
        double test4 = 5 / 2 % 1.5 - 10 / -2.0;
        System.out.println(test);
        System.out.println(test2);
        System.out.println(test3);
        System.out.println(test4);
    }

    static void test1() {
        String words = "wop wop wop opw opw";

        Scanner scnr = new Scanner(System.in);

        String input = scnr.nextLine();
        Scanner scnr2 = new Scanner(input);

        String a = scnr2.next();
        String b = scnr2.next();
        String c = scnr2.next();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}