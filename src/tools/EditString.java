package tools;

import exeption.ActionException;

public class EditString {
    public static String deleteCharacter(String str, int from, int to) throws ActionException {
        try {
            return str.substring(0, from) + str.substring(to);
        } catch (StringIndexOutOfBoundsException e) {
            throw new ActionException("nothing no delete");
        }
    }

    public static String deleteLastCharacter(String str) throws ActionException {
        return deleteCharacter(str, str.length() - 1, str.length());
    }

    public static String addCharacter(String str, char c) {
        return str + c;
    }

    public static Integer addCharacter(Integer str, Integer c) {
        if (str == null) return c;
        return Integer.parseInt(str + c.toString());
    }
}