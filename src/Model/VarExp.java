package Model;

import Utils.MyIDictionary;

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

    public int eval(MyIDictionary<String, Integer> dict)
    {
        return dict.get(label);
    }
}