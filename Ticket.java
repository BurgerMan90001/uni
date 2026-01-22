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
        return "";
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return this.passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
