import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("John", 3);
    }

    @Test
    public void passengerHasName() {
        assertEquals("John", passenger.getName());
    }

    @Test
    public void passengerHasNumberOfBags() {
        assertEquals(3, passenger.getNumberOfBags());
    }
}
