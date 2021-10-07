package memory;

import exeption.ActionException;
import exeption.DataException;
import lombok.Data;
import math.AbstractMath;

@Data
public class TMemory<T extends AbstractMath<?>> {
    T fNumber;
    boolean FState;

    public TMemory(T fraction) {
        this.fNumber = fraction;
        FState = false;
    }

    public void store(T e) {
        this.fNumber = e;
        this.FState = true;
    }

    public T add(T e) throws DataException, ActionException {
        System.out.println(e.add(fNumber));
        return (T) e.add(fNumber);
    }

    public T clear() throws DataException, ActionException {
        fNumber = (T) fNumber.getNull();
    }
}
