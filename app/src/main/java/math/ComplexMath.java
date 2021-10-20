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

    @Override
    public Complex subtraction(Complex f2) throws DataException, ActionException {
        return add(new Complex(f2.getWholePart() * (-1), f2.getImaginaryPart() * (-1)));
    }

    @Override
    public Complex multiplication(Complex f2) throws DataException {
        return new Complex(this.a.getWholePart() * f2.getWholePart() - this.a.getImaginaryPart() * f2.getImaginaryPart(), this.a.getWholePart() * f2.getImaginaryPart() + f2.getWholePart() * this.a.getImaginaryPart());
    }

    @Override
    public Complex division(Complex f2) throws DataException {
        double znam = f2.getWholePart() * f2.getWholePart() + f2.getImaginaryPart() * f2.getImaginaryPart();
        double p1 = this.a.getWholePart() * f2.getWholePart() + this.a.getImaginaryPart() * f2.getImaginaryPart();
        p1 /= znam;
        double p2 = this.a.getImaginaryPart() * f2.getWholePart() - this.a.getWholePart() * f2.getImaginaryPart();
        p2 /= znam;
        return new Complex(p1, p2);
    }

    @Override
    public Complex square() throws DataException, ActionException {
        return multiplication(a);
    }

    @Override
    public Complex getModel() {
        return a;
    }

    @Override
    public Complex inverse() throws DataException {
        return new Complex(a.getImaginaryPart(), a.getWholePart());
    }

    @Override
    public ComplexMath toMath() throws DataException {
        return new ComplexMath(a);
    }
}