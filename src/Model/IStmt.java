package Model;

import Exceptions.ExpressionException;

public interface IStmt {
    String toString();
    PrgState execute(PrgState state) throws ExpressionException;
}
