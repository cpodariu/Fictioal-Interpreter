package Controller;

import Exceptions.ExpressionException;
import Exceptions.FileException;
import Model.Statements.IStmt;
import Model.PrgState;
import Repo.Repository;

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
