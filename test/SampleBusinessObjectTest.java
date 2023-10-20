import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 * This is the SampleBusinessObject testing class.
 * @author Shevyn Buhary
 */
class SampleBusinessObjectTest {
    /**
     * Tester for the getID method for the sampleBusinessObject
     */
    @Test
    void sampleBusinessIDTest(){
        SampleBusinessObject testobj = SampleBusinessObject.createBO(12);
        //assertEquals(testobj.getID(), 12);
        assertThat(testobj.getID(), is(12));
    }
}
