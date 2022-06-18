public class FlightManager extends Person {

    public FlightManager(String name) {
        super(name);
    }

    public int calculateReservedBaggageWeightPerPassenger(Flight flight) {
        int totalWeightForBaggage = flight.getPlane().getType().getWeight() / 2;
        int totalCapacity = flight.getPlane().getType().getCapacity();
        return totalWeightForBaggage / totalCapacity;
    }
}
