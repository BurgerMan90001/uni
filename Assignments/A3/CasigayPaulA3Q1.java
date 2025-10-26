package A3;

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
    static final double GRAVITY = 9.8;
    // 100km threshold for ball
    static final int MAX_Y_THRESHOLD = 100000;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        double wallHeight = getRandomNum(10, 100);
        double wallPos = getRandomNum(25, 125);

        System.out.print(" > The wall has a height of " + wallHeight + "m and is ");
        System.out.println(wallPos + "m away.");

        // Give the user 3 tries
        shootCannon(scnr, wallPos, wallHeight);
        shootCannon(scnr, wallPos, wallHeight);
        shootCannon(scnr, wallPos, wallHeight);

        testSuite();

        scnr.close();
    }

    static void testSuite() {
        System.out.println("____TEST SUITE____");
        double wallHeight = 50.0;
        double wallPos = 50.0;

        // Goes over the max threshold
        printExpected(0.00031, 2864.5, "go over the max threshold");
        shootCannon(Math.toRadians(89), 9000000, wallPos, wallHeight);

        // Goes over the wall
        printExpected(0.1, 86.554, "go over the wall");
        shootCannon(Math.toRadians(60), 1000, wallPos, wallHeight);

        // Hits the wall
        printExpected(2.8, 10.85, "hit the wall");
        shootCannon(Math.toRadians(45), 25, wallPos, wallHeight);

        // Does not reach the wall
        printExpected(14.14, -930, "not reach wall");
        shootCannon(Math.toRadians(45), 5, wallPos, wallHeight);

        System.out.println("____TEST SUITE END____");
    }

    static void printExpected(double time, double yPos, String result) {
        System.out.println(" > Expected to " + result + " at " + time + "s and at " + yPos + "m");
    }

    static void shootCannon(double angleRadians, double velocity, double wallPos, double wallHeight) {
        // Calculate the shot's time and y position when it reaches the wall
        double secondsTime = getTimeAtXPos(velocity, angleRadians, wallPos);
        double yPos = getYPos(velocity, angleRadians, secondsTime);
        double yMax = getYMax(velocity, angleRadians);

        printShotInfo(secondsTime, yPos);

        printResult(yPos, yMax, wallHeight);
    }

    // helper method to get user input for angle and velocity
    static void shootCannon(Scanner scnr, double wallPos, double wallHeight) {
        double angleDegrees = userAngleDegrees(scnr);
        // check if angle is valid before calculating
        if (isInvalidAngle(angleDegrees)) {
            System.out.println("Invalid angle, -1 turn.");
        } else {
            double angleRadians = Math.toRadians(angleDegrees);
            double velocity = userVelocity(scnr);

            shootCannon(angleRadians, velocity, wallPos, wallHeight);
        }
    }

    // Prints the calculated shot's time, and height when it reaches the wall
    static void printShotInfo(double secondsTime, double yPos) {
        System.out.println(" Shooting cannon -------");
        System.out.print("The ball will reach the wall at " + round(secondsTime) + " seconds");
        System.out.println(" and with a y position of " + round(yPos) + "m");
    }

    // Prints the result of shooting the cannon
    static void printResult(double yPos, double yMax, double wallHeight) {
        if (yPos < 0) {
            System.out.println("The ball did not reach the wall.");
        } else if (yPos < wallHeight) {
            System.out.println("The ball did not go over the wall!");
        } else {
            System.out.println("The ball went over the wall!");
            // if the ball went outside the Earth's atmosphere (yMax<100km)
            if (yMax > MAX_Y_THRESHOLD) {
                System.out.println("The ball went over the max threshold!");
            } else {
                System.out.println("The ball stayed under the max threshold.");
            }
        }
        System.out.println("");
    }

    // gets user input for the cannon's angle in degrees
    static double userAngleDegrees(Scanner scnr) {
        System.out.print("Enter the cannon's angle in degrees: ");
        double angleDegrees = scnr.nextDouble();
        return angleDegrees;
    }

    // gets user input for the cannon's velocity in m/s
    static double userVelocity(Scanner scnr) {
        System.out.print("Enter the cannon's velocity in m/s: ");
        double velocity = scnr.nextDouble();
        return velocity;
    }

    // is true when an angle is outside the range of 0 to 90 degrees
    static boolean isInvalidAngle(double angleDegrees) {
        return (angleDegrees >= 90) || (angleDegrees <= 0);
    }

    // Gets the time in seconds at the specified x position
    static double getTimeAtXPos(double velocity, double angleRadians, double xPos) {
        double secondsTime = (xPos) / (Math.cos(angleRadians) * velocity);
        return secondsTime;
    }

    // The y position of the ball at a specified point in time
    static double getYPos(double velocity, double angleRadians, double secondsTime) {
        double temp = (0.5 * GRAVITY * Math.pow(secondsTime, 2));
        double yPos = velocity * Math.sin(angleRadians) * secondsTime;

        yPos -= temp;
        return yPos;
    }

    // Gets the highest point that the ball will reach
    static double getYMax(double velocity, double angleRadians) {
        double yMax = (velocity * Math.sin(angleRadians)) / (2 * GRAVITY);
        return yMax;
    }

    // Gets a random number between min and max
    static double getRandomNum(int min, int max) {
        double randomNum = (Math.random() * (max - min)) + min;
        // returns the random number rounded
        return round(randomNum);
    }

    // Rounds double and returns it with 2 decimal points
    static double round(double num) {
        return Math.round(num * 100.0) / 100.0;
    }
}
