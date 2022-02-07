import exeption.ActionException;
import exeption.DataException;
import math.ComplexMath;
import math.FractionMath;
import math.TPNumberMath;
import model.Complex;
import model.Fraction;
import model.TANumber.TANumber;
import model.TANumber.Type;
import model.TPNumber.TPNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTANumber {
    TANumber<Complex, ComplexMath> tComplex = new TANumber(Type.COMPLEX);
    TANumber<Fraction, FractionMath> tFrac = new TANumber(Type.FRACTION);
    TANumber<TPNumber, TPNumberMath> tTPN = new TANumber(Type.TPNUMBER);

    @Test
    public void testAddition() throws Exception {
        assertEquals(tComplex.add(new Complex(9, 3), new Complex(1, 2)), new Complex(10, 5));
        assertEquals(tComplex.add(new Complex(-3, 2), new Complex(3, 2)), new Complex(0, 4));
        assertEquals(tComplex.add(new Complex(7, 4), new Complex(6, 3)), new Complex(13, 7));
        assertEquals(tFrac.add(new Fraction(1, 3), new Fraction(1, 3)), new Fraction(2, 3));
        assertEquals(tTPN.add(new TPNumber("10", 10, 2), new TPNumber("20", 10, 2)), new TPNumber("30.0", 10, 2));
        assertEquals(tTPN.add(new TPNumber("17.213", 10, 2), new TPNumber("20.21", 10, 2)), new TPNumber("37.42", 10, 2));
    }

    @Test
    public void testSubtraction() throws Exception {
        assertEquals(tComplex.subtraction(new Complex(9, 3), new Complex(1, 2)), new Complex(8, 1));
        assertEquals(tFrac.subtraction(new Fraction(4, 3), new Fraction(1, 3)), new Fraction(3, 3));
        assertEquals(tTPN.subtraction(new TPNumber("20", 10, 2), new TPNumber("10", 10, 2)), new TPNumber("10.0", 10, 2));
        assertEquals(tTPN.subtraction(new TPNumber("37.213", 10, 2), new TPNumber("20.2", 10, 2)), new TPNumber("17.01", 10, 2));
    }

    @Test
    public void testMultiplication() throws Exception {
        assertEquals(tComplex.multiplication(new Complex(4, 5), new Complex(2, -3)), new Complex(23, -2));
        assertEquals(tFrac.multiplication(new Fraction(4, 3), new Fraction(2, 3)), new Fraction(8, 9));
        assertEquals(tTPN.multiplication(new TPNumber("20", 10, 2), new TPNumber("10", 10, 2)), new TPNumber("200.0", 10, 2));
    }

    @Test
    public void testDivision() throws Exception {
        assertEquals(tComplex.division(new Complex(7, 2), new Complex(2, 1)), new Complex(3.2, -0.6));
        assertEquals(tFrac.division(new Fraction(10, 3), new Fraction(3, 2)), new Fraction(20, 9));
        assertEquals(tTPN.division(new TPNumber("20", 10, 2), new TPNumber("10", 10, 2)), new TPNumber("2.0", 10, 2));
    }

    @Test
    public void testSquare() throws Exception {
        assertEquals(tComplex.square(new Complex(4, 5)), new Complex(-9, 40));
        assertEquals(tFrac.square(new Fraction(10, 3)), new Fraction(100, 9));
        assertEquals(tTPN.square(new TPNumber("A67.B", 16, 2)), new TPNumber("6C43Bf.19", 16, 2));
    }

    @Test
    public void testInverse() throws DataException, ActionException {
        assertEquals(tComplex.inverse(new Complex(4, 5)), new Complex(5, 4));
        assertEquals(tFrac.inverse(new Fraction(10, 3)), new Fraction(3, 10));
    }

    @Test
    public void equals() throws DataException {
        assertEquals(new Complex(-9, 40), new Complex(-9, 40));
        assertNotEquals(new Complex(9, 40), new Complex(-9, 40));

        assertEquals(new Fraction(-10, 40), new Fraction(-1, 4));
        assertNotEquals(new Fraction(9, 40), new Fraction(-9, 40));

        assertEquals(new TPNumber("-9", 10, 2), new TPNumber("-9", 10, 2));
        assertNotEquals(new TPNumber("9", 10, 2), new TPNumber("-9", 10, 2));
    }
}