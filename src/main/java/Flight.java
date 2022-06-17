import java.util.ArrayList;

public class Flight {

    private final Pilot pilot;
    private final ArrayList<CabinCrewMember> cabinCrewMembers;
    private final ArrayList<Passenger> passengers;
    private final Plane plane;
    private final String flightNumber;
    private final String destination;
    private final String departure;
    private final String departureTime;

    public Flight(Pilot pilot, ArrayList<CabinCrewMember> cabinCrewMembers, Plane plane, String flightNumber, String destination, String departure, String departureTime) {
        this.pilot = pilot;
        this.cabinCrewMembers = cabinCrewMembers;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departure = departure;
        this.departureTime = departureTime;
    }

    public Pilot getPilot() {
        return this.pilot;
    }

    public ArrayList<CabinCrewMember> getCabinCrewMembers() {
        return this.cabinCrewMembers;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDeparture() {
        return this.departure;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }


    public int getAvailableSeats() {
        return this.plane.getType().getCapacity() - getPassengers().size();
    }

    public void bookPassenger(Passenger passenger) {
        if (getAvailableSeats() > 0) {
            this.passengers.add(passenger);
        }
    }
}
