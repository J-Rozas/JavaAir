public class Pilot extends Person {

    private final String rank;
    private final String licenseNumber;

    public Pilot(String name, String rank, String licenseNumber) {
        super(name);
        this.rank = rank;
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public String getRank() {
        return this.rank;
    }
}
