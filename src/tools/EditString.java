package tools;

public class EditString {
    public static String deleteCharacter(String str, int from, int to) {
        return str.substring(0, from) + str.substring(to);
    }

    public static String deleteLastCharacter(String str) {
        return deleteCharacter(str, str.length() - 2, str.length());
    }

    public static String addCharacter(String str, char c) {
        return str + c;
    }

    public static Integer addCharacter(Integer str, Integer c) {
        if(str==null) return c;
        return Integer.parseInt(str.toString() + c.toString());
    }
}
