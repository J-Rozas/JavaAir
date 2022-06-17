import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    private Flight flight;
    private Pilot pilot;
    private CabinCrewMember purser;
    private CabinCrewMember flightAttendant;
    private ArrayList<CabinCrewMember> cabinCrewMembers;
    private ArrayList<Passenger> passengers;
    private Passenger passenger;
    private Plane plane;

    @Before
    public void before() {
        pilot = new Pilot("John", Rank.FIRST_OFFICER, "1871nvsu3");
        purser = new CabinCrewMember("Joe", Rank.PURSER);
        passenger = new Passenger("Jane", 3);
        passengers = new ArrayList<>();
        flightAttendant = new CabinCrewMember("Jay", Rank.FLIGHT_ATTENDANT);
        cabinCrewMembers = new ArrayList<>();
        cabinCrewMembers.add(purser);
        cabinCrewMembers.add(flightAttendant);
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(pilot, cabinCrewMembers, plane, "FR756", "GLA", "EDI", "1st June");
    }

    @Test
    public void hasPilot() {
        assertEquals(pilot, flight.getPilot());
    }

    @Test
    public void hasCabinCrewMembers() {
        assertEquals(Arrays.asList(purser, flightAttendant), flight.getCabinCrewMembers());
    }

    @Test
    public void hasEmptyArrayListOfPassengers() {
        assertEquals(new ArrayList<>(), flight.getPassengers());
    }

    @Test
    public void hasPlane() {
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("FR756", flight.getFlightNumber());
    }

    @Test
    public void hasDestination() {
        assertEquals("GLA", flight.getDestination());
    }

    @Test
    public void hasDeparture() {
        assertEquals("EDI", flight.getDeparture());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals("1st June", flight.getDepartureTime());
    }
}
