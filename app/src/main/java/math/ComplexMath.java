package math;

import exeption.ActionException;
import exeption.DataException;
import model.Complex;

public class ComplexMath extends AbstractMath<Complex> {
    Complex a;

    ComplexMath(Complex a) {
        this.a = a;
    }

    @Override
    public Complex add(Complex f2) throws ActionException, DataException {
        Complex f = a;
        return new Complex(f.getWholePart() + f2.getWholePart(), f.getImaginaryPart() + f2.getImaginaryPart());
    }

    @Override
    public Complex getNull() throws DataException {
        return new Complex(Complex.NULL);
    }
}
