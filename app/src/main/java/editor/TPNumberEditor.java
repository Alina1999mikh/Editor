package editor;

import exeption.ActionException;

public class TPNumberEditor extends AbstractEditor {
    private static final String SEPARATOR = "\\.";
    private final static String NULL = "0";


    @Override
    public String adderSignature(String[] s) throws ActionException {
        if (s.length == 2)
            return "-" + s[0] + SEPARATOR + s[1];
        if (s.length == 1) return "-" + s[0];
        else throw new ActionException();
    }

    @Override
    protected String[] deleteSeparate(String s) {
        return s.split(SEPARATOR);
    }

    @Override
    protected boolean isValid(String s, Validator v) {
        return v.isValidTPNumber(s);
    }

    @Override
    public String clear() {
        return NULL;
    }

    @Override
    public boolean isNull(String s) {
        return s.equals(NULL);
    }
}