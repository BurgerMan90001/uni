public class Ticket {
    private Flight flight;
    private Passenger passenger;
    private double price;

    public Ticket(Flight flight, Passenger passenger, double price) {
        this.flight = flight;
        this.passenger = passenger;
        this.price = price;
    }

    public String toString() {
        return "Ticket Passenger: " + this.passenger.toString() + "\t. Flight: " + this.flight.toString() + "\t Price: "
                + this.price;
    }
}
