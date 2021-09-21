package model;

import exeption.ConstructorException;

import java.util.Objects;

public class Rnumber {
    Double n;
    int b;
    int c;

    public Rnumber(double n, int b, int c) throws ConstructorException {
        this.b = b;
        this.c = c;
//        this.n = BigDecimal.valueOf(n)
//                .setScale(c, RoundingMode.HALF_UP)
//                .doubleValue();
//        Double.valueOf(A78)
        if (!isValid()) throw new ConstructorException();
    }


    private boolean isValid() {
        return (b >= 2 && b <= 16 && c >= 0);
    }

    public String getRnumber() {
        return toString();
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return n + "," + b + "," + c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rnumber rnumber = (Rnumber) o;
        return Double.compare(rnumber.n, n) == 0 && b == rnumber.b && c == rnumber.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, b, c);
    }
}
