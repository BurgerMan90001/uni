import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        // test2();
        test();
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

    static void test() {
        String coord = "302,211,133";
        int firstCommaIndex = coord.indexOf(',');
        int secondCommaIndex = coord.lastIndexOf(',');

        int x = Integer.parseInt(coord.substring(0, firstCommaIndex));
        int y = Integer.parseInt(coord.substring(firstCommaIndex + 1, secondCommaIndex));
        int z = Integer.parseInt(coord.substring(secondCommaIndex + 1, coord.length()));

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

    static void test1() {

        String words = "wop wop wop opw opw";
        String test = " \' \' awdadw";

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

    static void test2() {
        double num = 12.234;
        System.out.printf("%-5s\n", "aw");
        System.out.printf("%07d\n", 12);

        System.out.printf("%010.3f\n", 12.234);
    }

}