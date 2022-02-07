package processor;

import lombok.Data;
import math.InterfaceMath;

@Data
public class TProc<T extends InterfaceMath> {

    T lopRes;
    T rop;
    private Operation operation;
    private final T NULL;


    public TProc(T mathNull) {
        NULL = mathNull;
        resetProcessor();
    }

    public String getTProc() {
        return lopRes + " " + operation + " " + rop;
    }

    public void resetProcessor() {
        lopRes = NULL;
        rop = NULL;
        resetOperation();
    }

    public void resetOperation() {
        operation = Operation.NONE;
    }
}