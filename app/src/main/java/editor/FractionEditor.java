package editor;

import exeption.DataException;
import model.Fraction;

public class FractionEditor extends AbstractEditor {

    public final static String SEPARATOR = "/";
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
    protected boolean isValid(String s, Validator v) {
        return Validator.isValidFraction(s);
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