import exeption.DataException;
import math.TPNumberMath;
import model.TPNumber.TPNumber;

public class Main {
    public static void main(String[] args) throws DataException {
        TPNumberMath.add(new TPNumber("9.9", 10, 2), new TPNumber("9.9", 10, 2));
        //  MainEdit.edit();
    }
}