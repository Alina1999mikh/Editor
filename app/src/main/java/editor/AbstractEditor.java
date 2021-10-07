package editor;

import exeption.ActionException;
import exeption.DataException;
import tools.EditString;

import java.util.Scanner;

public abstract class AbstractEditor {

    public String editor(String s, Validator v) throws ActionException, DataException {
        Scanner inMenu = new Scanner(System.in);

        while (true) {
            System.out.println("    1- delete   |     2- add    |   3- addNull   |   4-  add signature  |   5-clear ");
            int n = inMenu.nextInt();
            switch (n) {
                case 1 -> {
                    s = deleteNumber(s);
                    System.out.println(s);
                }

                case 2 -> {
                    Scanner add = new Scanner(System.in);
                    System.out.print("Input what you want to add");
                    String c = add.nextLine();
                    s = addNumber(s, c, v);
                    System.out.println(s);
                }

                case 3 -> {
                    s = addNull(s, v);
                    System.out.println(s);
                }

                case 4 -> {
                    s = addSignature(s);
                    System.out.println(s);
                }

                case 5 -> {
                    s = clear();
                    System.out.println(s);
                }

                default -> {
                    System.out.println(s);
                    return s;
                }
            }
        }
    }

    public String deleteNumber(String s) throws ActionException {
        return EditString.deleteLastCharacter(s);
    }

    public String addNumber(String s, String add, Validator v) throws DataException {
        char[] c = add.toCharArray();
        for (char value : c) {
            s = EditString.addCharacter(s, value);
        }
        if (isValid(s, v)) return s;
        else throw new DataException("Invalid input");
    }

    public String addNull(String s, Validator v) throws DataException {
        return addNumber(s, "0", v);
    }

    public String addSignature(String s) throws ActionException {
        String[] d = deleteSeparate(s);
        if (d.length > 2) throw new ActionException("you cant add signature here");
        try {
            return adderSignature(d);
        } catch (NumberFormatException e) {
            throw new ActionException("you cant add this symbol");
        }
    }

    protected abstract String adderSignature(String[] s) throws ActionException;

    protected abstract String[] deleteSeparate(String s) throws ActionException;

    protected abstract boolean isValid(String s, Validator v);

    protected abstract String clear();

    protected abstract boolean isNull(String s) throws DataException;
}