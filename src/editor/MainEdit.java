package editor;

import exeption.ActionException;
import exeption.dataException;
import model.Complex;

import java.util.Scanner;

public class MainEdit {
    public static Complex edit() throws dataException, ActionException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a complex like a,i*b ");
        String str = in.nextLine();
        Complex complex = new Complex(str);
        while (true) {
            Scanner in2 = new Scanner(System.in);
            System.out.println("1- delete   | 2-add num re  |3-clear   |4- addNull   im |5- add num im   | 7-addNullRe");
            int n = in2.nextInt();
            switch (n) {
                case 1:
                    System.out.println("___________________");
                    System.out.println("delete");
                     complex=StringEditor.deleteNumber(complex);
                    System.out.println(complex);
                    break;
                case 2:
                    Scanner in3 = new Scanner(System.in);
                    System.out.println("___________________");
                    System.out.println("add re");
                    System.out.print("Input what you want to add at re");
                    String inputRe = in3.nextLine();
                    complex=StringEditor.addNumberRe(complex, inputRe);
                    System.out.println(complex);
                    break;
                case 5:
                    Scanner in4 = new Scanner(System.in);
                    System.out.println("___________________");
                    System.out.println("add im");
                    System.out.print("Input what you want to add to im");
                    String inputIm = in4.nextLine();
                    complex=StringEditor.addNumberIm(complex, inputIm);
                    System.out.println(complex);
                    break;
                case 3:
                    Scanner in5 = new Scanner(System.in);
                    System.out.println("___________________");
                    System.out.println("clear");
                    String input = in5.nextLine();
                    complex=StringEditor.clear();
                    System.out.println(complex);
                    break;
                case 4:
                    System.out.println("___________________");
                    System.out.println("add null Im");
                    complex=StringEditor.addNullIm(complex);
                    System.out.println(complex);
                    break;
                case 7:
                    System.out.println("___________________");
                    System.out.println("add null Re");
                    complex=StringEditor.addNullRe(complex);
                    System.out.println(complex);
                    break;
                default: System.exit(0);


            }
        }
    }
}
