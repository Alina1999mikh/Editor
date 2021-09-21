import exeption.ConstructorException;
import model.Rnumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRnumber {
    @Test
    public void testConstructor() throws ConstructorException {
        assertEquals(new Rnumber(3.1234, 3, 2).toString(), "3.12,3,2");
        //assertEquals(new Rnumber(a,16,2).toString(), "3.12,3,2");

    }
}
