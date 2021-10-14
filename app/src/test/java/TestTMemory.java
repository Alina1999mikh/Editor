import exeption.ActionException;
import exeption.DataException;
import math.ComplexMath;
import math.FractionMath;
import math.TPNumberMath;
import memory.TMemory;
import model.Complex;
import model.Fraction;
import model.TPNumber.TPNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTMemory {

    TMemory<Fraction, FractionMath> t = new TMemory<>(new FractionMath(Fraction.getNULL()));
    TMemory<Complex, ComplexMath> t2 = new TMemory<>(new ComplexMath(Complex.getNULL()));
    TMemory<TPNumber, TPNumberMath> t3 = new TMemory<>(new TPNumberMath(TPNumber.getNULL()));

    public TestTMemory() throws DataException {
    }

    @Test
    public void testStore() throws DataException {
        t.store(new FractionMath(new Fraction("4/5")));
        t2.store(new ComplexMath(new Complex("5,ix6")));
        t3.store(new TPNumberMath(new TPNumber("45", 10, 0)));
        assertEquals(t.getfNumber(), new Fraction("4/5"));
        assertTrue(t.isFState());
        assertEquals(t2.getfNumber(), new Complex("5,ix6"));
        assertTrue(t2.isFState());
        assertTrue(t3.isFState());
    }

    @Test
    public void testClear() throws DataException {
        t.clear();
        assertEquals(t.getfNumber(), Fraction.getNULL());
        assertFalse(t.isFState());
    }


    @Test
    public void testAdd() throws DataException, ActionException {
        t.add(new Fraction("4/5"));
        t2.add(new Complex("5,ix6"));
        t3.add(new TPNumber("45", 10, 0));
    }
}