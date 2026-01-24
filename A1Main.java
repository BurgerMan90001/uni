public class A1main {
    public static void main(String[] args) {
        Passenger paul = Passenger.createPassenger("Paul", "Canada", 2006);
        String[] codes = { "AIR1", "AIR2", "AIR3" };
        String[] cities = { "City1", "City2", "City3" };
        String[] countries = { "Country1", "Country2", "Country3" };
        int[] fees = { 100, 100, 100 };

        Airport[] airports = Airport.createAirports(codes, cities, countries, fees);
        // Airport arrive = Airport.createAirports("LPELAPW", "LPOEF", "Cwwwwe", 100);
        // Flight flight = Flight.createFlight("CP12", depart, arrive);
        // Ticket ticket = new Ticket(, paul, 0)

        System.out.println(paul.toString());
        System.out.println(paul.isMinor(2025));

        // System.out.println(flight.toString());
    }
}
