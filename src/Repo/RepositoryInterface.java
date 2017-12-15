package Repo;

import Model.PrgState;
import Utils.Interfaces.MyIList;

import java.util.List;

public interface RepositoryInterface {
    MyIList<PrgState> getPrgList();
    void setPrgList(MyIList<PrgState> list);
    void logPrgStateExec(PrgState state);
}
