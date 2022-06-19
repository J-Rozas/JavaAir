public enum PlaneType {
    BOEING747(300, 10000000),
    SMALL(10, 10000);

    private final int capacity;
    private final int weight;

    PlaneType(int capacity, int weight) {
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getWeight() {
        return this.weight;
    }
}
