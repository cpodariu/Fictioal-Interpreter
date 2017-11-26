package Model.Expressions;

import Exceptions.ExpressionException;
import Utils.Interfaces.MyIDictionary;

public class VarExp extends Exp{

    String label;

    public VarExp(String label)
    {
        this.label = label;
    }

    public String toString()
    {
        return label;
    }

    public int eval(MyIDictionary<String, Integer> dict) throws  ExpressionException
    {
        if (!dict.containsKey(label))
            throw new ExpressionException("Label " + label + " not in symbol table")
                    ;
        return dict.get(label);
    }
}