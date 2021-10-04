package editor;

import exeption.DataException;
import model.Fraction;

public class FractionEditor extends AbstractEditor {

    private final static String SEPARATOR = "/";
    private final static String NULL = "0/1";

    public FractionEditor() {
        super();
    }

    @Override
    public String adderSignature(String[] s) {
        return Integer.parseInt(s[0]) * (-1) + SEPARATOR + Integer.parseInt(s[1]);
    }

    @Override
    public String[] deleteSeparate(String s) {
        return s.split(SEPARATOR);
    }

    @Override
    protected boolean isValid(String s) {
        try {
            String[] mass = s.split(SEPARATOR);
            if (mass.length > 2) return false;
            for (String value : mass) {
                char[] c = value.toCharArray();
                for (int i = 0; i < c.length; i++) {
                    System.out.println(c[i]);
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

    @Override
    protected boolean isValid(String s, int b, int c) {
        return isValid(s);
    }

    @Override
    public String clear() {
        return NULL;
    }

    @Override
    public boolean isNull(String s) throws DataException {
        return new Fraction(s).equals(new Fraction(NULL));
    }
}