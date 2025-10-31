package Labs;

public class Lab6 {
    public static void main(String[] args) {
        int width = 2;
        int diameter = 2;
        calculateCircleArea(2);
    } // pi r^2

    static void calculateCircleArea(int radius) {
        double squareArea = 4.0;
        double circleArea = 0f;

        for (int i = 0; i < 100; i++) {
            int count = 0;
            double x = (Math.random() * 2) - 1;
            double y = (Math.random() * 2) - 1;

            double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            if (dist <= 1) {
                count++;
            }
            for (int j = 0; j < 100; j++) {

                circleArea = (squareArea * count) / 100;
                // calculateCircleArea(diameter / 2);

            }
        }

        System.out.println(circleArea);
    }
}
