import java.util.ArrayList;

public class FlightManager extends Person {

    public FlightManager(String name) {
        super(name);
    }

    public int calculateReservedBaggageWeightPerPassenger(Flight flight) {
        int totalWeightForBaggage = flight.getPlane().getType().getWeight() / 2;
        int totalCapacity = flight.getPlane().getType().getCapacity();
        return totalWeightForBaggage / totalCapacity;
    }

    public int calculatedBookedWeight(Flight flight) {
        ArrayList<Passenger> passengers = flight.getPassengers();
        int totalWeight = 0;
        //        NOTE: We are assuming that all the bags weight the same, i.e., 20

        for (Passenger passenger : passengers) {
            totalWeight += passenger.getNumberOfBags() * 20;
        }

        return totalWeight;
    }
}
