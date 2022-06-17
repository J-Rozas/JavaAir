public class Pilot extends Person {

    private final CabinCrewMember rank;
    private final String licenseNumber;

    public Pilot(String name, CabinCrewMember rank, String licenseNumber) {
        super(name);
        this.rank = rank;
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public CabinCrewMember getRank() {
        return this.rank;
    }
}
