import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private FlightManager flightManager;

    @Before
    public void before() {
        flightManager = new FlightManager("John");
    }

    @Test
    public void hasName() {
        assertEquals("John", flightManager.getName());
    }
}
