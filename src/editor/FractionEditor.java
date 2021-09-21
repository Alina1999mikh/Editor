package editor;

import exeption.ConstructorException;
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
            for (String value : mass) {
                System.out.println(value);
                Integer.parseInt(value); //check valid
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String clear() {
        return NULL;
    }

    @Override
    public boolean isNull(String s) throws ConstructorException {
        return new Fraction(s).equals(new Fraction(NULL));
    }
}