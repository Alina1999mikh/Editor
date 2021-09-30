import exeption.ActionException;
import exeption.DataException;
import math.TPNumberMath;
import model.TPNumber.TPNumber;

public class Main {
    public static void main(String[] args) throws DataException, ActionException {
        TPNumber t = new TPNumber("A67.B2", 16, 2);
        TPNumber t2 = new TPNumber("C5.11", 16, 2);

        System.out.println(TPNumberMath.add(t, t2));

    }
}