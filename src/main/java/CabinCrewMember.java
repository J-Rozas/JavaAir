public enum CabinCrewMember {
    CAPTAIN("Captain"),
    FIRST_OFFICER("First Officer"),
    PURSER("Purser"),
    FLIGHT_ATTENDANT("Flight attendant");

    private final String rankName;

    CabinCrewMember(String rankName) {
        this.rankName = rankName;
    }

    public String getRankName() {
        return this.rankName;
    }
}
