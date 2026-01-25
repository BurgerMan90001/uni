
public class A1Main {
    public static void main(String[] args) {
        Airport[] airports = createAirports(new String[] { "YYZ", "JFK", "LAX" },
                new String[] { "Toronto", "New York", "Los Angeles" },
                new String[] { "Canada", "USA", "USA" }, new int[] { 30, 50, 70 });
        Flight[] flights = createFlights(new String[] { "AC101", "DL202", "UA303" },
                new String[] { "YYZ", "JFK", "LAX" },
                new String[] { "JFK", "LAX", "YYZ" }, airports);
        Passenger[] passengers = new Passenger[3];
        int passengerCount = 0;
        Passenger p1 = createPassenger("Alice", "Canada", 2008);
        passengerCount = addPassenger(p1, passengers, passengerCount);
        Passenger p2 = createPassenger("Bob", "USA", 2005);
        passengerCount = addPassenger(p2, passengers, passengerCount);
        Passenger p3 = createPassenger("Bob", "USA", 2005);
        passengerCount = addPassenger(p3, passengers, passengerCount);
        passengerCount = addPassenger(p3, passengers, passengerCount);
        printPassengerNames(passengers, passengerCount);
        printArray(flights, flights.length);

    }

    static void printArray(Flight[] arr, int filledIndex) {
        System.out.print("[");
        for (int i = 0; i < filledIndex; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.print("]\n");
    }

    /* Airport methods */
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
        Airport airport = null;
        for (int i = 0; i < airports.length; i++) {
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

    /* Flight methods */
    public static Flight createFlight(String code, Airport depart, Airport arrive) {
        return new Flight(code, depart, arrive);
    }

    public static Flight[] createFlights(String[] code, String[] departCode, String[] arriveCode, Airport[] airports) {
        Flight[] flights = new Flight[code.length];

        for (int i = 0; i < airports.length; i++) {
            Airport depart = findAirportCode(departCode[i], airports);
            Airport arrive = findAirportCode(arriveCode[i], airports);
            if (depart == null || arrive == null) {
                return null;
            } else {
                flights[i] = createFlight(code[i], depart, arrive);
            }

        }
        return flights;
    }

    public static Flight findFlightCode(String code, Flight[] flights) {
        Flight flight = null;

        for (int i = 0; i < flights.length; i++) {
            if (flights[i] == null) {
                continue;
            }
            if (code.equals(flights[i].getCode())) {
                flight = flights[i];
            }
        }
        return flight;
    }

    /* Passenger methods */

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
        if (size < passengers.length) {
            passengers[size] = passenger;
            size++;
        }
        return size;
    }

    public static void printPassengerNames(Passenger[] passengers, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(passengers[i].getName());
        }
    }
}
