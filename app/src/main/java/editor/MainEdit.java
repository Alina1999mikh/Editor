package editor;

import exeption.ActionException;
import exeption.DataException;
import model.Complex;
import model.Fraction;
import model.TPNumber.TPNumber;

import java.util.Scanner;

public class MainEdit {
    public static void edit() throws DataException, ActionException {
        Scanner in = new Scanner(System.in);
        System.out.println("1-Complex   |   2- Fraction    |    3-TPNumber");
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

            case 3 -> {
                Scanner TPNumberScannerA = new Scanner(System.in);
                Scanner TPNumberScannerB = new Scanner(System.in);
                Scanner TPNumberScannerC = new Scanner(System.in);

                System.out.println("Input a, b, c ");
                String a = TPNumberScannerA.nextLine();
                int b = TPNumberScannerB.nextInt();
                int c = TPNumberScannerC.nextInt();
                TPNumberEditor e = new TPNumberEditor();
                a = e.editor(a, b, c);
                System.out.println("Your TPNumber " + new TPNumber(a, b, c));
            }
        }
    }
}