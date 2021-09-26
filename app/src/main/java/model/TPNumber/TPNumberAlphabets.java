package model.TPNumber;

public class TPNumberAlphabets {

    public static char[] getAlphabet(int ss) {
        String alphabet = "0123456789ABCDEF";
        return alphabet.substring(0, ss).toCharArray();
    }
}
