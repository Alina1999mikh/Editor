package model;

import exeption.DataException;
import lombok.Data;

@Data
public class Fraction {
    public int a;
    public int b;

    public Fraction(int a, int b) throws DataException {
        checkDeterminate(b);
        this.a = a;
        this.b = b;
        doSign();
        simplify();
    }

    private void checkDeterminate(int b) throws DataException {
        if (b == 0) {
            throw new DataException("Denominator cannot be 0");
        }
    }

    public Fraction(String f) throws DataException {
        String[] fraction = f.split("/");
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
        long limit = Math.min(this.a, this.b);

        for (long i = 2; i <= limit; i++) {
            if (this.a % i == 0 && this.b % i == 0) {
                this.a /= i;
                this.b /= i;
            }
        }
        if (this.a == 0) this.b = 1;
    }

    @Override
    public String toString() {
        return a + "/" + b;
    }
}