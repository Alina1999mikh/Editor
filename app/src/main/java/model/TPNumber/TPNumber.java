package model.TPNumber;

import exeption.DataException;
import lombok.Data;

import java.util.Arrays;

@Data
public class TPNumber {
    String[] n = new String[2];
    int b;
    int c;

    public TPNumber(String n, int b, int c) throws DataException {
        String[] str = n.split("\\.");

        switch (str.length) {
            case 1 -> {
                this.n[0] = str[0];
                this.n[1] = "0";
            }
            case 2 -> {
                if (n.toCharArray()[0] == '.') {
                    this.n[0] = "0";
                } else {
                    this.n[0] = str[0];
                }
                this.n[1] = str[1];
            }
            default -> throw new DataException();
        }
        this.b = b;
        this.c = c;
        if (!isValid()) throw new DataException();
    }

    public TPNumber copy() {
        return this;
    }

    private boolean isValid() {
        return (b >= 2 && b <= 16 && c >= 0) && isValidN();
    }

    private boolean isValidN() {
        String alphabet = Arrays.toString(TPNumberAlphabets.getAlphabet(b));
        char[] n = (this.n[0] + this.n[1]).toCharArray();
        for (char value : n) {
            if (!alphabet.contains(Character.toString(value))) return false;
        }
        return true;
    }

    public String getTPNumber() {
        return toString();
    }

    public String[] getMassiveN() {
        return n;
    }

    public String getN() {
        if (c == 0) return n[0];
        else if (c > n[1].length()) return n[0] + "." + n[1];
        else return n[0] + "." + n[1].substring(0, c);
    }

    @Override
    public String toString() {
        return getN() + "," + b + "," + c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TPNumber TPNumber = (TPNumber) o;
        return b == TPNumber.b && c == TPNumber.c && Arrays.equals(n, TPNumber.n);
    }
}