//import exeption.ActionException;
//import exeption.DataException;
//import math.ComplexMath;
//import math.FractionMath;
//import math.TPNumberMath;
//import model.Complex;
//import model.Fraction;
//import model.TPNumber.TPNumber;
//import org.junit.jupiter.api.Test;
//import processor.Operation;
//import processor.TProc;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TestTProc {
//    TProc<FractionMath> t = new TProc<>(new FractionMath(Fraction.getNULL()));
//    TProc<ComplexMath> t2 = new TProc<>(new ComplexMath(Complex.getNULL()));
//    TProc<TPNumberMath> t3 = new TProc<>(new TPNumberMath(TPNumber.getNULL()));
//
//    public TestTProc() throws DataException, ClassNotFoundException {
//    }
//
//    @Test
//    public void testConstructor() {
//        assertEquals(t.getTProc(), t.getNULL() + " NONE " + t.getNULL());
//        assertEquals(t2.getTProc(), t2.getNULL() + " NONE " + t2.getNULL());
//        assertEquals(t3.getTProc(), t3.getNULL() + " NONE " + t3.getNULL());
//    }
//
//    @Test
//    public void testTOperation() throws DataException, ActionException, ClassNotFoundException, NoSuchMethodException {
//        t.setRop(new FractionMath(new Fraction("2/1")));
//        t.setOperation(Operation.add);
//        t.TOperation();
//        t.setRop(new FractionMath(new Fraction("3/1")));
//        t.setOperation(Operation.add);
//        t.TOperation();
//        t.setOperation(Operation.square);
//        t.setRop(new FractionMath(new Fraction("4/1")));
//        t.TOperation();
//        t.setOperation(Operation.multiplication);
//        t.TOperation();
//        assertEquals(t.getLopRes(), new FractionMath(new Fraction(80, 1)));
//        t.setOperation(Operation.inverse);
//        assertEquals(t.getOperation(), Operation.inverse);
//        t.setRop(new FractionMath(new Fraction("1/2")));
//        t.TOperation();
//        assertEquals(t.getRop(), new FractionMath(new Fraction(2, 1)));
//        t.setOperation(Operation.division);
//        t.TOperation();
//        assertEquals(t.getLopRes(), new FractionMath(new Fraction(40, 1)));
//    }
//}
