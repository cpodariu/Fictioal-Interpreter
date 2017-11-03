package Model;

import Utils.MyIDictionary;

public abstract class Exp {
    public abstract String toString();
    public abstract int eval(MyIDictionary<String, Integer> dict);
}
