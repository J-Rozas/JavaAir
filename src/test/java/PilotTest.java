import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {
    
    private Pilot pilot;
    
    @Before
    public void before() {
        pilot = new Pilot("John", CabinCrewMember.FIRST_OFFICER, "1871nvsu3");
    }
    
    @Test
    public void hasName() {
        assertEquals("John", pilot.getName());
    }
    
    @Test
    public void hasRank() {
        assertEquals("First Officer", pilot.getRank().getRankName());
    }
    
    @Test
    public void hasLicenseNumber() {
        assertEquals("1871nvsu3", pilot.getLicenseNumber());
    }
}
