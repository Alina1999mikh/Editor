package model.TPNumber;

import exeption.DataException;
import lombok.Data;
import model.Model;

import java.util.Arrays;
import java.util.Objects;

@Data
public class TPNumber implements Model {
    public static final String SEPARATOR = "\\.";
    public final static String NULL = "0";
    String n;
    int b;
    private char[] alphabet;

    public static String getSEPARATOR() {
        return SEPARATOR;
    }

    int c;

    public TPNumber(String n, int b, int c) throws DataException {
        this.n = n.toUpperCase();
        this.b = b;
        this.c = c;
        if (!isValid(n, b, c)) throw new DataException();
        alphabet = TPNumberAlphabets.getAlphabet(b);
    }

    public TPNumber() {
        this.n = NULL;
        this.b = 10;
        this.c = 0;
    }

    public TPNumber copy() throws DataException {
        return new TPNumber(n, b, c);
    }

    public static boolean isValid(String n, int b, int c) {
        return (b >= 2 && b <= 16 && c >= 0) && isValidN(n, b);
    }

    private static boolean isValidN(String n, int b) {
        String alphabet = Arrays.toString(TPNumberAlphabets.getAlphabet(b));
        n = n.toUpperCase();
        char[] m = n.toCharArray();
        int flagSeparator = 0;
        int flagMinus = 0;
        for (char value : m) {
            if (!alphabet.contains(Character.toString(value))) {
                if ((value == '.' && flagSeparator < 1)) {
                    flagSeparator++;
                } else if (value == '-' && flagMinus < 1) {
                    flagMinus++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public String getTPNumber() {
        return toString();
    }

    public String getShortN() {
        String[] sp = n.split("\\.");
        if (sp.length > 1) {
            if (c == 0)
                return sp[0];

            if (c < sp[1].length())
                return sp[0] + "." + sp[1].substring(0, c);
            else return n;
        } else return n;
    }

    public String getN() {
        return n;
    }

    private int getIndex(char[] alphabet, char charAt) {
        int index;
        for (index = 0; index < alphabet.length; index++) {
            if (alphabet[index] == charAt) break;
        }
        return index;
    }

    @Override
    public String toString() {
        return getShortN() + "," + b + "," + c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TPNumber tpNumber = (TPNumber) o;
        String[] tmpN1 = n.split("\\.");
        String[] tmpN2 = tpNumber.n.split("\\.");
        if (tmpN1[0] == null) tmpN1[0] = String.valueOf(0);
        if (tmpN2[0] == null) tmpN2[0] = String.valueOf(0);
        if (tmpN1.length < 2) {
            if (c != 0 && tmpN2.length != 1) {
                return false;
            } else return Objects.equals(tmpN1[0], tmpN2[0]) && b == tpNumber.b && c == tpNumber.c;
        }

        if (c <= tmpN1[1].length() && c <= tmpN1[0].length()) {
            return b == tpNumber.b && c == tpNumber.c && Objects.equals(tmpN1[0], tmpN2[0]) && Objects.equals(tmpN1[1].substring(0, c), tmpN2[1].substring(0, c));

        } else
            return b == tpNumber.b && c == tpNumber.c && Objects.equals(this.getShortN(), tpNumber.getShortN());
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, b, c);
    }

    public static TPNumber getNULL() throws DataException {
        return new TPNumber(NULL, 10, 0);
    }
//
//    public static TPNumber getNULL() throws DataException {
//        return new TPNumber(NULL, 10, 0);
//    }
}