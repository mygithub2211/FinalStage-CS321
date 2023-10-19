import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
class SampleBusinessObjectTest {
    @Test
    void test(){
        SampleBusinessObject testobj = SampleBusinessObject.createBO(12);
        //assertEquals(testobj.getID(), 12);
        assertThat(testobj.getID(), is(12));
    }
}
