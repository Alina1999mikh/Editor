package model;

import exeption.dataException;
import tools.EditString;

import java.util.Objects;

public class Complex {
    public String complex;
    public Integer re;
    public Integer im;

    public Complex(String s) throws dataException {
        String[] massStr = s.split(","); /// 5,i*6
        try {
            this.re = Integer.parseInt(String.valueOf(massStr[0]));
        } catch (NumberFormatException e) {
            throw new dataException(massStr[0]);
        }
        if (massStr[1].toCharArray()[0] != '-')
            this.im = Integer.parseInt(EditString.deleteCharacter(massStr[1], 0, 2));
        else this.im = Integer.parseInt("-" + EditString.deleteCharacter(massStr[1], 0, 3));
        complex = s;
    }

    public Complex(int re, int im) {
        this.re = re;
        this.im = im;
    }

    public Complex(Integer re, Integer im) {
        this.re = re;
        this.im = im;
    }

    public int getRe() {
        return re;
    }

    public int getIm() {
        return im;
    }

    @Override
    public String toString() {
        if (im == null) {
            if (re == null) return ",";
            else return re + ",";
        } else if (re == null) return "," + im;
        else if (im < 0)
            return re + "," + "-i" + "*" + im * (-1);
        else return re + "," + "i" + "*" + im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Objects.equals(re, complex.re) && Objects.equals(im, complex.im);
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}
