package editor;

import exeption.ActionException;
import exeption.DataException;
import model.Complex;

public class ComplexEditor extends AbstractEditor {

    public ComplexEditor() {
        super();
    }

    @Override
    protected String adderSignature(String[] str) throws ActionException {
        if (str.length != 2) throw new ActionException("you cant add signature here");

        double re = Double.parseDouble(str[0]) * (-1);
        double im = Double.parseDouble(str[1]) * (-1);
        if (im % 1 == 0 && re % 1 == 0) return (int) re + Complex.Z_SEPARATOR + (int) im;
        else if (im % 1 == 0) return re + Complex.Z_SEPARATOR + (int) im;
        else if (re % 1 == 0) return (int) re + Complex.Z_SEPARATOR + im;
        else return re + Complex.Z_SEPARATOR + im;
    }

    @Override
    protected String[] deleteSeparate(String s) {
        return s.split(Complex.Z_SEPARATOR);
    }

    @Override
    protected boolean isValid(String s, Validator v) {
        return Validator.isValidComplex(s);
    }

    @Override
    public String clear() {
        return Complex.NULL;
    }

    @Override
    public boolean isNull(String s) throws DataException {
        return new Complex(s).equals(new Complex(Complex.NULL));
    }
}