public class Airport {
    private String airportCode;
    private String city;
    private String country;
    private double fee;

    public void setFee(int newFee) {
    }

    public boolean matchesCode(String code) {
        boolean matchesCode = true;
        return matchesCode;
    }

    public boolean matchesCountry(String country) {
        boolean matchesCountry = true;
        return matchesCountry;
    }

    public boolean matchesCity(String city) {
        boolean matchesCity = true;
        return matchesCity;
    }

    public static Airport createAirport(String code, String city, String country, int fee) {

    }

    public static Airport[] createAirports(String[] code, String[] city, String[] country, int[] fee) {

    }

    public static Airport findAirportCode(String code, Airport[] airports) {

    }

    public static Airport findAirportCity(String city, Airport[] airports) {

    }

    public String toString() {
        return "";
    }
}
