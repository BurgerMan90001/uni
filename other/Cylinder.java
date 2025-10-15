package other;

public class Cylinder {
    public static void main(String[] args) {
        double myCricleArea = circleArea(10);
        System.out.println(myCricleArea);
    }

    static double circleArea(double radius) {
        double area = 0;

        area = Math.PI * radius * radius;

        return area;
    }
}
