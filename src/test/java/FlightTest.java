import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FlightTest {
    private Flight flight;
    private Flight flight2;
    private Pilot pilot;
    private CabinCrewMember purser;
    private CabinCrewMember flightAttendant;
    private ArrayList<CabinCrewMember> cabinCrewMembers;
    private ArrayList<Passenger> passengers;
    private Passenger passenger;
    private Passenger passenger2;
    private Plane plane;
    private Plane plane2;
    private FlightManager flightManager;

    @Before
    public void before() {
        flightManager = new FlightManager("John");
        pilot = new Pilot("John", Rank.FIRST_OFFICER, "1871nvsu3");
        purser = new CabinCrewMember("Joe", Rank.PURSER);
        passenger = new Passenger("Jane", 3);
        passenger2 = new Passenger("Jay", 6);
        passengers = new ArrayList<>();
        flightAttendant = new CabinCrewMember("Jay", Rank.FLIGHT_ATTENDANT);
        cabinCrewMembers = new ArrayList<>();
        cabinCrewMembers.add(purser);
        cabinCrewMembers.add(flightAttendant);
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(
                pilot,
                cabinCrewMembers,
                plane,
                "FR756",
                "GLA",
                "EDI",
                LocalDate.of(2023, 1, 1)
        );
        plane2 = new Plane(PlaneType.SMALL);
        flight2 = new Flight(
                pilot,
                cabinCrewMembers,
                plane2,
                "FR756",
                "GLA",
                "EDI",
                LocalDate.of(2023, 1, 1)
        );
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
        assertEquals(LocalDate.of(2023, 1, 1), flight.getDepartureTime());
    }

    @Test
    public void canReturnNumberOfAvailableSeats() {
        assertEquals(300, flight.getAvailableSeats());
    }

    @Test
    public void canBookAPassenger() {
        flight.bookPassenger(passenger);
        assertEquals(299,  flight.getAvailableSeats());
    }

    @Test
    public void shouldNotBookMorePassengersThanAvailableSeats() {
        for (int i = 0, n = 1000; i < n; i++) {
            flight2.bookPassenger(new Passenger("Joe", 3));
        }
        assertEquals(0, flight2.getAvailableSeats());
        assertEquals(10, flight2.getPassengers().size());
    }

    @Test
    public void pilotShouldBeAbleToFlyThePlane() {
        assertEquals("I am John and we are about to take off", pilot.fly(flight));
    }

    @Test
    public void cabinCrewMembersShouldBeAbleToRelayMessagesToPassengers() {
        assertEquals("I am Joe and the flight FR756 is about to land", purser.relayMessage(flight));
    }

    @Test
    public void flightManagerShouldBeAbleToCalculateWeightReservedForEachPassenger() {
        int reservedWeight = flightManager.calculateReservedBaggageWeightPerPassenger(flight);
        assertEquals(16666, reservedWeight);
    }

    @Test
    public void flightManagerShouldBeAbleToCalculateWeightBookedByPassengers() {
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger2);
        int bookedWeight = flightManager.calculatedBookedWeight(flight);
//        NOTE: We are assuming that all the bags weight the same, i.e., 20
        assertEquals(180, bookedWeight);
    }

    @Test
    public void flightManagerShouldBeAbleToCalculateRemainingWeightForLuggage() {
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger2);
        int remainingWeight = flightManager.calculateRemainingWeight(flight);
        assertEquals(16486, remainingWeight);
    }

    @Test
    public void passengerOnFlightIsAcknowledged() {
        flight.bookPassenger(passenger);
        assertTrue(passenger.getFlightStatus());
    }

    @Test
    public void flightHasListOfEmptySeats() {
        assertEquals(300, flight.getNumberOfEmptySeats());
    }

    @Test
    public void passengerGetsUniqueSeatNumberWhenBooking() {
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger2);
        assertNotEquals(passenger.getSeatNumber(), passenger2.getSeatNumber());
        assertEquals(298, flight.getNumberOfEmptySeats());
        assertFalse(flight.getListEmptySeats().contains(passenger.getSeatNumber()));
        assertFalse(flight.getListEmptySeats().contains(passenger2.getSeatNumber()));
    }

    @Test
    public void shouldBeAbleToHandleManyUniqueSeatNumbers() {
        for (int i = 0, n = 299; i < n; i++) {
            flight.bookPassenger(new Passenger("Joe", 3));
        }
        assertEquals(1, flight.getNumberOfEmptySeats());
        assertEquals(299, flight.getPassengers().size());
    }
}
