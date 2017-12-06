package Model.Statements.HeapStatements;

import Exceptions.ExpressionException;
import Exceptions.FileException;
import Model.Expressions.ConstExp;
import Model.Expressions.Exp;
import Model.PrgState;
import Model.Statements.BaeStatements.IStmt;
import Utils.Interfaces.MyIHeap;

public class HeapAllocStmt implements IStmt {
    String varName;
    Exp expression;

    public HeapAllocStmt(String varName, Exp expression) {
        this.varName = varName;
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState state) throws ExpressionException {
        if (!state.getSymTable().containsKey(varName))
            state.getSymTable().put(varName, 0);

        MyIHeap heap = state.getHeap();
        state.getSymTable().put(varName, heap.allocNew(this.expression.eval(state.getSymTable(), heap)));
        return state;
    }

    public String toString()
    {
        return "new(" + varName + ", " + expression.toString() + ")";
    }
}
