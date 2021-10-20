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

    @Override
    public Fraction subtraction(Fraction f2) throws DataException, ActionException {
        return add(new Fraction(f2.getA() * (-1), f2.getB()));
    }

    @Override
    public Fraction multiplication(Fraction f2) throws DataException {
        return new Fraction(super.a * f2.getA(), super.b * f2.getB());
    }

    @Override
    public Fraction division(Fraction f2) throws DataException {
        return new Fraction(super.a * f2.getB(), super.b * f2.getA());
    }

    public Fraction square() throws DataException {
        return new Fraction(multiplication(a));
    }

    @Override
    public Fraction inverse() throws DataException {
        return new Fraction(a.getB(), a.getA());
    }

    @Override
    public Fraction getModel() {
        return a;
    }

    @Override
    public FractionMath toMath() throws DataException {
        return new FractionMath(a);
    }
}