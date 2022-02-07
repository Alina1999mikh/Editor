package math;

import exeption.ActionException;
import exeption.DataException;
import model.Complex;

public class ComplexMath extends Complex implements InterfaceMath<Complex> {

    @Override
    public Complex add(Complex a, Complex b) throws ActionException, DataException {
        return new Complex(a.getWholePart() + b.getWholePart(), a.getImaginaryPart() + b.getImaginaryPart());
    }

    @Override
    public Complex subtraction(Complex a, Complex b) throws DataException, ActionException {
        return add(a, new Complex(b.getWholePart() * (-1), b.getImaginaryPart() * (-1)));
    }

    @Override
    public Complex multiplication(Complex a, Complex b) throws DataException {
        return new Complex(a.getWholePart() * b.getWholePart() - a.getImaginaryPart() * b.getImaginaryPart(), a.getWholePart() * b.getImaginaryPart() + b.getWholePart() * a.getImaginaryPart());
    }

    @Override
    public Complex division(Complex a, Complex b) throws DataException {
        double znam = b.getWholePart() * b.getWholePart() + b.getImaginaryPart() * b.getImaginaryPart();
        double p1 = a.getWholePart() * b.getWholePart() + a.getImaginaryPart() * b.getImaginaryPart();
        p1 /= znam;
        double p2 = a.getImaginaryPart() * b.getWholePart() - a.getWholePart() * b.getImaginaryPart();
        p2 /= znam;
        return new Complex(p1, p2);
    }

    @Override
    public Complex square(Complex a) throws DataException, ActionException {
        return multiplication(a, a);
    }

    @Override
    public Complex inverse(Complex a) throws DataException {
        return new Complex(a.getImaginaryPart(), a.getWholePart());
    }

    public double angleRad(Complex a) {
        double whole = a.getWholePart();
        double im = a.getImaginaryPart();
        if (whole > 0) return Math.atan(im / whole);
        else if (whole == 0 && im > 0) return (Math.PI) / 2;
        else if (whole < 0) return Math.atan(im / whole) + Math.PI;
        else /* if(a==0 && b<0)*/ return ((-1) * Math.PI) / 2;
    }

    public double angleGrad(Complex a) {
        return angleRad(a) * 180 / Math.PI;
    }

    public Complex pow(Complex a, int n) throws DataException {
        double fi = angleRad(a);
        return new Complex(Math.pow(abs(a), n) * (Math.cos(n * fi)), Math.pow(abs(a), n) * Math.sin(n * fi));
    }

    public double abs(Complex a) {
        return Math.sqrt(Math.pow(a.getWholePart(), 2) + Math.pow(a.getImaginaryPart(), 2));
    }
}