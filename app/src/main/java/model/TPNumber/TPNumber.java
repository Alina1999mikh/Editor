package model.TPNumber;

import exeption.DataException;
import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

@Data
public class TPNumber {
    private static final String SEPARATOR = "\\.";
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
        if (!isValid(n)) throw new DataException();
        alphabet = TPNumberAlphabets.getAlphabet(b);
    }

    public TPNumber copy() throws DataException {
        return new TPNumber(n, b, c);
    }

    private boolean isValid(String n) {
        return (b >= 2 && b <= 16 && c >= 0) && isValidN(n);
    }

    private boolean isValidN(String n) {
        String alphabet = Arrays.toString(TPNumberAlphabets.getAlphabet(b));
        n = n.toUpperCase();
        char[] m = n.toCharArray();
        int flag = 0;
        for (char value : m) {
            if (!alphabet.contains(Character.toString(value))) {
                if ((value == '.' && flag < 2) || value == '-') {
                    flag++;
                } else {
                    System.out.println(value);
                    return false;
                }
            }
        }
        return true;
    }

    public String getTPNumber() {
        return toString();
    }

    public String getN() {
        StringBuilder res = new StringBuilder();
        String[] sp = n.split(SEPARATOR);
        if (sp.length > 1) {
            if (c < sp[1].length())
                return sp[0] + "." + sp[1].substring(0, c);
            else return sp[0] + "." + sp[1];
        } else return sp[0];
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
        return getN() + "," + b + "," + c;
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
                System.out.println("1");
                return false;
            } else return Objects.equals(tmpN1[0], tmpN2[0]) && b == tpNumber.b && c == tpNumber.c;
        }

        if (c <= tmpN1[1].length() && c <= tmpN1[0].length()) {
            System.out.println("2");
            return b == tpNumber.b && c == tpNumber.c && Objects.equals(tmpN1[0], tmpN2[0]) && Objects.equals(tmpN1[1].substring(0, c), tmpN2[1].substring(0, c));

        } else
            return b == tpNumber.b && c == tpNumber.c && Objects.equals(this.getN(), tpNumber.getN());
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, b, c);
    }
}