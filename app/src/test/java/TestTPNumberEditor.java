import editor.TPNumberEditor;
import exeption.ActionException;
import exeption.DataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTPNumberEditor {
    TPNumberEditor editor = new TPNumberEditor();

    @Test
    public void testAddSignature() throws ActionException {
        assertEquals(editor.addSignature("A45B,8"), "-A45B,8");
        assertEquals(editor.addSignature("8678"), "-8678");
    }

    @Test
    public void testAddSignatureException() {
        assertThrows(ActionException.class, () -> editor.addSignature("4.6.3"));
    }

    @Test
    public void testAddNull() throws DataException {
        assertEquals(editor.addNull("4.6", 16, 4), "4.60");
        assertEquals(editor.addNull("-4.6", 16, 4), "-4.60");
        assertEquals(editor.addNull("4.", 16, 4), "4.0");
        assertEquals(editor.addNull("4", 16, 4), "40");
    }

    @Test
    public void testAddNullException() {
        assertThrows(DataException.class, () -> editor.addNull("4.6.3"));
    }

    @Test
    public void clear() {
        assertEquals(editor.clear(), "0");
    }

    @Test
    public void isNull() throws DataException {
        assertTrue(editor.isNull("0"));
        assertFalse(editor.isNull("3"));
    }

    @Test
    public void testDelete() throws ActionException {
        assertEquals(editor.deleteNumber("4.6"), "4.");
        assertEquals(editor.deleteNumber("-4.60"), "-4.6");
        assertEquals(editor.deleteNumber("4."), "4");
        assertEquals(editor.deleteNumber("4"), "");
    }

    @Test
    public void testDeleteException() {
        assertThrows(ActionException.class, () -> editor.deleteNumber(""));
        assertThrows(ActionException.class, () -> editor.deleteNumber(null));
    }

    @Test
    public void testAddNumber() throws DataException {
        assertEquals(editor.addNumber("4.A6", 16, 4, "5"), "4.A65");
        assertEquals(editor.addNumber("4.", 16, 4, "5"), "4.5");
        assertThrows(DataException.class, () -> editor.addNumber("4.A", 10, 4, "B"));
    }
}
