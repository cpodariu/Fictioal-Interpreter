package Controller;

import Exceptions.ExpressionException;
import Exceptions.FileException;
import Model.IStmt;
import Model.PrgState;
import Repo.Repository;
import Utils.MyDictionary;
import Utils.MyList;
import Utils.MyStack;

public class Controller {

    Repository repository;

    public Controller()
    {
        this.repository = new Repository();
    }

    public Controller(Repository repository)
    {
        this.repository = repository;
    }

    public void oneStep() throws ExpressionException, FileException {
        PrgState state = repository.getState();
        IStmt stmt = state.getStack().pop();

        stmt.execute(state);

        repository.logPrgStateExec();

        System.out.print(state.toString());
    }

    public void allSteps() throws ExpressionException, FileException {
        PrgState state = repository.getState();
        System.out.print(state.toString());
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
