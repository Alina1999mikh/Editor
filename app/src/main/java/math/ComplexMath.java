package math;

import exeption.ActionException;
import exeption.DataException;
import model.Complex;

public class ComplexMath extends Complex implements AbstractMath<Complex> {
    Complex a;

    public ComplexMath(Complex a) throws DataException {
        super(a);
        this.a = a;
    }

    @Override
    public Complex add(Complex b) throws ActionException, DataException {
        Complex f = a;
        return new Complex(f.getWholePart() + b.getWholePart(), f.getImaginaryPart() + b.getImaginaryPart());
    }
}