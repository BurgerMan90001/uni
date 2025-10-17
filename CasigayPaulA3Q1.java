import java.util.Scanner;

public class CasigayPaulA3Q1 {
    // earth gravity is 9.8m/s^2
    static final double GRAVITY_ACCELERATION = 9.8;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int wallPosition = (int) Math.random();

    }

    static void shootCannon(double angleDegrees, double velocity, double ) {

    }

    static void shootCannon(Scanner scnr) {

    }

    static void getWallHeight() {

    }

    static void getWallDistance() {

    }

    static double getXPos(double velocity, double angleRadians, double secondsTime) {
        double xPos = velocity * Math.cos(angleRadians) * secondsTime;
        return xPos;
    }

    static double getSecondsTime(double velocity, double angleRadians, double xPos) {
        double secondsTime = (xPos) / (Math.cos(angleRadians) * velocity);
        return secondsTime;
    }

    static double getYPos(double velocity, double angleRadians, double secondsTime) {
        double temp = secondsTime - ((1 / 2) * GRAVITY_ACCELERATION * Math.pow(secondsTime, 2));
        double yPos = velocity * Math.sin(angleRadians) * temp;
        return yPos;
    }

    static double getYMax(double velocity) {
        double yMax = Math.pow(velocity, 2) / (2 * GRAVITY_ACCELERATION);
        return yMax;
    }

    static void didHitWall() {
        System.out.println("The ball went over the wall!");

        System.out.println("The ball did not reach the wall");
    }
}
