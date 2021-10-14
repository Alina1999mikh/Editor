package memory;

import exeption.ActionException;
import exeption.DataException;
import lombok.Data;
import math.AbstractMath;
import model.Model;

@Data
public class TMemory<M extends Model, T extends AbstractMath<M>> {
    T fNumber;
    private final T NULL;
    boolean FState;


    public TMemory(T mathNull) {
        fNumber = mathNull;
        NULL = mathNull;
        clear();
    }

    public void store(T math) {
        this.fNumber = math;
        this.FState = true;
    }

    public M add(M a) throws DataException, ActionException {
        return fNumber.add(a);
    }

    public void clear() {
        this.fNumber = NULL;
        this.FState = false;
    }

    @Override
    public String toString() {
        return "TMemory{\n" +
                "fNumber=" + fNumber +
                ",\nFState=" + FState +
                '}';
    }

    public T getfNumber() {
        return fNumber;
    }

    public boolean isFState() {
        return FState;
    }
}