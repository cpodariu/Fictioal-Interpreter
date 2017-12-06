package Repo;

import Model.Statements.BaeStatements.IStmt;
import Model.PrgState;
import Utils.PrimitiveADT.MyDictionary;
import Utils.PrimitiveADT.MyList;
import Utils.PrimitiveADT.MyStack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Repository implements RepositoryInterface {
	PrgState state;
	String logFilePath;
	PrintWriter logFileWriter;
	
	public Repository(PrgState st) {
		this(st, "/home/cpodariu/Desktop/Fictioal-Interpreter/LogFiles/test.txt");
		
	}
	
	public Repository() {
		this(new PrgState(), "/home/cpodariu/Desktop/Fictioal-Interpreter/LogFiles/test.txt");
	}

	public Repository(PrgState state, String logFilePath)
	{
		this.state = state;
		this.logFilePath = logFilePath;
		try{
			this.logFileWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.logFilePath, true)));
		}
		catch(IOException e)
		{
			System.out.print(e.getMessage());
		}
	}
	
	public PrgState getState() {
		return state;
	}
	
	@Override
	public void logPrgStateExec() {
		logFileWriter.write(state.toString());
		logFileWriter.flush();
	}
}