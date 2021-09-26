package math;

import model.TPNumber.TPNumber;
import model.TPNumber.TPNumberAlphabets;

public class TPNumberMath {
    public static void add(TPNumber a, TPNumber b) {
        int ss = a.getB();
        char[] alphabet = TPNumberAlphabets.getAlphabet(ss);
        int a1 = Integer.parseInt(a.getMassiveN()[0]);
        int a2 = Integer.parseInt(a.getMassiveN()[1]);

        int b1 = Integer.parseInt(b.getMassiveN()[0]);
        int b2 = Integer.parseInt(b.getMassiveN()[1]);
        //    1.1  +  1.1
        int answer2 = (a2 + b2);  // 2
        int answer1 = (a1 + b1) + (answer2 / ss);  //2+(1)=3
        StringBuilder an = new StringBuilder();
        if (answer1 / ss >= 1) {
            while (answer1 >= ss) {
                System.out.println("1 " + answer1);

                an.append(alphabet[alphabet.length - 1]);

                answer1 = answer1 - Integer.parseInt(String.valueOf(alphabet[alphabet.length - 1]));
            }
            System.out.println("3 " + answer1);

            an.append(answer1 % ss);
            answer1 = Integer.parseInt(String.valueOf(an));
        }

        answer2 = answer2 % ss;
        System.out.println(a1 + "." + a2);
        System.out.println(b1 + "." + b2);
        System.out.println("_______________");
        System.out.println(answer1 + "." + answer2);
    }
}
