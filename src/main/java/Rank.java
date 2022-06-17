public enum Rank {
    PURSER("Purser"),
    FLIGHT_ATTENDANT("Flight attendant"),
    FIRST_OFFICER("First Officer"),
    CAPTAIN("Captain");

    private final String rankName;

    Rank(String rankName) {
        this.rankName = rankName;
    }
}
