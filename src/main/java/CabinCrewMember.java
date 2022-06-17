public enum CabinCrewMember {
    PURSER("Purser"),
    FLIGHT_ATTENDANT("Flight attendant");

    private final String rankName;

    CabinCrewMember(String rankName) {
        this.rankName = rankName;
    }
}
