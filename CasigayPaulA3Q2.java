import java.util.Scanner;

/*
* COMP 1010 SECTION A02
* INSTRUCTOR: Emanuel Wiens 
* STUDENT NAME: Paul Casigay
* STUDENT NUMBER: 8061457
* ASSIGNMENT: 3
* QUESTION: 2
*
* PURPOSE: Calculates the trajectory of a cannon based on user input on different planets. 
*/

public class CasigayPaulA3Q2 {

    // Atmospheric heights for planets
    static final int EARTH_MAX_Y = 100000;
    static final int MOON_MAX_Y = 100000;
    static final int MARS_MAX_Y = 100000;
    // Planet constants (metres for radius and kg for mass)
    static final double MOON_MASS = 7.348e22;
    static final double MOON_RADIUS = 1.738e6;

    static final double EARTH_MASS = 5.972e24;
    static final double EARTH_RADIUS = 6.371e6;

    static final double MARS_MASS = 6.417e23;
    static final double MARS_RADIUS = 3.390e6;

    // Gravitational constant of the universe
    static final double GRAV_CONST = 6.6743e-11;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        double wallHeight = getRandomNum(10, 100);
        double wallPos = getRandomNum(25, 125);

        System.out.print(" > The wall has a height of " + wallHeight + "m and is ");
        System.out.println(wallPos + "m away.");

        String planet = userPlanet(scnr);
        double gravity = getGravity(planet);
        double yThreshold = getYThreshold(planet);
        System.out.println("Gravity is at " + gravity + " with atmospheric height of " + yThreshold);

        // Give the user 3 tries
        shootCannon(scnr, wallPos, wallHeight, planet);
        shootCannon(scnr, wallPos, wallHeight, planet);
        shootCannon(scnr, wallPos, wallHeight, planet);

        // testSuite();

        scnr.close();
    }

    static void testSuite() {
        double wallHeight = 50.0;
        double wallPos = 50.0;

        final double RADIANS_45 = Math.toRadians(45);
        final String MARS = "Mars";
        // Test with mars gravity
        // double gravity = getGravity(MARS_MASS, MARS_RADIUS);

        // Goes over the max threshold
        shootCannon(Math.toRadians(89), 9000000, wallPos, wallHeight, MARS);

        // Goes over the wall
        shootCannon(Math.toRadians(60), 1000, wallPos, wallHeight, MARS);

        // Hits the wall
        shootCannon(RADIANS_45, 25, wallPos, wallHeight, MARS);

        // Does not reach the wall
        shootCannon(RADIANS_45, 5, wallPos, wallHeight, MARS);
    }

    // Returns a planet's gravity acceleration
    static double getGravity(String planet) {
        double planetMass;
        double planetRadius;
        switch (planet) {
            case "Mars":
                planetMass = MARS_MASS;
                planetRadius = MARS_RADIUS;
                break;
            case "Earth":
                planetMass = EARTH_MASS;
                planetRadius = EARTH_RADIUS;
                break;
            case "Moon":
                planetMass = MOON_MASS;
                planetRadius = MOON_RADIUS;
                break;
            default:
                System.out.println("Defaulting to earth gravity");
                planetMass = EARTH_MASS;
                planetRadius = EARTH_RADIUS;
                break;
        }
        double gravity = GRAV_CONST * (planetMass / Math.pow(planetRadius, 2));

        return round(gravity);
    }

    static void shootCannon(double angleRadians, double velocity, double wallPos, double wallHeight,
            String planet) {
        double gravity = getGravity(planet);
        double yThreshold = getYThreshold(planet);
        // Calculate the shot's time and y position when it reaches the wall
        double secondsTime = getTimeAtXPos(velocity, angleRadians, wallPos);
        double yPos = getYPos(velocity, angleRadians, secondsTime, gravity);
        double yMax = getYMax(velocity, angleRadians, gravity);

        printShotInfo(secondsTime, yPos);

        printResult(yPos, yMax, wallHeight, yThreshold);
    }

    // helper method to get user input for angle and velocity
    static void shootCannon(Scanner scnr, double wallPos, double wallHeight, String planet) {
        double angleDegrees = userAngleDegrees(scnr);

        // check if angle is valid before calculating
        if (isInvalidAngle(angleDegrees)) {
            System.out.println("Invalid angle, -1 turn.");
        } else {
            double angleRadians = Math.toRadians(angleDegrees);
            double velocity = userVelocity(scnr);

            shootCannon(angleRadians, velocity, wallPos, wallHeight, planet);
        }
    }

    // Prints the calculated shot's time, and height when it reaches the wall
    static void printShotInfo(double secondsTime, double yPos) {
        System.out.println(" Shooting cannon -------");
        System.out.print("The ball reaches the wall at " + round(secondsTime) + " seconds");
        System.out.println(" and with a y position of " + round(yPos) + "m");
    }

    // Prints the result of shooting the cannon
    static void printResult(double yPos, double yMax, double wallHeight, double yThreshold) {
        if (yPos < 0) {
            System.out.println("The ball did not reach the wall.");
        } else if (yPos < wallHeight) {
            System.out.println("The ball did not go over the wall!");
        } else {
            System.out.println("The ball went over the wall!");
            // if the ball went outside the Earth's atmosphere (yMax<100km)
            if (yMax > yThreshold) {
                System.out.println("The ball went over the max threshold!");
            } else {
                System.out.println("The ball stayed under the max threshold.");
            }
        }
        System.out.println("");
    }

    // Get user input for planet and return the acceleration due to gravity.
    static String userPlanet(Scanner scnr) {
        System.out.print("Choose a planet to be on (Earth, Moon, Mars): ");
        String planet = scnr.next();

        return planet;
    }

    static double getYThreshold(String planet) {
        double yThreshold = 0;
        switch (planet) {
            case "Mars":

                break;
            case "Earth":
                break;
            case "Moon":

                break;
            default:

                break;
        }
        return yThreshold;
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
        return (angleDegrees > 90) || (angleDegrees < 0);
    }

    // the x position of the ball at a specified point in time
    static double getXPos(double velocity, double angleRadians, double secondsTime) {
        double xPos = velocity * Math.cos(angleRadians) * secondsTime;
        return xPos;
    }

    // Gets the time in seconds at the specified x position
    static double getTimeAtXPos(double velocity, double angleRadians, double xPos) {
        double secondsTime = (xPos) / (Math.cos(angleRadians) * velocity);
        return secondsTime;
    }

    // The y position of the ball at a specified point in time
    static double getYPos(double velocity, double angleRadians, double secondsTime, double gravity) {
        double temp = (0.5 * gravity * Math.pow(secondsTime, 2));
        double yPos = velocity * Math.sin(angleRadians) * secondsTime;

        yPos -= temp;
        return yPos;
    }

    // Gets the highest point that the ball will reach
    static double getYMax(double velocity, double angleRadians, double gravity) {
        double yMax = (velocity * Math.sin(angleRadians)) / (2 * gravity);
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