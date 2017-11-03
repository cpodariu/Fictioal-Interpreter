package Controller;

import Model.IStmt;
import Model.PrgState;
import Repo.Repository;

public class Controller {

    Repository repository;

    public Controller(Repository repository)
    {
        this.repository = repository;
    }

    public void oneStep()
    {
        PrgState state = repository.getState();
        IStmt stmt = state.getStack().pop();

        stmt.execute(state);

        System.out.print(state.toString());
    }

    public void allSteps()
    {
        PrgState state = repository.getState();;
        do
        {
            oneStep();
        }while(!state.getStack().isEmpty());
    }

    public PrgState getState()
    {
        return repository.getState();
    }

    public Repository getRepository()
    {
        return repository;
    }

}
