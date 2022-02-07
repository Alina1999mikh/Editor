package math;

import exeption.ActionException;
import exeption.DataException;
import model.TPNumber.TPNumber;
import model.TPNumber.TPNumberAlphabets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TPNumberMath extends TPNumber implements InterfaceMath<TPNumber> {

    @Override
    public TPNumber add(TPNumber a, TPNumber b) throws ActionException, DataException {
        if (isValid(a, b)) {
            return (new TPNumber(doScaleNotation(String.valueOf(toDecimal(a) + toDecimal(b)), a.getB(), a.getC()), a.getB(), a.getC()));
        } else throw new ActionException();
    }

    @Override
    public TPNumber multiplication(TPNumber a, TPNumber b) throws DataException, ActionException {
        if (isValid(a, b)) {
            return (new TPNumber(doScaleNotation(String.valueOf(toDecimal(a) * toDecimal(b)), a.getB(), a.getC()), a.getB(), a.getC()));
        } else throw new ActionException();
    }

    @Override
    public TPNumber subtraction(TPNumber a, TPNumber b) throws ActionException, DataException {
        TPNumber bMinis = b.copy();
        bMinis.setN(b.getMinus());
        return add(a, bMinis);
//        if (isValid(a, b)) {
//            Double decimalA;
//            Double decimalB;
//            if (a.getB() != 10) decimalA = toDecimal(a);
//             else decimalA = Double.parseDouble(a.getN());
//            if (b.getB() != 10) decimalB = toDecimal(b);
//             else decimalB = Double.parseDouble(b.getN());
//             System.out.println("A= "+decimalA+" b = "+ decimalB);
//            if (decimalA > decimalB)
//                return new TPNumber(doScaleNotation(String.valueOf(decimalA - decimalB), a.getB(), a.getC()), a.getB(), a.getC());
//            else
//                return new TPNumber("-" + doScaleNotation(String.valueOf(decimalB - decimalA), a.getB(), a.getC()), a.getB(), a.getC());
//        } else throw new ActionException();
    }

    @Override
    public TPNumber division(TPNumber a, TPNumber b) throws DataException {
        Double decimalA = toDecimal(a);
        Double decimalB = toDecimal(b);
        if (decimalB == 0) throw new DataException("zero division");
        else {
            return new TPNumber(doScaleNotation(String.valueOf(decimalA / decimalB), a.getB(), a.getC()), a.getB(), a.getC());
        }
    }

    @Override
    public TPNumber square(TPNumber a) throws DataException, ActionException {
        return multiplication(a, a);
    }

    @Override
    public TPNumber inverse(TPNumber a) throws DataException {
        TPNumber one = new TPNumber("1", a.getB(), a.getC());
        return division(one, a);
    }

    private static boolean isValid(TPNumber a, TPNumber b) {
        return (a.getB() == b.getB() && a.getC() == b.getC());
    }

    private static String doScaleNotation(String a, int b, int c) {
        if (b == 10) {
            return a;
        } else {
            String[] s = a.split("\\.");

            String a1 = doBeforeSeparation(Long.parseLong(s[0]), b);
            if (s.length == 2) {
                String a2 = doAfterSeparation(Double.parseDouble("0." + s[1]), b, c);
                return a1 + "." + a2;
            } else return a1;
        }
    }

    private static String doBeforeSeparation(long a, int b) {
        boolean sign = true;
        if (a < 0) {
            sign = false;
            a = Math.abs(a);
        }
        ArrayList<String> list = new ArrayList<>();
        if (a == 0) addToList(list, 0, b);
        else
            while (a != 0) {
                addToList(list, (int) (a % b), b);
                a = a / b;
            }
        Collections.reverse(list);
        if (!sign) return "-" + beforeSeparationToString(list);
        else return beforeSeparationToString(list);
    }

    private static void addToList(ArrayList<String> list, int add, int b) {
        if (add > 9) list.add(String.valueOf(TPNumberAlphabets.getAlphabet(b)[add]));
        else list.add(String.valueOf(add));
    }

    private static String doAfterSeparation(Double a, int b, int c) {
        String[] res;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            res = String.valueOf(a * b).split("\\.");
            a = Double.parseDouble("0." + res[1]);
            addToList(list, Integer.parseInt(res[0]), b);
            if (Long.parseLong(res[1]) == 0) {
                break;
            }
        }
        return afterSeparationToString(list);
    }

    private static Double toDecimal(TPNumber t) throws DataException {
        if (t.getB() == 10) return Double.valueOf(t.getN());

        else {
            boolean sign = true; // +
            String s = t.getN();
            if (s.toCharArray()[0] == '-') {
                sign = false;
                s = s.substring(1);
            }
            String digits = String.valueOf(TPNumberAlphabets.getAlphabet(t.getB()));
            s = s.toUpperCase();
            String[] part = s.split("\\.");
            double val = 0;
            if (part.length == 2) {
                String partAll = part[0] + part[1];
                for (int i = part[0].length() - 1, j = 0; i >= part[1].length() * (-1); i--, j++) {
                    int d = digits.indexOf(partAll.charAt(j));
                    val = val + d * Math.pow(t.getB(), i);
                }
            } else {
                if (part.length == 1) {
                    for (int i = part[0].length() - 1, j = 0; i >= 0; i--, j++) {
                        int d = digits.indexOf(part[0].charAt(j));
                        val = val + d * Math.pow(t.getB(), i);
                    }
                } else throw new DataException();
            }
            if (sign) return val;
            else return Double.valueOf("-" + val);
        }
    }

    private static String afterSeparationToString(List<String> list) {
        StringBuilder res = new StringBuilder();
        for (String s : list) res.append(s);
        for (int i = res.length() - 1; i >= 0; i--) {
            if (res.charAt(i) == '0' && i != 0) {
                res.deleteCharAt(i);
            } else break;
        }
        return res.toString();
    }

    private static String beforeSeparationToString(List<String> list) {
        StringBuilder res = new StringBuilder();
        for (String s : list) res.append(s);
        return res.toString();
    }
}