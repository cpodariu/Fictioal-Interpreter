package Model.Statements;

import Exceptions.ExpressionException;
import Exceptions.FileException;
import Model.PrgState;

public interface IStmt {
    String toString();
    PrgState execute(PrgState state) throws ExpressionException, FileException;
}
