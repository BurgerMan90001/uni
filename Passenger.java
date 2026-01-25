public class Passenger {
    private String name;
    private String citizenCountry;
    private int year;

    public Passenger(String name, String citizenCountry, int year) {
        this.name = name;
        this.citizenCountry = citizenCountry;
        this.year = year;
    }

    public boolean isMinor(int currentYear) {
        int age = currentYear - this.year;
        boolean isMinor = (age < 18) ? true : false;
        return isMinor;
    }

    public boolean matchesName(String name) {
        return this.name.equalsIgnoreCase(name);
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "Passenger,\n Name: " + this.name + "\n Country: " + this.citizenCountry + "\n Year of Birth: "
                + this.year;
    }
}