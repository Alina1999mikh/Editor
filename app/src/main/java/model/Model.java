package model;

import exeption.DataException;
import math.InterfaceMath;

public interface Model<T, M extends InterfaceMath<T>> {
    T copy() throws DataException;

    boolean isNULL();

    boolean equals(Object b);

    M toMath() throws DataException;
}