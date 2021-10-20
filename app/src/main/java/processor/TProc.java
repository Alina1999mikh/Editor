package processor;

import exeption.ActionException;
import exeption.DataException;
import lombok.Data;
import math.AbstractMath;

@Data
public class TProc<T extends AbstractMath> {

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

    public void TOperation() throws DataException, ActionException {
        switch (operation) {
            case add -> lopRes = (T) lopRes.add(rop.getModel()).toMath();
            case division -> lopRes = (T) lopRes.division(rop.getModel()).toMath();
            case multiplication -> lopRes = (T) lopRes.multiplication(rop.getModel()).toMath();
            case square -> rop = (T) rop.square().toMath();
            case inverse -> rop = (T) rop.inverse().toMath();
            case NONE -> System.out.println("NONE operation");
            default -> throw new DataException("Invalid operation");
        }
    }
}