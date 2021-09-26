package model;

import exeption.DataException;
import lombok.Data;

@Data
public class Complex {
    public String complex;

    private static final String Z_SEPARATOR = ",ix";

    public Complex(String s) throws DataException {
        if (checkCorrectInput(s)) {
            complex = s;
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
}