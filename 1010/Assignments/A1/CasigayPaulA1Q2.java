package A1;

/*
* COMP 1010 SECTION A02
* INSTRUCTOR: Emanuel Wiens 
* STUDENT NAME: Paul Casigay
* STUDENT NUMBER: 8061457
* ASSIGNMENT: 1
* QUESTION: 2
*
* PURPOSE: Calculate and show the amount of time to travel between two locations in days, hours, minutes, and seconds.
* Takes input for orgin and destination.
*/
import java.util.Scanner;

public class CasigayPaulA1Q2 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Unit conversion constants for seconds
        final int SECONDS_PER_DAY = 86400;
        final int SECONDS_PER_HOUR = 3600;
        final int SECONDS_PER_MINUTE = 60;

        String orgin;
        String destination;

        // The distance between the orgin and destination in metres
        int distanceBetween;

        System.out.print("Orgin: ");
        orgin = scnr.nextLine();

        System.out.print("Destination: ");
        destination = scnr.nextLine();

        System.out.print("Distance between in metres: ");
        distanceBetween = scnr.nextInt();

        // an average cycling speed of 15km/hr
        // https://pedalstreet.com/average-cycling-speed-by-age/
        double cyclingSpeed = 4.31;
        /*
         * Average speed of Boeing 737
         * 975 km/h converted to metres per second
         * https://aviex.goflexair.com/flight-school-training-faq/commercial-plane-
         * speeds
         */
        double planeSpeed = 270.0;

        // A car's average speed of 32km/hr in metres per second
        double drivingSpeed = 8.89;
        // 1 metre per second
        double walkingSpeed = 1.0;

        // Total time for modes of transportation in seconds

        int walkingTime = (int) (distanceBetween / walkingSpeed);

        int walkingDays = walkingTime / SECONDS_PER_DAY;
        int walkingHours = walkingTime % SECONDS_PER_DAY / SECONDS_PER_HOUR;
        int walkingMinutes = walkingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR / SECONDS_PER_MINUTE;
        int walkingSeconds = walkingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR % SECONDS_PER_MINUTE;

        // Print the result for walking
        System.out.print("To go from " + orgin + " to " + destination + ", ");
        System.out.print("walking takes ");
        System.out.print(walkingDays + " days, ");
        System.out.print(walkingHours + " hours, ");
        System.out.print(walkingMinutes + " minutes, ");
        System.out.println("and " + walkingSeconds + " seconds.");

        int drivingTime = (int) (distanceBetween / drivingSpeed);

        int drivingDays = drivingTime / SECONDS_PER_DAY;
        int drivingHours = drivingTime % SECONDS_PER_DAY / SECONDS_PER_HOUR;
        int drivingMinutes = drivingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR / SECONDS_PER_MINUTE;
        int drivingSeconds = drivingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR % SECONDS_PER_MINUTE;

        // Print the result for driving
        System.out.print("To go from " + orgin + " to " + destination + ", ");
        System.out.print("driving takes ");
        System.out.print(drivingDays + " days, ");
        System.out.print(drivingHours + " hours, ");
        System.out.print(drivingMinutes + " minutes, ");
        System.out.println("and " + drivingSeconds + " seconds.");

        int cyclingTime = (int) (distanceBetween / cyclingSpeed);

        int cyclingDays = cyclingTime / SECONDS_PER_DAY;
        int cyclingHours = cyclingTime % SECONDS_PER_DAY / SECONDS_PER_HOUR;
        int cyclingMinutes = cyclingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR / SECONDS_PER_MINUTE;
        int cyclingSeconds = cyclingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR % SECONDS_PER_MINUTE;

        // Print the result for cycling
        System.out.print("To go from " + orgin + " to " + destination + ", ");
        System.out.print("cycling takes ");
        System.out.print(cyclingDays + " days, ");
        System.out.print(cyclingHours + " hours, ");
        System.out.print(cyclingMinutes + " minutes, ");
        System.out.println("and " + cyclingSeconds + " seconds.");

        int planeTime = (int) (distanceBetween / planeSpeed);

        int planeDays = planeTime / SECONDS_PER_DAY;
        int planeHours = planeTime % SECONDS_PER_DAY / SECONDS_PER_HOUR;
        int planeMinutes = planeTime % SECONDS_PER_DAY % SECONDS_PER_HOUR / SECONDS_PER_MINUTE;
        int planeSeconds = planeTime % SECONDS_PER_DAY % SECONDS_PER_HOUR % SECONDS_PER_MINUTE;

        // Print the result for flying
        System.out.print("To go from " + orgin + " to " + destination + ", ");
        System.out.print("flying takes ");
        System.out.print(planeDays + " days, ");
        System.out.print(planeHours + " hours, ");
        System.out.print(planeMinutes + " minutes, ");
        System.out.println("and " + planeSeconds + " seconds.");

        scnr.close();
    }
}
