public class CasigayPaulA1Q1 {
    public static void main(String[] args) {
        final String ORGIN = "Winnipeg";
        final String DESTINATION = "Vancouver";

        // Unit conversion constants for seconds
        final int SECONDS_PER_DAY = 86400;
        final int SECONDS_PER_HOUR = 3600;
        final int SECONDS_PER_MINUTE = 60;
        /*
         * The distance between the orgin and destination converted to metres
         * https://www.distance-cities.com
         */
        int distanceBetween = 2314240;

        /*
         * 2314 kilometres
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

        // Total time for modes of transportation in seconds
        int walkingTime = (int) (distanceBetween / walkingSpeed);

        int walkingDays = walkingTime / SECONDS_PER_DAY;
        int walkingHours = walkingTime % SECONDS_PER_DAY / SECONDS_PER_HOUR;
        int walkingMinutes = walkingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR / SECONDS_PER_MINUTE;
        int walkingSeconds = walkingTime % SECONDS_PER_DAY % SECONDS_PER_HOUR % SECONDS_PER_MINUTE;

        // Print the result for walking
        System.out.print("To go from " + ORGIN + " to " + DESTINATION + ", ");
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
        System.out.print("To go from " + ORGIN + " to " + DESTINATION + ", ");
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
        System.out.print("To go from " + ORGIN + " to " + DESTINATION + ", ");
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
        System.out.print("To go from " + ORGIN + " to " + DESTINATION + ", ");
        System.out.print("flying takes ");
        System.out.print(planeDays + " days, ");
        System.out.print(planeHours + " hours, ");
        System.out.print(planeMinutes + " minutes, ");
        System.out.println("and " + planeSeconds + " seconds.");

        /*
         * I first tested the travel time calculations with walking and printed the
         * results like this.
         * 
         * System.out.print(walkingDays);
         * System.out.print(walkingHours);
         * System.out.print(walkingMinutes);
         * 
         * Then, I compare them to calculations I did on paper.
         * 
         * Also tested by making distanceBetween bigger and smaller
         * int distanceBetween = 2314240000;
         * int distanceBetween = 23140;
         */
    }
}
