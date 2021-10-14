package math;

import exeption.ActionException;
import exeption.DataException;
import model.Model;

public interface AbstractMath<T extends Model> {
    T add(T b) throws ActionException, DataException;
}