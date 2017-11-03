package Model;

import Utils.MyIDictionary;

public class AssignStmt implements IStmt{
    String label;
    Exp value;

    public String toString()
    {
        return label + " = " + value.toString();
    }

    public PrgState execute(PrgState state)
    {
        MyIDictionary<String, Integer> symTable = state.getSymTable();

        int res = value.eval(symTable);
        symTable.put(label, res);

        return state;
    }

    public AssignStmt(String name, Exp exp)
    {
        label = name;
        value = exp;
    }

}