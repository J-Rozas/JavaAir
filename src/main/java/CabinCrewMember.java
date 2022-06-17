public class CabinCrewMember extends Person {

    private final Rank rank;

    public CabinCrewMember(String name, Rank rank) {
        super(name);
        this.rank = rank;
    }

    public Rank getRank() {
        return this.rank;
    }
}
