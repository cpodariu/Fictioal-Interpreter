package Repo;

import Model.IStmt;
import Model.PrgState;
import Utils.MyDictionary;
import Utils.MyList;
import Utils.MyStack;

public class Repository {
    PrgState state;

    public Repository(PrgState st)
    {
        state = st;
    }

    public Repository()
    {
        this.state = new PrgState(new MyStack<IStmt>(), new MyDictionary<String,Integer>(), new MyList<String>());
    }

    public PrgState getState()
    {
        return state;
    }
}