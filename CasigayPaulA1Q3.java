import java.io.IOException;
import java.util.Scanner;

public class CasigayPaulA1Q3 {
    // thow IOException for user input errors
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);

        // Unit conversion constants for seconds
        final int SECONDS_PER_DAY = 86400;
        final int SECONDS_PER_HOUR = 3600;
        final int SECONDS_PER_MINUTE = 60;

        final int MINUTES_PER_HOUR = 60;
        final int HOURS_PER_DAY = 24;

        String orgin;
        String destination;

        String currentTime;

        /*
         * 2314 kilometres
         * The distance between the orgin and destination converted to metres
         * https://www.distance-cities.com
         */
        int distanceBetween;

        // Get user input
        System.out.print("Orgin: ");
        orgin = scnr.nextLine();
        System.out.print("Destination: ");
        destination = scnr.nextLine();
        System.out.print("Distance between in metres: ");
        distanceBetween = scnr.nextInt();
        System.out.print("What is the current time in 24-hour time (hh:mm): ");
        currentTime = scnr.next();

        // Get the hour and minute from the currentTime string
        int currentHour = Integer.parseInt(currentTime.substring(0, 2));
        int currentMinute = Integer.parseInt(currentTime.substring(3, 5));

        /*
         * Cycling speed for the Age range: 20-25
         * https://pedalstreet.com/average-cycling-speed-by-age/
         */
        double cyclingSpeed = 8.31;
        /*
         * Average speed of Boeing 737
         * 975 km/h converted to metres per second
         * https://aviex.goflexair.com/flight-school-training-faq/commercial-plane-
         * speeds
         */
        double planeSpeed = 270.0;

        // A car's average speed of 50km/hr in metres per second
        double drivingSpeed = 13.89;
        // 1 metre per second
        double walkingSpeed = 1.0;

        // Total time for walking in seconds
        int walkingTime = (int) (distanceBetween / walkingSpeed);

        // Convert seconds to days, then get the remainder convert
        int walkingDays = walkingTime / SECONDS_PER_DAY;
        int walkingHours = walkingTime % SECONDS_PER_DAY / SECONDS_PER_HOUR;
        int walkingMinutes = walkingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR / SECONDS_PER_MINUTE;
        int walkingSeconds = walkingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR % SECONDS_PER_MINUTE;

        /*
         * Calculate the arrival time for walking.
         * Modulus divide results so that time is in 24-hour format.
         */
        int walkingArrivalHour = (currentHour + walkingHours) % HOURS_PER_DAY;
        int walkingArrivalMinute = (currentMinute + walkingMinutes) % MINUTES_PER_HOUR;

        // Print the result for walking
        System.out.print("To go from " + orgin + " to " + destination + ", ");
        System.out.print("walking takes ");
        System.out.print(walkingDays + " days, ");
        System.out.print(walkingHours + " hours, ");
        System.out.print(walkingMinutes + " minutes, ");
        System.out.print("and " + walkingSeconds + " seconds. ");
        System.out.print("Arrival at " + walkingArrivalHour + ":" + walkingArrivalMinute);
        System.out.println(" +" + walkingDays + " days.");

        // Total time for driving in seconds
        int drivingTime = (int) (distanceBetween / drivingSpeed);

        int drivingDays = drivingTime / SECONDS_PER_DAY;
        int drivingHours = drivingTime % SECONDS_PER_DAY / SECONDS_PER_HOUR;
        int drivingMinutes = drivingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR / SECONDS_PER_MINUTE;
        int drivingSeconds = drivingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR % SECONDS_PER_MINUTE;

        // Calculate the arrival time for driving
        int drivingArrivalHour = (currentHour + drivingHours) % HOURS_PER_DAY;
        int drivingArrivalMinute = (currentMinute + drivingMinutes) % MINUTES_PER_HOUR;

        // Print the result for driving
        System.out.print("To go from " + orgin + " to " + destination + ", ");
        System.out.print("driving takes ");
        System.out.print(drivingDays + " days, ");
        System.out.print(drivingHours + " hours, ");
        System.out.print(drivingMinutes + " minutes, ");
        System.out.print("and " + drivingSeconds + " seconds. ");
        System.out.print("Arrival at " + drivingArrivalHour + ":" + drivingArrivalMinute);
        System.out.println(" +" + drivingDays + " days.");

        // Total time for cycling in seconds
        int cyclingTime = (int) (distanceBetween / cyclingSpeed);

        int cyclingDays = cyclingTime / SECONDS_PER_DAY;
        int cyclingHours = cyclingTime % SECONDS_PER_DAY / SECONDS_PER_HOUR;
        int cyclingMinutes = cyclingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR / SECONDS_PER_MINUTE;
        int cyclingSeconds = cyclingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR % SECONDS_PER_MINUTE;

        // Calculate the arrival time for cycling
        int cyclingArrivalHour = (currentHour + cyclingHours) % HOURS_PER_DAY;
        int cyclingArrivalMinute = (currentMinute + cyclingMinutes) % MINUTES_PER_HOUR;

        // Print the result for cycling
        System.out.print("To go from " + orgin + " to " + destination + ", ");
        System.out.print("cycling takes ");
        System.out.print(cyclingDays + " days, ");
        System.out.print(cyclingHours + " hours, ");
        System.out.print(cyclingMinutes + " minutes, ");
        System.out.print("and " + cyclingSeconds + " seconds. ");
        System.out.print("Arrival at " + cyclingArrivalHour + ":" + cyclingArrivalMinute);
        System.out.println(" +" + cyclingDays + " days.");

        // Total time for flying in seconds
        int planeTime = (int) (distanceBetween / planeSpeed);

        int planeDays = planeTime / SECONDS_PER_DAY;
        int planeHours = planeTime % SECONDS_PER_DAY / SECONDS_PER_HOUR;
        int planeMinutes = planeTime % SECONDS_PER_DAY % SECONDS_PER_HOUR / SECONDS_PER_MINUTE;
        int planeSeconds = planeTime % SECONDS_PER_DAY % SECONDS_PER_HOUR % SECONDS_PER_MINUTE;

        // Calculate the arrival time for flying
        int planeArrivalHour = (currentHour + planeHours) % HOURS_PER_DAY;
        int planeArrivalMinute = (currentMinute + planeMinutes) % MINUTES_PER_HOUR;

        // Print the result for flying
        System.out.print("To go from " + orgin + " to " + destination + ", ");
        System.out.print("flying takes ");
        System.out.print(planeDays + " days, ");
        System.out.print(planeHours + " hours, ");
        System.out.print(planeMinutes + " minutes, ");
        System.out.print("and " + planeSeconds + " seconds. ");
        System.out.print("Arrival at " + planeArrivalHour + ":" + planeArrivalMinute);
        System.out.println(" +" + planeDays + " days.");

        /*
         * I tested my code by making orgin and destination w because they are not
         * important.
         * 
         * String orgin = w;
         * String destination = w;
         * String currentTime = 24:00; to test for the 24-hour formating of arrival times
         * int distanceBetween = 1000000; make distance long enough to see days and hours work.
         */
    }
}
