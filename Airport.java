public class Airport {
    private String code;
    private String city;
    private String country;
    private double fee;

    private Airport(String code, String city, String country, int fee) {
        this.code = code;
        this.city = city;
        this.country = country;
        this.fee = fee;
    }

    public void setFee(int newFee) {
        if (newFee > this.fee) {
            this.fee = newFee;
        }
    }

    public boolean matchesCode(String code) {
        return this.code.equals(code);
    }

    public boolean matchesCountry(String country) {
        return this.country.equals(country);
    }

    public boolean matchesCity(String city) {
        return this.city.equals(city);
    }

    public static Airport createAirport(String code, String city, String country, int fee) {
        return new Airport(code, city, country, fee);
    }

    public static Airport[] createAirports(String[] code, String[] city, String[] country, int[] fee) {
        Airport[] airports = new Airport[code.length];
        for (int i = 0; i < code.length; i++) {
            airports[i] = new Airport(code[i], city[i], country[i], fee[i]);
        }
        return airports;
    }

    public static Airport findAirportCode(String code, Airport[] airports) {
        boolean found = false;
        Airport airport = null;
        for (int i = 0; i < airports.length && !found; i++) {
            if (airports[i].matchesCode(code)) {
                airport = airports[i];
            }
        }
        return airport;
    }

    public static Airport findAirportCity(String city, Airport[] airports) {
        boolean found = false;
        Airport airport = null;
        for (int i = 0; i < airports.length && !found; i++) {
            if (airports[i].matchesCity(city)) {
                airport = airports[i];
            }
        }
        return airport;
    }

    public String getCountry() {
        return this.country;
    }

    public String toString() {
        return "Airport, \n Code: " + this.code + "\n City: " + this.city + "\n Country: " + this.country
                + "\n Fee: "
                + this.fee;
    }
}
