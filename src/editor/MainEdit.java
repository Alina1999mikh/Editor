package editor;

import exeption.ActionException;
import exeption.ConstructorException;
import exeption.DataException;
import model.Complex;
import model.Fraction;

import java.io.IOException;
import java.util.Scanner;

public class MainEdit {
    public static void edit() throws DataException, ActionException, ConstructorException, IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("1-Complex   |   2- Fraction ");
        int m = in.nextInt();
        switch (m) {
            case 1 -> {
                Scanner complexScanner = new Scanner(System.in);
                System.out.println("Input a complex like a,i*b ");
                String input = complexScanner.nextLine();
                ComplexEditor e = new ComplexEditor();
                input = e.editor(input);
                System.out.println("Your complex " + new Complex(input));

            }

            case 2 -> {
                Scanner fractionScanner = new Scanner(System.in);
                System.out.println("Input fraction\n");
                String input = fractionScanner.nextLine();
                FractionEditor e = new FractionEditor();
                input = e.editor(input);
                System.out.println("Your fraction " + new Fraction(input));
            }
        }
    }
}