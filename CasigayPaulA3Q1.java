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

        double wallHeight = getRandomNum(10, 100);
        // double wallPos = getRandomNum(25, 125);
        double wallPos = 50f;

        System.out.println("The wall has a height of " + wallHeight + "m and is " + wallPos + "m away.");
        // startGame(scnr, wallPos, wallHeight);
        shootCannon(scnr, wallPos, wallHeight);

        scnr.close();
    }

    static void testSuite() {

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

    static boolean isInvalidAngle(double angleDegrees) {
        return (angleDegrees > 90) || (angleDegrees < 0);
    }

    static boolean shootCannon(double angleRadians, double velocity, double wallPos, double wallHeight) {
        boolean wentOverWall = true;

        double secondsTime = getTimeAtWallPos(velocity, angleRadians, wallPos);
        System.out.println("Time in seconds: " + secondsTime);

        double yPos = getYPos(velocity, angleRadians, secondsTime);
        System.out.println("y position of ball: " + yPos);

        return wentOverWall;
    }

    static void shootCannon(Scanner scnr, double wallPos, double wallHeight) {
        // amount of attempts to shoot the cannon
        int tries = 3;

        while (tries > 0) {
            double angleDegrees = getAngleDegrees(scnr);
            // check if angle is valid before calculating
            if (isInvalidAngle(angleDegrees)) {
                System.out.println("Invalid angle, -1 turn.");

            } else {
                double angleRadians = Math.toRadians(angleDegrees);
                double velocity = getVelocity(scnr);

                shootCannon(angleRadians, velocity, wallPos, wallHeight);
            }
            tries--;
        }

    }

    static double getShotPos(double velocity, double angleRadians, double secondsTime) {
        double xPos = velocity * Math.cos(angleRadians) * secondsTime;
        return xPos;
    }

    static double getTimeAtWallPos(double velocity, double angleRadians, double xPos) {
        double secondsTime = (xPos) / (Math.cos(angleRadians) * velocity);
        return secondsTime;
    }

    static double getYPos(double velocity, double angleRadians, double secondsTime) {
        double temp = (0.5 * GRAVITY_ACCELERATION * Math.pow(secondsTime, 2));
        double yPos = velocity * Math.sin(angleRadians) * secondsTime;

        yPos -= temp;
        return yPos;
    }

    static double getYMax(double velocity) {
        double yMax = Math.pow(velocity, 2) / (2 * GRAVITY_ACCELERATION);
        return yMax;
    }

    static void wentOverWall(boolean wentOverWall) {

        if (wentOverWall) {
            System.out.println("The ball went over the wall!");
        } else {
            System.out.println("The ball did not reach the wall");
        }
    }

    static double getRandomNum(int min, int max) {
        return round(Math.random() * (max - min) + min);
    }

    static double round(double num) {
        return Math.round(num * 100);
    }
}
