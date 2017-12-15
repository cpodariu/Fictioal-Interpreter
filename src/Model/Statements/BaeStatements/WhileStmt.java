package Model.Statements.BaeStatements;

import Exceptions.ExpressionException;
import Exceptions.FileException;
import Exceptions.HeapException;
import Model.Expressions.Exp;
import Model.PrgState;
import Utils.Interfaces.MyIStack;

public class WhileStmt implements IStmt {

	private Exp expression;

	public WhileStmt(Exp expression) {
		this.expression = expression;
	}

	@Override
	public PrgState execute(PrgState state) throws ExpressionException, FileException, HeapException {
		Integer result = expression.eval(state.getSymTable(), state.getHeap());
		MyIStack<IStmt> stack = state.getStack();
		IStmt nextStmt = stack.pop();
		if (result != 0)
		{
			stack.push(nextStmt);
			stack.push(this);
			stack.push(nextStmt);
		}
		return state;
	}

	@Override
	public String toString() {
		return "WhileStmt(" + expression.toString() + ")";
	}
}
