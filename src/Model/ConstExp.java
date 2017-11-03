package Model;

import Utils.MyIDictionary;

public class ConstExp extends Exp{
    int number;

    public String toString()
    {
        return Integer.toString(number);
    }

    public int eval(MyIDictionary<String, Integer> dict)
    {
        return number;
    }

    public ConstExp(int value)
    {
        number = value;
    }


}
