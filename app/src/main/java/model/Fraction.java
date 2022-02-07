package model;

import exeption.DataException;
import lombok.Data;
import math.FractionMath;

@Data
public class Fraction implements Model<Fraction, FractionMath> {
    public int a;
    public int b;
    public final static String SEPARATOR = "/";
    public final static String NULL = "0/1";

    public boolean isNULL() {
        return a == 0;
    }

    @Override
    public FractionMath toMath() throws DataException {
        return new FractionMath();
    }

    public Fraction(int a, int b) throws DataException {
        checkDeterminate(b);
        this.a = a;
        this.b = b;
        doSign();
        simplify();
    }

    public Fraction() throws DataException {
        doFractionFromString(NULL);
    }

    public Fraction(Fraction f) throws DataException {
        doFractionFromString(f.getA() + SEPARATOR + f.b);
    }

    private void checkDeterminate(int b) throws DataException {
        if (b == 0) {
            throw new DataException("Denominator cannot be 0");
        }
    }

    public Fraction(String s) throws DataException {
        doFractionFromString(s);
    }

    private void doFractionFromString(String s) throws DataException {
        String[] fraction = s.split("/");
        if (fraction.length > 2) {
            throw new DataException("Invalid input");
        } else {
            this.a = Integer.parseInt(fraction[0]);
            this.b = Integer.parseInt(fraction[1]);
            checkDeterminate(b);
            doSign();
            simplify();
        }
    }

    public void doSign() {
        if (b < 0) {
            a = a * (-1);
            b = b * (-1);
        }
    }

    private void simplify() {
        boolean sign = true;
        int a = this.a;
        if (a < 0) {
            sign = false;
            a = Math.abs(a);
        }
        long limit = Math.min(a, this.b);
        for (long i = 2; i <= limit; i++) {
            if (a % i == 0 && this.b % i == 0) {
                a /= i;
                b /= i;
            }
        }
        if (!sign) this.a = a * (-1);
        else this.a = a;
        if (this.a == 0) this.b = 1;
    }

    @Override
    public String toString() {
        return a + "/" + b;
    }

    public Fraction getFraction() throws DataException {
        return new Fraction(this.toString());
    }

    public static Fraction getNULL() throws DataException {
        return new Fraction(NULL);
    }

    @Override
    public Fraction copy() {
        return this;
    }
}