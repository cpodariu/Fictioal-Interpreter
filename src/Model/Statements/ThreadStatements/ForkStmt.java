package Model.Statements.ThreadStatements;

import Exceptions.ExpressionException;
import Exceptions.FileException;
import Exceptions.HeapException;
import Model.PrgState;
import Model.Statements.BaeStatements.IStmt;

public class ForkStmt implements IStmt{


	@Override
	public PrgState execute(PrgState state) throws ExpressionException, FileException, HeapException {
		return null;
	}
}
