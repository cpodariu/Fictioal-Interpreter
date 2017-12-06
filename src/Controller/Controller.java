package Controller;

import Exceptions.ExpressionException;
import Exceptions.FileException;
import Model.Statements.BaeStatements.IStmt;
import Model.PrgState;
import Repo.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

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

        state.getHeap().setContent(conservativeGarbageCollector(
                state.getSymTable().values(),
                state.getHeap().getContent()));

        repository.logPrgStateExec();

        System.out.print(state.toString());
    }

    Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer,Integer> heap){
        return heap.entrySet().stream().filter(e->symTableValues.contains(e.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
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
