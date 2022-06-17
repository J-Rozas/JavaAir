public class Pilot extends Person {

    private final Rank rank;
    private final String licenseNumber;

    public Pilot(String name, Rank rank, String licenseNumber) {
        super(name);
        this.rank = rank;
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public Rank getRank() {
        return this.rank;
    }

    public String fly(Flight flight) {
        if (flight != null) {
            return "I am " + getName() + " and we are about to take off";
        } else {
            return "No flight, so cannot fly";
        }
    }
}
