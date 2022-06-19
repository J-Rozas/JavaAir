import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Flight {

    private final Pilot pilot;
    private final ArrayList<CabinCrewMember> cabinCrewMembers;
    private final ArrayList<Passenger> passengers;
    private final Plane plane;
    private final String flightNumber;
    private final String destination;
    private final String departure;
    private final LocalDate departureTime;
    private final ArrayList<Integer> emptySeats;

    public Flight(Pilot pilot, ArrayList<CabinCrewMember> cabinCrewMembers, Plane plane, String flightNumber, String destination, String departure, LocalDate departureTime) {
        this.pilot = pilot;
        this.cabinCrewMembers = cabinCrewMembers;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departure = departure;
        this.departureTime = departureTime;
        this.emptySeats = new ArrayList<Integer>() {
            {
                for (int i = 1, n = plane.getType().getCapacity(); i <= n; i ++) {
                    add(i);
                }
            }
        };
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

    public LocalDate getDepartureTime() {
        return this.departureTime;
    }


    public int getAvailableSeats() {
        return this.plane.getType().getCapacity() - getPassengers().size();
    }

    public void bookPassenger(Passenger passenger) {
        if (getAvailableSeats() > 0) {
            passenger.setFlightStatus(true);
            int randomSeatIndex = getRandomSeat();
            int randomSeatNumber = getListEmptySeats().get(randomSeatIndex);
            this.emptySeats.remove(randomSeatIndex);
            passenger.setSeatNumber(randomSeatNumber);
            this.passengers.add(passenger);
        }
    }

    public int getNumberOfEmptySeats() {
        return this.emptySeats.size();
    }

    public ArrayList<Integer> getListEmptySeats() {
        return this.emptySeats;
    }

//    Returns a random index
    public int getRandomSeat() {
        return new Random().nextInt(getNumberOfEmptySeats());
    }
}
