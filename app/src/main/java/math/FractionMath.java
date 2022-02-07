package math;

import exeption.ActionException;
import exeption.DataException;
import model.Fraction;

public class FractionMath extends Fraction implements InterfaceMath<Fraction> {

    public FractionMath() throws DataException {
    }

    @Override
    public Fraction add(Fraction a, Fraction b) throws ActionException, DataException {
        if (a.b == b.getB()) {
            return new Fraction(a.a + b.getA(), a.b);
        } else {
            int down = a.b * b.getB();
            int up = a.a * b.getA();
            up += b.getA() * a.b;
            return new Fraction(up, down);
        }
    }

    @Override
    public Fraction subtraction(Fraction a, Fraction b) throws DataException, ActionException {
        return add(a, new Fraction(b.getA() * (-1), b.getB()));
    }

    @Override
    public Fraction multiplication(Fraction a, Fraction b) throws DataException {
        return new Fraction(a.getA() * b.getA(), b.getB() * b.getB());
    }

    @Override
    public Fraction division(Fraction a, Fraction b) throws DataException {
        return new Fraction(a.getA() * b.getB(), a.getB() * b.getA());
    }

    public Fraction square(Fraction a) throws DataException {
        return new Fraction(multiplication(a, a));
    }

    @Override
    public Fraction inverse(Fraction a) throws DataException {
        return new Fraction(a.getB(), a.getA());
    }
}