package editor;

import model.TPNumber.TPNumber;

public class Validator {
    int b; //for TPNumber
    int c; //for TPNumber

    public Validator(int b, int c) {
        this.b = b;
        this.c = c;
    }

    public Validator() {
    }

    public static boolean isValidFraction(String s) {
        try {
            String[] mass = s.split(FractionEditor.SEPARATOR);
            if (mass.length > 2) return false;
            for (String value : mass) {
                char[] c = value.toCharArray();
                for (int i = 0; i < c.length; i++) {
                    try {
                        Integer.parseInt(String.valueOf(c[i]));
                    } catch (NumberFormatException e) {
                        return i == 0 && c[i] == '-';
                    }
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidComplex(String s) {
        return true;
    }

    public boolean isValidTPNumber(String s) {
        try {
            return TPNumber.isValid(s, b, c);
        } catch (NullPointerException e) {
            throw new NullPointerException("b or c is null!");
        }
    }
}