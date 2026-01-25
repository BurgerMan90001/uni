public class Airport {
    private String code;
    private String city;
    private String country;
    private double fee;

    public Airport(String code, String city, String country, int fee) {
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

    public String getCountry() {
        return this.country;
    }

    public String toString() {
        return "Airport, \n Code: " + this.code + "\n City: " + this.city + "\n Country: " + this.country
                + "\n Fee: "
                + this.fee;
    }
}
