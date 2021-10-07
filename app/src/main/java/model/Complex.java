package model;

import exeption.DataException;
import lombok.Data;

@Data
public class Complex {
    public String complex;

    public static final String FRACTIONAL_SEPARATOR = ".";
    public static final String Z_SEPARATOR = ",ix";
    public static final String NULL = "0,ix0";

    public Complex(String s) throws DataException {
        if (checkCorrectInput(s)) {
            complex = s;
        }
    }

    public Complex(int a, int b) throws DataException {
        String tmp = a + Z_SEPARATOR + b;
        if (checkCorrectInput(tmp)) {
            complex = tmp;
        }
    }

    private boolean checkCorrectInput(String s) throws DataException {
        if (s.split(Z_SEPARATOR).length > 2 || (s.split("i").length > 2 ||
                s.split("x").length > 2) || s.split(",").length > 2 || !isNumber(s))
            throw new DataException("bad input " + s);
        else {
            isNumber(s);
            return true;
        }
    }

    public static boolean isNumber(String s) throws DataException {
        String[] mass;

        if (s.contains(Z_SEPARATOR)) {
            mass = s.split(Z_SEPARATOR);
        } else if (s.contains("i")) mass = s.split(",i");
        else mass = s.split(",");

        if (mass.length <= 2) {
            try {
                for (String value : mass) {
                    if (!value.equals("-")) Double.parseDouble(value);
                }
                return true;
            } catch (NumberFormatException e) {
                throw new DataException(s);
            }
        } else {
            throw new DataException("bad input " + s + " ");
        }
    }

    public int getWholePart() {
        return Integer.parseInt(complex.split(Z_SEPARATOR)[0]);
    }

    public int getImaginaryPart() {
        return Integer.parseInt(complex.split(Z_SEPARATOR)[1]);
    }
}