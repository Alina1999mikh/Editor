package editor;

import exeption.ActionException;
import exeption.ConstructorException;
import exeption.DataException;
import tools.EditString;

import java.io.IOException;
import java.util.Scanner;

public abstract class AbstractEditor {

    public String editor(String s) throws ActionException, IOException {
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
                    s = addNumber(s, c);
                    System.out.println(s);
                }

                case 3 -> {
                    s = addNull(s);
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

    public String addNumber(String s, String add) throws IOException {
        char[] c = add.toCharArray();
        for (char value : c) {
            s = EditString.addCharacter(s, value);
        }
        if (isValid(s)) return s;
        else throw new IOException("Invalid input");
    }

    public String addNull(String f) throws IOException {
        return addNumber(f, "0");
    }

    public String addSignature(String s) throws ActionException {
        String[] d = deleteSeparate(s);
        if (d.length != 2) throw new ActionException("you cant add signature here");
        try {
            return adderSignature(d);
        } catch (NumberFormatException e) {
            throw new ActionException("you cant add this symbol");
        }
    }

    protected abstract String adderSignature(String[] s);

    protected abstract String[] deleteSeparate(String s);

    protected abstract boolean isValid(String s);

    protected abstract String clear();

    protected abstract boolean isNull(String s) throws ConstructorException, DataException;
}