package A3;

import java.util.Scanner;
/*
* COMP 1010 SECTION A02
* INSTRUCTOR: Emanuel Wiens 
* STUDENT NAME: Paul Casigay
* STUDENT NUMBER: 8061457
* ASSIGNMENT: 3
* QUESTION: 3
*
* PURPOSE: A game where you take 3 blind shots at a target and score.
*/

public class CasigayPaulA3Q3 {
    // The size of the grid
    static final int GRID_WIDTH = 25;
    static final int GRID_HEIGHT = 30;
    // Target ring diameters
    static final int OUTER_DIAMETER = 8;
    static final int MIDDLE_DIAMETER = 5;
    static final int INNER_DIAMETER = 2;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Generate random coordinates for target within the grid
        int targetX = getRandomNum(0, GRID_WIDTH);
        int targetY = getRandomNum(0, GRID_HEIGHT);

        int score1 = luckyShot(targetX, targetY, scnr);
        int score2 = luckyShot(targetX, targetY, scnr);
        int score3 = luckyShot(targetX, targetY, scnr);

        int scoreTotal = score1 + score2 + score3;

        System.out.println("Target coordinates: (" + targetX + ", " + targetY + ")");
        System.out.println(" > Score total: " + scoreTotal);

        testSuite();

        scnr.close();
    }

    static void testSuite() {
        System.out.println("____TEST SUITE____");
        int targetX = 10;
        int targetY = 10;

        // Out of bounds
        printExpected("Went outside of the game grid");
        testShot(10000, 10000, targetX, targetY);
        // Outer ring
        printExpected("Hit outer ring");
        testShot(15, 15, targetX, targetY);
        // Middle ring
        printExpected("Hit middle ring");
        testShot(12, 12, targetX, targetY);
        // Inner ring
        printExpected("Hit inner ring");
        testShot(10, 10, targetX, targetY);
    }

    // Testing method
    static void testShot(int shotX, int shotY, int targetX, int targetY) {
        System.out.print("Shot at (" + shotX + ", " + shotY + "): ");
        luckyShot(shotX, shotY, targetX, targetY);
    }

    static void printExpected(String expected) {
        System.out.println(" > Expected: " + expected);
    }

    static int luckyShot(int shotX, int shotY, int targetX, int targetY) {
        double distance = getDistance(targetX, targetY, shotX, shotY);
        int score = getScore(shotX, shotY, distance);

        return score;
    }

    // Helper method to get user input for x and y coordinates
    static int luckyShot(int targetX, int targetY, Scanner scnr) {
        // Get x and y components of coordinates
        int shotX = userXCoord(scnr);
        int shotY = userYCoord(scnr);

        int score = luckyShot(shotX, shotY, targetX, targetY);
        return score;
    }

    // Gets a score based on how far the shot is from the target
    static int getScore(int shotX, int shotY, double distance) {
        int score = 0;
        // If outside of the game grid
        if (!isWithinBounds(shotX, shotY)) {
            System.out.println("Went outside of the game grid -1");
            score = -1;
        }
        // If outside the target
        else if (distance > OUTER_DIAMETER) {
            System.out.println("Missed the target +0");
        }
        // In outer ring
        else if (distance > MIDDLE_DIAMETER) {
            System.out.println("Outer ring hit! +1");
            score = 1;
        }
        // In middle ring
        else if (distance > INNER_DIAMETER) {
            System.out.println("Middle ring hit! +3");
            score = 3;
        }
        // Within inner circle
        else if (distance <= INNER_DIAMETER) {
            System.out.println("Inner ring hit!! +5");
            score = 5;
        }
        return score;
    }

    // Returns true if shot coordinates are between 0 and the grid width and height
    static boolean isWithinBounds(int shotX, int shotY) {
        // 0 to GRID_WIDTH is valid
        boolean isValidXCoord = (shotX >= 0) && (shotX <= GRID_WIDTH);
        // 0 to GRID_HEIGHT is valid
        boolean isValidYCoord = (shotY >= 0) && (shotY <= GRID_HEIGHT);

        boolean isWithinBounds = isValidXCoord && isValidYCoord;
        return isWithinBounds;
    }

    // Calculates the distance between target and shot coordinates
    static double getDistance(int targetX, int targetY, int shotX, int shotY) {
        double x = Math.pow(shotX - targetX, 2);
        double y = Math.pow(shotY - targetY, 2);

        double distance = Math.sqrt(x + y);
        return distance;
    }

    // Gets user input for shot x coordinate
    static int userXCoord(Scanner scnr) {
        System.out.print("Enter shot x coordinate: ");
        int shotX = scnr.nextInt();
        return shotX;
    }

    // Gets user input for shot y coordinate
    static int userYCoord(Scanner scnr) {
        System.out.print("Enter shot y coordinate: ");
        int shotY = scnr.nextInt();
        return shotY;
    }

    // Gets a random number between min and max
    static int getRandomNum(int min, int max) {
        int randomNum = (int) (Math.random() * (max - min)) + min;
        return randomNum;
    }
}
