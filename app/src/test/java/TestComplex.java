import exeption.DataException;
import math.ComplexMath;
import model.Complex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestComplex {
    Complex f = new Complex(4, 5);
    Complex f2 = new Complex(4, -5);
    ComplexMath math = new ComplexMath();

    public TestComplex() throws DataException {
    }

    //ok
    @Test
    public void testComplexAddition() throws Exception {
        assertEquals(math.add(f, new Complex(9, 3)), new Complex(13, 8));
    }

    //ok
    @Test
    public void testComplexSubtraction() throws Exception {
        assertEquals(math.subtraction(f, new Complex(3, 2)).toString(), new Complex(1, 3).toString());
    }

    //ok
    @Test
    public void testComplexMultiplication() throws Exception {
        assertEquals(math.multiplication(f, new Complex(2, -3)), new Complex(23, -2));
        assertEquals(math.multiplication(f, new Complex(0, 4)), new Complex(-20, 16));
        assertEquals(math.multiplication(f, new Complex(-4, 0)), new Complex(-16, -20));
    }


    @Test
    public void testComplexDivision() throws Exception {
        Complex res = math.division(new Complex(7, 2), (new Complex(2, 1)));
        assertEquals(res, new Complex(3.2, -0.6));
    }

    @Test
    public void testComplexSquare() throws Exception {
        assertEquals(math.square(f), new Complex(-9, 40));
    }

    @Test
    public void testComplexAbs() throws Exception {
        assertEquals(math.abs(new Complex(4, 5)), Math.sqrt(41), 0);
    }

    @Test
    public void testAngleRad() throws Exception {
        assertEquals(math.angleRad(new Complex(1, 1)), 0.79, 1);
    }

    @Test
    public void testAngleGrad() throws Exception {
        assertEquals(math.angleGrad(new Complex(1, 1)), 45, 1);
    }

    @Test
    public void testComplexInverse() throws Exception {
        assertEquals(math.inverse(f), new Complex(5, 4));
    }

//    @Test
//    public void testComplexMinus() throws Exception {
//        assertEquals(math.minus(f), new Complex(-4, 5));
//    }

    @Test
    public void testGetA() {
        assertEquals(f.getWholePart(), (double) 4, 0);
        assertNotEquals(f.getWholePart(), (double) 5, 0);
    }

    @Test
    public void testGetB() {
        assertEquals(f.getImaginaryPart(), (double) 5, 0);
    }

//    @Test
//    public void testComplexEquals() throws ConstructorException {
//        assertEquals(f, .copy());
//        assertEquals(f2, new Complex(4, -5));
//        assertNotEquals(f2, new Complex(4, 5));
//    }

    @Test
    public void testIsNull() throws DataException {
        assertTrue(new Complex(0, 0).isNULL());
        assertFalse(f.isNULL());
    }

    @Test
    public void testPow() throws DataException {
        assertEquals(math.pow(new Complex(2, 5), 3), new Complex(-142, -64.99999999999996));
    }
}