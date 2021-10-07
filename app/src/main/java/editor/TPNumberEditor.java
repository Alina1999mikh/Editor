package editor;

import exeption.ActionException;
import model.TPNumber.TPNumber;

public class TPNumberEditor extends AbstractEditor {

    @Override
    public String adderSignature(String[] s) throws ActionException {
        if (s.length == 2)
            return "-" + s[0] + TPNumber.SEPARATOR + s[1];
        if (s.length == 1) return "-" + s[0];
        else throw new ActionException();
    }

    @Override
    protected String[] deleteSeparate(String s) {
        return s.split(TPNumber.SEPARATOR);
    }

    @Override
    protected boolean isValid(String s, Validator v) {
        return v.isValidTPNumber(s);
    }

    @Override
    public String clear() {
        return TPNumber.NULL;
    }

    @Override
    public boolean isNull(String s) {
        return s.equals(TPNumber.NULL);
    }
}