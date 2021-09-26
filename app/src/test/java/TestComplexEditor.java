import editor.ComplexEditor;
import exeption.ActionException;
import exeption.DataException;
import model.Complex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestComplexEditor {

    ComplexEditor editor = new ComplexEditor();
    String NULL = "0,ix0";

    public TestComplexEditor() {
    }

    @Test
    public void testConstructorException() {
        assertThrows(DataException.class, () -> new Complex("4,-ix6"));
    }

    @Test
    public void testIsNull() throws DataException {
        assertTrue(editor.isNull(NULL));
        assertFalse(editor.isNull("4,ix6"));
    }

    @Test
    public void testClear() {
        assertEquals(editor.clear(), NULL);
    }

    @Test
    public void testAddSignature() throws ActionException {
        assertEquals(editor.addSignature("4,ix6"), "-4,ix-6");
        assertEquals(editor.addSignature("4,ix-6"), "-4,ix6");
    }

    @Test
    public void testAddNumber() throws DataException {
        assertEquals(editor.addNumber("4,ix6", "5"), "4,ix65");
    }

    @Test
    public void testAddNull() throws DataException {
        assertEquals(editor.addNull("4,ix6"), "4,ix60");
    }

    @Test
    public void testAddNumberException() {
        assertThrows(ActionException.class, () -> editor.addSignature("4.9,i"));
    }

    @Test
    public void testDeleteNumber() throws ActionException {
        assertEquals(editor.deleteNumber("4,ix6"), "4,ix");
        assertEquals(editor.deleteNumber("4,ix-65"), "4,ix-6");
        assertEquals(editor.deleteNumber("4.5"), "4.");
    }
}