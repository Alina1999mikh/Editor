import editor.StringEditor;
import exeption.ActionException;
import exeption.DataException;
import model.Complex;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestEditor {
    Complex e = new Complex("4,ix6");
    Complex e2 = new Complex("4,ix-6");
    Complex e3 = new Complex("4,ix-65");
    Complex d = new Complex("4.5,ix6.0");

    Complex NULL = new Complex("0,ix0");

    public TestEditor() throws DataException {
    }

    @Test
    public void testConstructor() {
        assertEquals(e.getComplex(), "4,ix6");
        assertEquals(e2.getComplex(), "4,ix-6");
        assertEquals(NULL.getComplex(), "0,ix0");
    }

    @Test(expected = DataException.class)
    public void testConstructorException() throws DataException {
        Complex e = new Complex("4,-ix6");
    }

    @Test
    public void testIsNull() throws DataException {
        assertTrue(StringEditor.isNull(NULL));
        assertFalse(StringEditor.isNull(e));
    }

    @Test
    public void testClear() throws DataException {
        assertEquals(StringEditor.clear(), NULL);
    }

    @Test
    public void testAddSignature() throws DataException, ActionException {
        assertEquals(StringEditor.addSignature(e), new Complex("-4,ix-6"));
        assertEquals(StringEditor.addSignature(e2), new Complex("-4,ix6"));
    }

    @Test
    public void testAddNumber() throws DataException {
        assertEquals(StringEditor.addNumber(e, "5"), new Complex("4,ix65"));
    }

    @Test(expected = ActionException.class)
    public void testAddNumberReException() throws DataException, ActionException {
        StringEditor.addSignature(new Complex("4.9,i"));
    }

    @Test
    public void testDeleteNumber() throws DataException {
        assertEquals(StringEditor.deleteNumber(e), new Complex("4,ix"));
        assertEquals(StringEditor.deleteNumber(e3), new Complex("4,ix-6"));
        assertEquals(StringEditor.deleteNumber(new Complex("4.5")), new Complex("4."));

    }
}