public class Flight {
    private String code;
    private Airport depart;
    private Airport arrive;

    public Flight(String code, Airport depart, Airport arrive) {
        this.code = code;
        this.depart = depart;
        this.arrive = arrive;
    }

    public boolean isInternational() {
        return !this.depart.matchesCountry(this.arrive.getCountry());
    }

    public String getCode() {
        return this.code;
    }

    public String toString() {
        return "Flight, Code: " + this.code + "\n. Depart: " + this.depart.toString() + "\n. Arrive: "
                + this.arrive.toString();

    }
}
