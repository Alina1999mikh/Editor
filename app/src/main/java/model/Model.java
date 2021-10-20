package model;

import exeption.DataException;

public interface Model<T> {
     public T toMath() throws DataException;
}
