package Model;
public class IfStmt implements IStmt{

    Exp ex;
    IStmt ifS;
    IStmt elseS;

    public IfStmt(Exp exp, IStmt iStmt, IStmt elseS)
    {
        this.ex = exp;
        this.ifS = iStmt;
        this.elseS = elseS;
    }

    public String toString()
    {
        return "(If " + ex.toString() + " then " + ifS.toString() + " else " + elseS.toString()+ ")";
    }

    public PrgState execute(PrgState state)
    {
        int result = ex.eval(state.getSymTable());

        if(result != 0)
            state.getStack().push(ifS);
        else
            state.getStack().push(elseS);
        return state;
    }

}

