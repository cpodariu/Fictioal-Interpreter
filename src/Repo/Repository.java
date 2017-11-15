package Repo;

import Model.IStmt;
import Model.PrgState;
import Utils.MyDictionary;
import Utils.MyList;
import Utils.MyStack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Repository implements RepositoryInterface {
	PrgState state;
	
	public Repository(PrgState st) {
		state = st;
	}
	
	public Repository() {
		this.state = new PrgState(new MyStack<IStmt>(), new MyDictionary<String, Integer>(), new MyList<String>());
	}
	
	public PrgState getState() {
		return state;
	}
	
	@Override
	public void logPrgStateExec() {
		String logFilePath = "/home/cpodariu/Desktop/MAP/Fictioal-Interpreter/LogFiles/test.txt";
		try {
			PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
			logFile.append(state.toString());
			logFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}