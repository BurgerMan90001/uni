public class Passenger {
    private String name;
    private String citizenCountry;
    private int yearOfBirth;

    private Passenger(String name, String citizenCountry, int year) {
        this.name = name;
        this.citizenCountry = citizenCountry;
        this.yearOfBirth = year;
    }

    public boolean isMinor(int currentYear) {
        boolean isMinor = true;
        int age = currentYear - this.yearOfBirth;
        isMinor = (age < 18) ? true : false;
        return isMinor;
    }

    public boolean matchesName(String name) {
        return this.name.equals(name);
    }

    public static Passenger createPassenger(String name, String citizenCountry, int year) {
        return new Passenger(name, citizenCountry, year);
    }

    public static Passenger findPassenger(String name, Passenger[] passengers, int size) {
        Passenger passenger = null;
        for (int i = 0; i < size; i++) {
            if (passengers[i].matchesName(name)) {
                passenger = passengers[i];
            }
        }
        return passenger;
    }

    public static int addPassenger(Passenger passenger, Passenger[] passengers, int size) {

    }

    public static void printPassengerNames(Passenger[] passengers, int size) {

    }

    public String toString() {
        return "";
    }
}
