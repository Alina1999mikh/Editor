package math;

import exeption.ActionException;
import exeption.DataException;

public abstract class AbstractMath<T> {
    public abstract T add(T b) throws ActionException, DataException;

    public abstract T getNull() throws DataException;
}