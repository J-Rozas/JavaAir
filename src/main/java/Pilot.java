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
}
