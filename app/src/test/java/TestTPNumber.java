import exeption.ActionException;
import exeption.DataException;
import math.TPNumberMath;
import model.TPNumber.TPNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTPNumber {

    TPNumberMath math = new TPNumberMath();

    @Test
    public void testConstructor() throws DataException {
        assertEquals(new TPNumber("1.1234", 10, 2).toString(), "1.12,10,2");
    }

    @Test
    public void testCopy() throws DataException {
        assertEquals(new TPNumber("1.1210", 3, 2).copy(), new TPNumber("1.1210", 3, 2));
    }

    @Test
    public void testConstructorException() {
        assertThrows(DataException.class, () -> new TPNumber("3.1234", 3, 2));
        assertThrows(DataException.class, () -> new TPNumber("3.123.4", 3, 2));
        assertThrows(DataException.class, () -> new TPNumber("3A.34", 6, 2));
    }

    @Test
    public void testEquals() throws DataException {
        assertNotEquals(new TPNumber("1234", 10, 2), new TPNumber("1234", 10, 3));
        assertEquals(new TPNumber("1234", 10, 2), new TPNumber("1234", 10, 2));
    }

    @Test
    public void testAdd() throws DataException, ActionException {

        assertEquals(math.add((new TPNumber("A67.B2", 16, 2)), new TPNumber("C5.11", 16, 2)), new TPNumber("B2C.C3", 16, 2));
        assertEquals(math.add(new TPNumber("46.56", 8, 4), new TPNumber("736.42", 8, 4)), new TPNumber("1005.2", 8, 4));
        assertEquals(math.add(new TPNumber("30", 10, 4), new TPNumber("-20", 10, 4)), new TPNumber("10.0", 10, 4));
    }

    @Test
    public void testSubtraction() throws DataException, ActionException {
        assertEquals((math.subtraction(new TPNumber("100.1", 2, 2), new TPNumber("110.11", 2, 2))), new TPNumber("-10.01", 2, 2));
        assertEquals((math.subtraction(new TPNumber("A67.B2", 16, 2), new TPNumber("C5.11", 16, 2))), new TPNumber("9A2.A1", 16, 2));
        assertEquals(math.subtraction(new TPNumber("46.56", 8, 4), new TPNumber("736.42", 8, 4)), new TPNumber("-667.64", 8, 4));
        assertEquals(math.subtraction(new TPNumber("3", 10, 4), new TPNumber("1", 10, 4)), new TPNumber("2.0", 10, 4));
        assertEquals(math.subtraction(new TPNumber("30", 10, 4), new TPNumber("-10", 10, 4)), new TPNumber("40.0", 10, 4));

    }

    @Test
    public void testMultiplication() throws DataException, ActionException {
        assertEquals(math.multiplication(new TPNumber("A67.B", 16, 2), new TPNumber("C5.11", 16, 2)), new TPNumber("8027B.52B0", 16, 2));
        assertEquals(math.multiplication(new TPNumber("46.56", 8, 4), new TPNumber("736.42", 8, 4)), new TPNumber("44140.1034", 8, 4));
        assertEquals(math.multiplication(new TPNumber("7.17832", 10, 4), new TPNumber("10.2", 10, 4)), new TPNumber("73.2188864", 10, 4));
    }

    @Test
    public void testSquare() throws DataException, ActionException {
        assertEquals(math.square(new TPNumber("A67.B", 16, 2)), new TPNumber("6C43Bf.19", 16, 2));
        assertEquals(math.square(new TPNumber("46.56", 8, 4)), new TPNumber("2733.1104", 8, 4));
        assertEquals(math.square(new TPNumber("7.17832", 10, 4)), new TPNumber("51.528278", 10, 4));
    }

    @Test
    public void testDivision() throws DataException {
        assertEquals(math.division(new TPNumber("A67.B", 16, 2), new TPNumber("C5.11", 16, 2)), new TPNumber("D.8446741292", 16, 2));
        assertEquals(math.division(new TPNumber("46.56", 8, 4), new TPNumber("736.42", 8, 4)), new TPNumber("0.051332400771", 8, 4));
        assertEquals(math.division(new TPNumber("7.17832", 10, 4), new TPNumber("10.2", 10, 4)), new TPNumber("0.7037", 10, 4));
    }

    @Test
    public void testDivisionException() {
        assertThrows(DataException.class, () -> math.division(new TPNumber("A67.B", 16, 2), (new TPNumber("0", 16, 2))));
    }

    @Test
    public void testGetN() throws DataException {
        assertEquals(new TPNumber("1234.344678", 10, 2).getShortN(), "1234.34");
        assertEquals(new TPNumber("1234", 10, 2).getShortN(), "1234");
        assertEquals(new TPNumber("1234.36", 10, 2).getShortN(), "1234.36");
    }
}