package Repo;

import Model.PrgState;

public class Repository {
    PrgState state;

    public Repository(PrgState st)
    {
        state = st;
    }

    public PrgState getState()
    {
        return state;
    }
}