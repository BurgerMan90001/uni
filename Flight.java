public class Flight {
    private String code;
    private Airport depart;
    private Airport arive;

    private Flight(String code, Airport depart, Airport arrive) {
        this.code = code;
        this.depart = depart;
        this.arive = arrive;
    }

    public boolean isInternational() {
        boolean isInternational = true;
        return isInternational;
    }

    public static Flight createFlight(String code, Airport depart, Airport arrive) {
        return new Flight(code, depart, arrive);
    }

    public static Flight[] createFlights(String[] code, String[] departCode, String[] arriveCode, Airport[] airports) {
        for (int i = 0; i < airports.length; i++) {

        }
    }

    public static Flight findFlightCode(String code, Flight[] flights) {

    }

    public String toString() {
        return "";
    }
}
