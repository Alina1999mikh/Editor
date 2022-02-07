package math;

import exeption.ActionException;
import exeption.DataException;

public interface InterfaceMath<T> {
    T add(T a, T b) throws ActionException, DataException;

    T subtraction(T a, T b) throws DataException, ActionException;

    T multiplication(T a, T b) throws DataException, ActionException;

    T division(T a, T b) throws DataException;

    T square(T a) throws DataException, ActionException;

    T inverse(T a) throws DataException;

    //T equals(T a, T b);
}