package Controller;

import Exceptions.ExpressionException;
import Exceptions.FileException;
import Exceptions.HeapException;
import Model.Statements.BaeStatements.IStmt;
import Model.PrgState;
import Repo.Repository;
import Utils.MyFileReader;

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

    public void oneStep() throws ExpressionException, FileException, HeapException {
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


    public void allSteps() throws ExpressionException, FileException, HeapException {
        PrgState state = repository.getState();
        System.out.print(state.toString());
        try {
            do {
                oneStep();
            } while (!state.getStack().isEmpty());
        } finally {
            state.getFileTable().values().forEach(MyFileReader::close);
        }
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
r