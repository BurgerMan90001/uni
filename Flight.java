public class Flight {
    private String code;
    private Airport depart;
    private Airport arrive;

    private Flight(String code, Airport depart, Airport arrive) {
        this.code = code;
        this.depart = depart;
        this.arrive = arrive;
    }

    public boolean isInternational() {
        return !this.depart.matchesCountry(this.arrive.getCountry());
    }

    public static Flight createFlight(String code, Airport depart, Airport arrive) {
        return new Flight(code, depart, arrive);
    }

    public static Flight[] createFlights(String[] code, String[] departCode, String[] arriveCode, Airport[] airports) {
        Flight[] flights = new Flight[code.length];

        for (int i = 0; i < airports.length; i++) {
            Airport depart = Airport.findAirportCode(departCode[i], airports);
            Airport arrive = Airport.findAirportCode(arriveCode[i], airports);
            flights[i] = Flight.createFlight(code[i], depart, arrive);
        }
        return null;
    }

    public static Flight findFlightCode(String code, Flight[] flights) {
        Flight flight = null;
        for (int i = 0; i < flights.length; i++) {
            if (code.equals(flights[i].code)) {
                flight = flights[i];
            }
        }
        return flight;
    }

    public String toString() {
        return "Flight, Code: " + this.code + "\n. Depart: " + this.depart.toString() + "\n. Arrive: "
                + this.arrive.toString();

    }
}
