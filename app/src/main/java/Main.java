import editor.MainEdit;
import exeption.ActionException;
import exeption.DataException;
import model.TPNumber.TPNumber;

public class Main {
    public static void main(String[] args) throws DataException, ActionException {
        System.out.println(TPNumber.getSEPARATOR());
        MainEdit.edit();
    }
}