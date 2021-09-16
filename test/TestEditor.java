import exeption.ActionException;
import exeption.dataException;
import editor.StringEditor;
import model.Complex;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestEditor {
    Complex e = new Complex("4,i*6");
    Complex e2 = new Complex("4,-i*6");
    Complex e3 = new Complex("4,-i*65");
    Complex NULL = new Complex("0,i*0");

    public TestEditor() throws dataException {
    }

    @Test
    public void testConstructor() {
        assertEquals(e.getRe(), 4);
        assertEquals(e.getIm(), 6);

        assertEquals(e2.getRe(), 4);
        assertEquals(e2.getIm(), -6);
    }

    @Test
    public void testAddSignature() throws dataException {
        assertEquals(StringEditor.addSignature(e), new Complex(-4, -6));
        assertEquals(StringEditor.addSignature(e2), new Complex(-4, 6));
    }

    @Test
    public void testAddNumberRe() throws dataException, ActionException {
        assertEquals(StringEditor.addNumberRe(e, "5"), new Complex(45, 6));
        assertEquals(StringEditor.addNumberRe(e, "56"), new Complex(456, 6));
    }

    @Test(expected = ActionException.class)
    public void testAddNumberReException() throws dataException, ActionException {
        StringEditor.addNumberRe(e, "-5");
    }

    @Test
    public void testAddNumberIm() throws dataException, ActionException {
        assertEquals(StringEditor.addNumberIm(e, "5"), new Complex(4, 65));
        assertEquals(StringEditor.addNumberIm(e, "56"), new Complex(4, 656));
    }

    @Test(expected = ActionException.class)
    public void testAddNumberImException() throws dataException, ActionException {
        StringEditor.addNumberIm(e, "-5");
    }

    @Test
    public void testDeleteNumber() throws dataException, ActionException {
        assertEquals(StringEditor.deleteNumber(e3), new Complex(4, -6));
        assertEquals(StringEditor.deleteNumber(e), new Complex(4, null));
    }

    @Test
    public void testClear() throws dataException {
        assertEquals(StringEditor.clear(e), NULL);
    }
}