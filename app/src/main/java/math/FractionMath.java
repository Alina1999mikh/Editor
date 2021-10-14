package math;

import exeption.ActionException;
import exeption.DataException;
import model.Fraction;

public class FractionMath extends Fraction implements AbstractMath<Fraction> {
    Fraction a;

    public FractionMath(Fraction a) throws DataException {
        super(a);
        this.a = a;
    }

    @Override
    public Fraction add(Fraction f2) throws ActionException, DataException {
        Fraction f = this.a;
        if (f.b == f2.getB()) {
            return new Fraction(f.a + f2.getA(), f.b);
        } else {
            int b = f.b * f2.getB();
            int a = f.a * f2.getA();
            a += f2.getA() * f.b;
            return new Fraction(a, b);
        }
    }
}
