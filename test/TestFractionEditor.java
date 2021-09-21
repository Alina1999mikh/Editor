import editor.FractionEditor;
import exeption.ActionException;
import exeption.ConstructorException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TestFractionEditor {
    FractionEditor editor = new FractionEditor();

    @Test
    public void testAddSignature() throws ActionException {
        assertEquals(editor.addSignature("4/6"), "-4/6");
        assertEquals(editor.addSignature("-4/6"), "4/6");
    }

    @Test(expected = ActionException.class)
    public void testAddSignatureException() throws ActionException {
        editor.addSignature("4/6/3");
        editor.addSignature("4.3/6");
        editor.addSignature("4/b");
        editor.addSignature("b/4");
    }

    @Test
    public void testAddNull() throws IOException {
        assertEquals(editor.addNull("4/6"), "4/60");
        assertEquals(editor.addNull("-4/6"), "-4/60");
        assertEquals(editor.addNull("4/"), "4/0");
        assertEquals(editor.addNull("4"), "40");
    }

    @Test(expected = IOException.class)
    public void testAddNullException() throws IOException {
        editor.addNull("4/6/3");
        editor.addNull("4.3/6");
        editor.addNull("4/b");
        editor.addNull("b/4");
    }

    @Test
    public void clear() {
        assertEquals(editor.clear(), "0/1");
    }

    @Test
    public void isNull() throws ConstructorException {
        assertTrue(editor.isNull("0/1"));
        assertTrue(editor.isNull("-0/2"));
        assertTrue(editor.isNull("0/2"));
        assertFalse(editor.isNull("3/2"));
    }

    @Test(expected = ConstructorException.class)
    public void isNullTest() throws ConstructorException {
        assertTrue(editor.isNull("0/0"));
        assertTrue(editor.isNull("-0/0"));
        assertTrue(editor.isNull("2/0"));
        assertFalse(editor.isNull("2/-0"));
    }

    @Test
    public void testDelete() throws ActionException {
        assertEquals(editor.deleteNumber("4/6"), "4/");
        assertEquals(editor.deleteNumber("-4/60"), "-4/6");
        assertEquals(editor.deleteNumber("4/"), "4");
        assertEquals(editor.deleteNumber("4"), "");
    }

    @Test(expected = ActionException.class)
    public void testDeleteException() throws ActionException {
        editor.deleteNumber("");
        editor.deleteNumber(null);
    }
}