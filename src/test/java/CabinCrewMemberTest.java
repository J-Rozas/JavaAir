import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabinCrewMemberTest {

    private CabinCrewMember cabinCrewMember;

    @Before
    public void before() {
        cabinCrewMember = new CabinCrewMember("John", Rank.FLIGHT_ATTENDANT);
    }

    @Test
    public void hasName() {
        assertEquals("John", cabinCrewMember.getName());
    }

    @Test
    public void hasRank() {
        assertEquals(Rank.FLIGHT_ATTENDANT, cabinCrewMember.getRank());
    }
}
