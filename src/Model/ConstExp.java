package Model;

import Utils.MyIDictionary;

public class ConstExp extends Exp{
    int value;

    public String toString()
    {
        return Integer.toString(value);
    }

    public int eval(MyIDictionary<String, Integer> dict)
    {
        return value;
    }

    public ConstExp(int value)
    {
        this.value = value;
    }


}
