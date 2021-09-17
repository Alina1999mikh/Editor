package model;

import exeption.DataException;

import java.util.Objects;

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
            System.out.println("1 " + s);
            isNumber(s);
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex1 = (Complex) o;
        return Objects.equals(complex, complex1.complex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(complex);
    }

    @Override
    public String toString() {
        return complex;
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

    public String getComplex() {
        return complex;
    }
}