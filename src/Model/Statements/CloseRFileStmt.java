package Model.Statements;

import Exceptions.ExpressionException;
import Model.Expressions.Exp;
import Model.PrgState;
import Utils.MyFileReader;
import Utils.Interfaces.MyIDictionary;

public class CloseRFileStmt implements IStmt {
	Exp varId;
	
	public CloseRFileStmt(Exp varId)
	{
		this.varId = varId;
	}
	
	public PrgState execute(PrgState state) throws ExpressionException {
		MyIDictionary<Integer, MyFileReader> fileTable = state.getFileTable();
		MyIDictionary<String,Integer> symTable = state.getSymTable();
		
		Integer fileId = varId.eval(symTable);
		
		MyFileReader reader = fileTable.get(fileId);
		reader.close();
		
		fileTable.remove(fileId);
		
		String label = varId.toString();
		symTable.remove(label);
		
		return state;
	}
	public String toString()
	{
		return "Close(" + varId.toString() + ") ";
	}
	
}