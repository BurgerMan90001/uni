import java.util.Scanner;

/*
* COMP 1010 SECTION A02
* INSTRUCTOR: Emanuel Wiens 
* STUDENT NAME: Paul Casigay
* STUDENT NUMBER: 8061457
* ASSIGNMENT: 3
* QUESTION: 1
*
* PURPOSE: Calculates the trajectory of a cannon based on user input. 
*/

public class CasigayPaulA3Q1 {
    // earth gravity is 9.8m/s^2
    static final double GRAVITY_ACCELERATION = 9.8;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        double wallPos = getwallPos();
        double wallHeight = getWallHeight();

        // amount of attempts to shoot the cannon
        int tries = 3;
        // double angleDegrees = getAngleDegrees(scnr);
        while (tries > 0) {

            tries--;
        }
    }

    static void testSuite() {
        System.out.println(getWallHeight());
        System.out.println(getWallHeight());
        System.out.println(getWallHeight());
        System.out.println(getWallHeight());
        System.out.println(getWallHeight());
        System.out.println(getWallHeight());
        System.out.println(getWallHeight());
    }

    // gets user input for the cannon's angle in degrees
    static double getAngleDegrees(Scanner scnr) {
        System.out.print("Enter the cannon's angle in degrees: ");
        double angleDegrees = scnr.nextDouble();
        return angleDegrees;
    }

    // gets user input for the cannon's velocity in m/s
    static double getVelocity(Scanner scnr) {
        System.out.print("Enter the cannon's velocity in m/s:");
        double velocity = scnr.nextDouble();
        return velocity;
    }

    static void shootCannon(double angleDegrees, double velocity, double wallPos, double wallHeight) {

    }

    static void shootCannon(Scanner scnr, double wallPos, double wallHeight) {
        double angleDegrees = getAngleDegrees(scnr);
        double velocity = getVelocity(scnr);
        shootCannon(angleDegrees, velocity, wallPos, wallHeight);
    }

    // gets a random height between 10 and 100 metres
    static double getWallHeight() {
        double wallHeight = (Math.random() * 100);
        return wallHeight;
    }

    // gets a random position between 25 and 125 metres
    static double getwallPos() {
        double wallPos = (Math.random() * 100) + 25;
        return wallPos;
    }

    static double getWallPos(double velocity, double angleRadians, double secondsTime) {
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

    static double getRandomNum(int min, int max) {
        return Math.random() * (max - min) + min;
    }
}
