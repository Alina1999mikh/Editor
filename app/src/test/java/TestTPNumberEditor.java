import editor.TPNumberEditor;
import editor.Validator;
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
        Validator v = new Validator(16, 4);
        assertEquals(editor.addNull("4.6", v), "4.60");
        assertEquals(editor.addNull("-4.6", v), "-4.60");
        assertEquals(editor.addNull("4.", v), "4.0");
        assertEquals(editor.addNull("4", v), "40");
    }

    @Test
    public void testAddNullException() {
        assertThrows(DataException.class, () -> editor.addNull("4.6.3", new Validator(16, 4)));
    }

    @Test
    public void clear() {
        assertEquals(editor.clear(), "0");
    }

    @Test
    public void isNull() {
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
        Validator v = new Validator(16, 4);
        assertEquals(editor.addNumber("4.A6", "5", v), "4.A65");
        assertEquals(editor.addNumber("4.", "5", v), "4.5");
        assertThrows(DataException.class, () -> editor.addNumber("4.A", "B", new Validator(9, 4)));
    }
}