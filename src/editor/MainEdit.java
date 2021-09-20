package editor;

import exeption.ActionException;
import exeption.ConstructorException;
import exeption.DataException;
import model.Complex;
import model.Fraction;

import java.util.Scanner;

public class MainEdit {
    public static void edit() throws DataException, ActionException, ConstructorException {
        Scanner in = new Scanner(System.in);
        System.out.println("1-Complex   |   2- Fraction ");
        int m = in.nextInt();
        switch (m) {
            case 1 -> {
                Scanner complexScanner = new Scanner(System.in);
                System.out.println("Input a complex like a,i*b ");
                String str = complexScanner.nextLine();
                Complex complex = new Complex(str);
                while (true) {
                    Scanner in2 = new Scanner(System.in);
                    System.out.println("    1- delete   |     2- add    |   3- addNull   |   5-  add signature   ");
                    int n = in2.nextInt();
                    switch (n) {
                        case 1 -> {
                            System.out.println("___________________");
                            System.out.println("delete");
                            complex = ComplexEditor.deleteNumber(complex);
                            System.out.println("complex: " + complex);
                        }
                        case 2 -> {
                            Scanner in3 = new Scanner(System.in);
                            System.out.println("___________________");
                            System.out.println("add");
                            System.out.print("Input what you want to add ");
                            String inputRe = in3.nextLine();
                            complex = ComplexEditor.addNumber(complex, inputRe);
                            System.out.println(complex);
                        }

                        case 3 -> {
                            System.out.println("___________________");
                            System.out.println("Add null");
                            complex = ComplexEditor.addNull(complex);
                            System.out.println(complex);
                        }

                        case 4 -> {
                            System.out.println("___________________");
                            System.out.println("clear");
                            complex = ComplexEditor.clear();
                            System.out.println(complex);
                        }

                        case 5 -> {
                            System.out.println("___________________");
                            System.out.println("signature");
                            complex = ComplexEditor.addSignature(complex);
                            System.out.println(complex);
                        }

                        default -> {
                            ComplexEditor.complexFinal(complex);
                            System.exit(0);
                        }
                    }
                }
            }

            case 2 -> {
                Scanner in4 = new Scanner(System.in);
                System.out.println("Input fraction\n");
                String input = in4.nextLine();
                input = FractionEditor.editor(input);
                System.out.println("Your fraction " + new Fraction(input));
            }
        }
    }
}