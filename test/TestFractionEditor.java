import editor.FractionEditor;
import exeption.ActionException;
import exeption.ConstructorException;
import model.Fraction;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestFractionEditor {
    @Test
    public void testAddSignature() throws ActionException {
        assertEquals(FractionEditor.addSign("4/6"), "-4/6");
        assertEquals(FractionEditor.addSign("-4/6"), "4/6");
    }

    @Test(expected = ActionException.class)
    public void testAddSignatureException() throws ActionException {
        FractionEditor.addSign("4/6/3");
        FractionEditor.addSign("4.3/6");
        FractionEditor.addSign("4/b");
        FractionEditor.addSign("b/4");
    }

    @Test
    public void testAddNull() throws ActionException, ConstructorException {
        assertEquals(FractionEditor.addNull("4/6"), "4/60");
        assertEquals(FractionEditor.addNull("-4/6"), "-4/60");
        assertEquals(FractionEditor.addNull("4/"), "4/0");
        assertEquals(FractionEditor.addNull("4"), "40");
    }

    @Test(expected = ActionException.class)
    public void testAddNullException() throws ActionException, ConstructorException {
        FractionEditor.addNull("4/6/3");
        FractionEditor.addNull("4.3/6");
        FractionEditor.addNull("4/b");
        FractionEditor.addNull("b/4");
    }

    @Test
    public void clear() throws ActionException, ConstructorException {
        assertEquals(FractionEditor.addNull("4/6"), "4/60");
        assertEquals(FractionEditor.addNull("-4/6"), "-4/60");
        assertEquals(FractionEditor.addNull("4/"), "4/0");
        assertEquals(FractionEditor.addNull("4"), "40");
    }

    @Test
    public void isNull() throws ConstructorException {
        assertTrue(FractionEditor.isNull(new Fraction("0/1")));
        assertTrue(FractionEditor.isNull(new Fraction("-0/2")));
        assertTrue(FractionEditor.isNull(new Fraction("0/2")));
        assertFalse(FractionEditor.isNull(new Fraction("3/2")));
    }

    @Test(expected = ConstructorException.class)
    public void isNullTest() throws ConstructorException {
        assertTrue(FractionEditor.isNull(new Fraction("0/0")));
        assertTrue(FractionEditor.isNull(new Fraction("-0/0")));
        assertTrue(FractionEditor.isNull(new Fraction("2/0")));
        assertFalse(FractionEditor.isNull(new Fraction("2/-0")));
    }

    @Test
    public void testDelete() throws ActionException {
        assertEquals(FractionEditor.deleteNumber("4/6"), "4/");
        assertEquals(FractionEditor.deleteNumber("-4/60"), "-4/6");
        assertEquals(FractionEditor.deleteNumber("4/"), "4");
        assertEquals(FractionEditor.deleteNumber("4"), "");
    }

    @Test(expected = ActionException.class)
    public void testDeleteException() throws ActionException {
        FractionEditor.deleteNumber("");
        FractionEditor.deleteNumber(null);
    }
}