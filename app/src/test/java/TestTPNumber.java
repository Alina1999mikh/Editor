import exeption.ActionException;
import exeption.DataException;
import math.TPNumberMath;
import model.TPNumber.TPNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTPNumber {
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

        assertEquals(new TPNumberMath(new TPNumber("A67.B2", 16, 2)).add(new TPNumber("C5.11", 16, 2)), new TPNumber("B2C.C3", 16, 2));
        assertEquals(new TPNumberMath(new TPNumber("46.56", 8, 4)).add(new TPNumber("736.42", 8, 4)), new TPNumber("1005.2", 8, 4));
    }

    @Test
    public void testSubtraction() throws DataException, ActionException {
        assertEquals(TPNumberMath.subtraction(new TPNumber("A67.B2", 16, 2), new TPNumber("C5.11", 16, 2)), new TPNumber("9A2.A1", 16, 2));
        assertEquals(TPNumberMath.subtraction(new TPNumber("46.56", 8, 4), new TPNumber("736.42", 8, 4)), new TPNumber("-667.64", 8, 4));
    }

    @Test
    public void testMultiplication() throws DataException, ActionException {
        assertEquals(TPNumberMath.multiplication(new TPNumber("A67.B", 16, 2), new TPNumber("C5.11", 16, 2)), new TPNumber("8027B.52B0", 16, 2));
        assertEquals(TPNumberMath.multiplication(new TPNumber("46.56", 8, 4), new TPNumber("736.42", 8, 4)), new TPNumber("4414.1034", 8, 4));
        assertEquals(TPNumberMath.multiplication(new TPNumber("7.17832", 10, 4), new TPNumber("10.2", 10, 4)), new TPNumber("73.2188864", 10, 4));
    }

    @Test
    public void testSquare() throws DataException, ActionException {
        assertEquals(TPNumberMath.square(new TPNumber("A67.B", 16, 2)), new TPNumber("6C43Bf.19", 16, 2));
        assertEquals(TPNumberMath.square(new TPNumber("46.56", 8, 4)), new TPNumber("2733.1104", 8, 4));
        assertEquals(TPNumberMath.square(new TPNumber("7.17832", 10, 4)), new TPNumber("51.528278", 10, 4));
    }

    @Test
    public void testDivision() throws DataException {
        assertEquals(TPNumberMath.division(new TPNumber("A67.B", 16, 2), new TPNumber("C5.11", 16, 2)), new TPNumber("D.8446741292", 16, 2));
        assertEquals(TPNumberMath.division(new TPNumber("46.56", 8, 4), new TPNumber("736.42", 8, 4)), new TPNumber("0.051332400771", 8, 4));
        assertEquals(TPNumberMath.division(new TPNumber("7.17832", 10, 4), new TPNumber("10.2", 10, 4)), new TPNumber("0.7037", 10, 4));
    }

    @Test
    public void testDivisionException() {
        assertThrows(DataException.class, () -> TPNumberMath.division(new TPNumber("7.17832", 10, 4), new TPNumber("0", 10, 4)));
    }

    @Test
    public void testGetN() throws DataException {
        assertEquals(new TPNumber("1234.344678", 10, 2).getShortN(), "1234.34");
        assertEquals(new TPNumber("1234", 10, 2).getShortN(), "1234");
        assertEquals(new TPNumber("1234.36", 10, 2).getShortN(), "1234.36");
    }
}