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
        return "Ticket, \n Passenger: " + this.passenger.toString() + "\n. Flight: " + this.flight.toString()
                + "\n Price: "
                + this.price;
    }
}
