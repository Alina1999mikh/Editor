import editor.FractionEditor;
import exeption.ActionException;
import exeption.DataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFractionEditor {
    FractionEditor editor = new FractionEditor();

    @Test
    public void testAddSignature() throws ActionException {
        assertEquals(editor.addSignature("4/6"), "-4/6");
        assertEquals(editor.addSignature("-4/6"), "4/6");
    }

    @Test
    public void testAddSignatureException() {
        assertThrows(ActionException.class, () -> editor.addSignature("4/6/3"));
        assertThrows(ActionException.class, () -> editor.addSignature("4.3/6"));
        assertThrows(ActionException.class, () -> editor.addSignature("4/b"));
        assertThrows(ActionException.class, () -> editor.addSignature("b/4"));
    }

    @Test
    public void testAddNull() throws DataException {
        assertEquals(editor.addNull("4/6"), "4/60");
        assertEquals(editor.addNull("-4/6"), "-4/60");
        assertEquals(editor.addNull("4/"), "4/0");
        assertEquals(editor.addNull("4"), "40");
    }

    @Test
    public void testAddNullException() {
        assertThrows(DataException.class, () -> editor.addNull("4/6/3"));
        assertThrows(DataException.class, () -> editor.addNull("4.3/6"));
        assertThrows(DataException.class, () -> editor.addNull("4/b"));
        assertThrows(DataException.class, () -> editor.addNull("b/4"));
    }

    @Test
    public void clear() {
        assertEquals(editor.clear(), "0/1");
    }

    @Test
    public void isNull() throws DataException {
        assertTrue(editor.isNull("0/1"));
        assertTrue(editor.isNull("-0/2"));
        assertTrue(editor.isNull("0/2"));
        assertFalse(editor.isNull("3/2"));
    }

    @Test
    public void isNullTest() {
        assertThrows(DataException.class, () -> assertTrue(editor.isNull("0/0")));
        assertThrows(DataException.class, () -> assertTrue(editor.isNull("-0/0")));
        assertThrows(DataException.class, () -> assertTrue(editor.isNull("2/0")));
        assertThrows(DataException.class, () -> assertFalse(editor.isNull("2/-0")));
    }

    @Test
    public void testDelete() throws ActionException {
        assertEquals(editor.deleteNumber("4/6"), "4/");
        assertEquals(editor.deleteNumber("-4/60"), "-4/6");
        assertEquals(editor.deleteNumber("4/"), "4");
        assertEquals(editor.deleteNumber("4"), "");
    }

    @Test
    public void testDeleteException() {
        assertThrows(ActionException.class, () -> editor.deleteNumber(""));
        assertThrows(ActionException.class, () -> editor.deleteNumber(null));
    }
}