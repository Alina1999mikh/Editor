package math;

import exeption.ActionException;
import exeption.DataException;
import model.Model;

public interface AbstractMath<T extends Model> {
    T add(T b) throws ActionException, DataException;

    T subtraction(T b) throws DataException, ActionException;

    T multiplication(T b) throws DataException, ActionException;

    T division(T b) throws DataException;

    T square() throws DataException, ActionException;

    T getModel();

    T inverse() throws DataException;
}