package model.TANumber;


import exeption.ActionException;
import exeption.DataException;
import math.InterfaceMath;
import model.Model;

public class TANumber<T extends Model<T, M>, M extends InterfaceMath<T>> {
    Type type;

    public TANumber(Type type) {
        this.type = type;
    }


    public T add(T a, T b) throws DataException, ActionException {
        return a.toMath().add(a, b);
        //T- type complex/fraction
        //M- type ComplexMath, FractionMath
        //TODO

//        switch (type) {
//            case COMPLEX:
//                return (T) new ComplexMath().add((Complex) a, (Complex) b);
//            case FRACTION:
//                return (T) new FractionMath().add((Fraction) a, (Fraction) b);
//            case TPNUMBER:
//                return (T) new TPNumberMath().add((TPNumber) a, (TPNumber) b);
//            default:
//                return null;
//        }
    }

    public T subtraction(T a, T b) throws DataException, ActionException {
        return a.toMath().subtraction(a, b);
    }

    public T multiplication(T a, T b) throws DataException, ActionException {
        return a.toMath().multiplication(a, b);
    }

    public T division(T a, T b) throws DataException, ActionException {
        return a.toMath().division(a, b);
    }

    public T square(T a) throws DataException, ActionException {
        return a.toMath().square(a);
    }

    public T inverse(T a) throws DataException, ActionException {
        return a.toMath().inverse(a);
    }

    public boolean isNULL(T a) {
        return a.isNULL();
    }

    public T copy(T a) throws DataException {
        return a.copy();
    }
}
