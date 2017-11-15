package Repo;

import Model.PrgState;

public interface RepositoryInterface {
    PrgState getState();
    void logPrgStateExec();
}
