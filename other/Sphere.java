package other;

import java.util.Scanner;

public class Sphere {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        // inital cordinates
        double x1 = 1;
        double y1 = 1;

        // final cordinates
        double x2 = 5;
        double y2 = 100000;

        // direction vectors
        double x = x2 - x1;
        double y = y2 - y1;

        double c = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        // normalize the vectors
        double xNorm = x / c;
        double yNorm = y / c;

        System.out.printf("%.2f\n", xNorm);
        System.out.printf("%.2f\n", yNorm);
        scnr.close();

    }
}
