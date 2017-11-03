package Model;

import Utils.MyIList;

public class PrintStmt implements IStmt{
    
    Exp exp;
    
    public PrintStmt(Exp exp)
    {
        this.exp = exp;
    }

    public PrgState execute(PrgState state)
    {
        MyIList<String> out = state.getOut();

        out.add(Integer.toString(exp.eval(state.getSymTable())));
        return state;
    }

    public String toString()
    {
        return "Print(" + exp.toString() + ")";
    }
}