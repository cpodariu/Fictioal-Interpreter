package Model.Expressions;

import Exceptions.ExpressionException;
import Utils.Interfaces.MyIDictionary;

public abstract class Exp {
    public abstract String toString();
    public abstract int eval(MyIDictionary<String, Integer> dict) throws ExpressionException;
}
