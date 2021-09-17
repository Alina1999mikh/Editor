package editor;

import exeption.ActionException;
import exeption.DataException;
import model.Complex;

import java.util.Scanner;

public class MainEdit {
    public static void edit() throws DataException, ActionException {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a complex like a,i*b ");
        String str = in.nextLine();
        Complex complex = new Complex(str);
        while (true) {
            Scanner in2 = new Scanner(System.in);
            System.out.println("    1- delete   |     2- add    |   3- addNull   |   5-  add signature   ");
            int n = in2.nextInt();
            switch (n) {
                case 1 -> {
                    System.out.println("___________________");
                    System.out.println("delete");
                    complex = StringEditor.deleteNumber(complex);
                    System.out.println(complex);
                }
                case 2 -> {
                    Scanner in3 = new Scanner(System.in);
                    System.out.println("___________________");
                    System.out.println("add");
                    System.out.print("Input what you want to add at re");
                    String inputRe = in3.nextLine();
                    complex = StringEditor.addNumber(complex, inputRe);
                    System.out.println(complex);
                }

                case 3 -> {
                    System.out.println("___________________");
                    System.out.println("Add null");
                    complex = StringEditor.addNull(complex);
                    System.out.println(complex);
                }

                case 4 -> {
                    System.out.println("___________________");
                    System.out.println("clear");
                    complex = StringEditor.clear();
                    System.out.println(complex);
                }

                case 5 -> {
                    System.out.println("___________________");
                    System.out.println("signature");
                    complex = StringEditor.addSignature(complex);
                    System.out.println(complex);
                }

                default -> {
                    StringEditor.complexFinal(complex);
                    System.exit(0);
                }
            }
        }
    }
}