package editor;

import exeption.ActionException;
import exeption.dataException;
import model.Complex;
import tools.EditString;

import java.util.Scanner;

public class StringEditor  {
    private static final String FRACTIONAL_SEPARATOR = ".";
    private static final String Z_SEPARATOR = ",";
    private static final String NULL = "0,i*0";

    public static Complex clear() throws dataException {
        return new Complex(NULL);
    }

    public static Complex deleteNumber(Complex complex) throws dataException, ActionException {

        System.out.println(complex.complex);
        if (complex.im != null) { //-7, 456
            if (Math.abs(complex.im) < 10) {
                return new Complex(complex.re, null);
            } else return new Complex(complex.re, deleteLastSymbol(complex.im));
        } else if (complex.re != null) {  // -478,null
            return new Complex(deleteLastSymbol(complex.re), complex.im);
        } else throw new ActionException("nothing to delete");
        //TODO проверка через кейс не оставил ли он нуллы
    }

    private static Integer deleteLastSymbol(Integer complex) throws dataException {
        System.out.println("re= " + complex);
        char[] str = complex.toString().toCharArray(); // -7
        char[] tmp = new char[str.length - 1]; // na  1 menshe
        if (tmp.length == 0) return null;

        System.arraycopy(str, 0, tmp, 0, str.length - 1);
        System.out.println("c = " + String.valueOf(tmp));
        return parseInt(String.valueOf(tmp));
    }

    public static Integer parseInt(String c) throws dataException {
        System.out.println("h c = " + c);
        try {
            return Integer.parseInt(String.valueOf(c));
        } catch (NumberFormatException e) {
            throw new dataException(c);
        }
    }

    public static boolean isNull(Complex complex) {
        return (complex.toString().equals(NULL));
    }

    public static Complex addSignature(Complex complex) throws dataException {

        return new Complex(complex.re * (-1), complex.im * (-1));
    }

    public static Complex addNumberRe(Complex complex, String number) throws dataException, ActionException {
        Integer c = parseInt(number); //56

        if (c < 0 && complex.re != null) {
            throw new ActionException("cant add negative number " + number + " to " + complex.re);
        } else {
            return new Complex(addNumber(complex.re, c), complex.im);
        }
//        if (parseInt(c)) {
//            if (c[0] == '-')
//                //объявление при пустом im, но полной re
//                if (!this.im.equals("")) {
//                    if (complex.contains(",")) {
//                        im = Arrays.toString(c);
//                    }
//                }
//            this.im = this.im + Arrays.toString(c);
//        } else throw new dataException(number);
    }

    public static Complex addNumberIm(Complex complex, String number) throws dataException, ActionException {
        Integer c = parseInt(number); //56

        if (c < 0 && complex.im != null) {
            throw new ActionException("cant add negative number " + number + " to " + complex.im);
        } else {
            return new Complex(complex.re, addNumber(complex.im, c));
        }
//        if (parseInt(c)) {
//            if (c[0] == '-')
//                //объявление при пустом im, но полной re
//                if (!this.im.equals("")) {
//                    if (complex.contains(",")) {
//                        im = Arrays.toString(c);
//                    }
//                }
//            this.im = this.im + Arrays.toString(c);
//        } else throw new dataException(number);
    }

    private static Integer addNumber(Integer a, Integer c) {
        return EditString.addCharacter(a, c);
    }

    public static Complex addNullRe(Complex complex) throws dataException {
        return new Complex(addNumber(complex.re, 0), complex.im);
    }

    public static Complex addNullIm(Complex complex) throws dataException {
        return new Complex(complex.re, addNumber(complex.im, 0));
    }

    public static Complex clear(Complex clear) throws dataException {
        return new Complex(NULL);
    }
}
