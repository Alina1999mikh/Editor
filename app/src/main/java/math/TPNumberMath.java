package math;

import exeption.ActionException;
import exeption.DataException;
import model.TPNumber.TPNumber;
import model.TPNumber.TPNumberAlphabets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TPNumberMath implements AbstractMath<TPNumber> {
    TPNumber a;

    public TPNumberMath(TPNumber a) {
        this.a = a;
    }

    @Override
    public TPNumber add(TPNumber b) throws ActionException, DataException {
        TPNumber a = this.a;
        if (isValid(this.a, b)) {
            return (new TPNumber(doScaleNotation(String.valueOf(toDecimal(a) + toDecimal(b)), a.getB(), a.getC()), a.getB(), a.getC()));
        } else throw new ActionException();
    }

    public static TPNumber multiplication(TPNumber a, TPNumber b) throws ActionException, DataException {
        if (isValid(a, b)) {
            return (new TPNumber(doScaleNotation(String.valueOf(toDecimal(a) * toDecimal(b)), a.getB(), a.getC()), a.getB(), a.getC()));
        } else throw new ActionException();
    }

    public static TPNumber subtraction(TPNumber a, TPNumber b) throws ActionException, DataException {
        if (isValid(a, b)) {
            Double decimalA = toDecimal(a);
            Double decimalB = toDecimal(b);
            if (decimalA > decimalB)
                return new TPNumber(doScaleNotation(String.valueOf(decimalA - decimalB), a.getB(), a.getC()), a.getB(), a.getC());
            else
                return new TPNumber("-" + doScaleNotation(String.valueOf(decimalB - decimalA), a.getB(), a.getC()), a.getB(), a.getC());

        } else throw new ActionException();
    }

    public static TPNumber division(TPNumber a, TPNumber b) throws DataException {
        Double decimalA = toDecimal(a);
        Double decimalB = toDecimal(b);
        if (decimalB == 0) throw new DataException("zero division");
        else {
            return new TPNumber(doScaleNotation(String.valueOf(decimalA / decimalB), a.getB(), a.getC()), a.getB(), a.getC());
        }
    }

    public static TPNumber square(TPNumber a) throws DataException, ActionException {
        return multiplication(a, a);
    }

    public static TPNumber inverse(TPNumber a) throws DataException {
        return division(new TPNumber("1", a.getB(), a.getC()), a);
    }

    private static boolean isValid(TPNumber a, TPNumber b) {
        return (a.getB() == b.getB() && a.getC() == b.getC());
    }

    private static String doScaleNotation(String a, int b, int c) {
        String[] s = a.split("\\.");

        String a1 = doBeforeSeparation(Long.parseLong(s[0]), b);
        if (s.length == 2) {
            String a2 = doAfterSeparation(Double.parseDouble("0." + s[1]), b, c);
            return a1 + "." + a2;
        } else return a1;
    }

    private static String doBeforeSeparation(long a, int b) {
        ArrayList<String> list = new ArrayList<>();

        if (a == 0) addToList(list, 0, b);
        else while (a != 0) {
            addToList(list, (int) (a % b), b);
            a = a / b;
        }
        Collections.reverse(list);
        return listToString(list);
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
        return listToString(list);
    }

    private static Double toDecimal(TPNumber t) throws DataException {
        String s = t.getN();
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
        return val;
    }

    private static String listToString(List<String> list) {
        StringBuilder res = new StringBuilder();
        for (String s : list) res.append(s);
        for (int i = res.length() - 1; i >= 0; i--) {
            if (res.charAt(i) == '0' && i != 0) {
                res.deleteCharAt(i);
            } else break;
        }
        return res.toString();
    }
}