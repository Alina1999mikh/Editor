import exeption.DataException;
import model.TPNumber.TPNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRnumber {
    @Test
    public void testConstructor() throws DataException {
        assertEquals(new TPNumber("1.1210", 3, 2).toString(), "1.12,3,2");
        assertEquals(new TPNumber("1.1210", 3, 0).toString(), "1,3,0");
        assertEquals(new TPNumber("2", 3, 3).toString(), "2.0,3,3");
        assertEquals(new TPNumber("1.", 3, 2).toString(), "1.0,3,2");
        assertEquals(new TPNumber(".1", 3, 1).toString(), "0.1,3,1");

    }

    @Test
    public void testConstructorException() {
        assertThrows(DataException.class, () -> new TPNumber("3.1234", 3, 2));
    }

    @Test
    public void testConstructorException2() {
        assertThrows(DataException.class, () -> new TPNumber("3.123.4", 3, 2));
    }

    @Test
    public void testConstructorException3() {
        assertThrows(DataException.class, () -> new TPNumber("3A.34", 6, 2));
    }
}