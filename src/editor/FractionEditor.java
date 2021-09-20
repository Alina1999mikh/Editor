package editor;

import exeption.ActionException;
import exeption.ConstructorException;
import model.Fraction;
import tools.EditString;

import java.util.Scanner;

public class FractionEditor extends AbstractEditor {

    private final static String SEPARATOR = "/";
    private final static String NULL = "0/1";

    public static String editor(String input) throws ActionException {
        Scanner inMenu = new Scanner(System.in);

        while (true) {
            System.out.println("    1- delete   |     2- add    |   3- addNull   |   4-  add signature  |   5-clear ");
            int n = inMenu.nextInt();
            switch (n) {
                case 1 -> {
                    input = deleteNumber(input);
                    System.out.println(input);
                }

                case 2 -> {
                    Scanner add = new Scanner(System.in);
                    System.out.print("Input what you want to add");
                    String c = add.nextLine();
                    input = addNumber(input, c);
                    System.out.println(input);
                }

                case 3 -> {
                    input = addNull(input);
                    System.out.println(input);
                }

                case 4 -> {
                    input = addSign(input);
                    System.out.println(input);
                }

                case 5 -> {
                    input = clear();
                    System.out.println(input);
                }

                default -> {
                    System.out.println(input);
                    return input;
                }
            }
        }
    }

    public static String addSign(String f) throws ActionException {
        String[] str = f.split(SEPARATOR);
        if (str.length != 2) throw new ActionException("you cant add signature here");

        try {
            return Integer.parseInt(str[0]) * (-1) + SEPARATOR + Integer.parseInt(str[1]);
        } catch (NumberFormatException e) {
            throw new ActionException("you cant add signature here ");
        }
    }

    public static String addNumber(String f, String s) throws ActionException {
        try {
            char[] c = s.toCharArray();
            for (char value : c) {
                f = EditString.addCharacter(f, value);
            }
            String[] mass = f.split(SEPARATOR);
            for (String value : mass) {
                Integer.parseInt(value); //check valid
            }
            return f;
        } catch (NumberFormatException e) {
            throw new ActionException("you cant add this number here ");
        }
    }

    public static String addNull(String f) throws ActionException {
        return addNumber(f, "0");
    }

    public static String clear() {
        return NULL;
    }

    public static String deleteNumber(String f) throws ActionException {
        return EditString.deleteLastCharacter(f);
    }

    public static boolean isNull(Fraction f) throws ConstructorException {
        System.out.println(new Fraction(NULL));
        return f.equals(new Fraction(NULL));
    }
}