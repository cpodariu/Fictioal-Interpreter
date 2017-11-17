package Model;

import Exceptions.ExpressionException;
import Exceptions.FileException;

public interface IStmt {
    String toString();
    PrgState execute(PrgState state) throws ExpressionException, FileException;
}
