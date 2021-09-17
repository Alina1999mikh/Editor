package editor;

import exeption.ActionException;
import exeption.DataException;
import model.Complex;
import tools.EditString;

public class StringEditor {
    private static final String FRACTIONAL_SEPARATOR = ".";
    private static final String Z_SEPARATOR = ",ix";
    private static final String NULL = "0,ix0";


    public static Complex clear() throws DataException {
        return new Complex(NULL);
    }

    public static Complex deleteNumber(Complex complex) throws DataException {
        System.out.println("complex: " + complex.toString());
        return new Complex(EditString.deleteLastCharacter(complex.getComplex()));
    }

    public static Complex addNumber(Complex complex, String num) throws DataException {
        char[] c = num.toCharArray();
        String str = complex.getComplex();
        for (char value : c) {
            str = EditString.addCharacter(str, value);
        }
        return new Complex(str);
    }

    public static void complexFinal(Complex complex) throws DataException {
        String s = complex.getComplex();
        if (s.split(Z_SEPARATOR).length != 2 || (s.split("i").length != 2 ||
                s.split("x").length != 2) || s.split(",").length != 2)
            throw new DataException("bad input " + s);
        else {
            String[] s2 = complex.getComplex().split(Z_SEPARATOR);
            System.out.println(Double.parseDouble(s2[0]) + ",ix" + Double.parseDouble(s2[1]));
        }
    }

    public static boolean isNull(Complex complex) throws DataException {
        return (complex.equals(new Complex(NULL)));
    }

    public static Complex addSignature(Complex complex) throws DataException, ActionException {
        String[] str = complex.getComplex().split(Z_SEPARATOR);
        if (str.length != 2) throw new ActionException("you cant add signature at not whole complex");

        try {
            double re = Double.parseDouble(str[0]) * (-1);
            double im = Double.parseDouble(str[1]) * (-1);
            if (im % 1 == 0 && re % 1 == 0) return new Complex((int) re + Z_SEPARATOR + (int) im);
            else if (im % 1 == 0) return new Complex(re + Z_SEPARATOR + (int) im);
            else if (re % 1 == 0) return new Complex((int) re + Z_SEPARATOR + im);
            else return new Complex(re + Z_SEPARATOR + im);
        } catch (NumberFormatException e) {
            throw new ActionException("you cant add signature at not whole complex " + complex.complex);
        }
    }

    public static Complex addNull(Complex complex) throws DataException {
        return addNumber(complex, "0");
    }
}