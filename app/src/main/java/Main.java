import exeption.ActionException;
import exeption.DataException;
import math.ComplexMath;
import model.Complex;
import model.TANumber.TANumber;
import model.TANumber.Type;

public class Main {
    public static void main(String[] args) throws DataException, ActionException {
        //MainEdit.edit();
        //      TMemory<Fraction, FractionMath> t=new TMemory<>(Fraction.getNULL(), new FractionMath(Fraction.getNULL())); // null
        //    t.add(new Fraction("4/5"));
        TANumber<Complex, ComplexMath> t = new TANumber(Type.COMPLEX);
        System.out.println("answer is " + t.add(new Complex(9, 3), new Complex(1, 2)));
    }
}