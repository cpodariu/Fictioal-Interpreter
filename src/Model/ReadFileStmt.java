package Model;

import Exceptions.ExpressionException;
import Utils.MyFileReader;

public class ReadFileStmt implements IStmt{
	Exp var_id;
	String label;
	
	public ReadFileStmt(Exp id, String l)
	{
		label = l;
		var_id = id;
	}
	
	public PrgState execute(PrgState state) throws ExpressionException
	{
		int result = 0;
		
		result = var_id.eval(state.getSymTable());
		
		MyFileReader reader = state.getFileTable().get(result);
		
		Integer buff;
		
		buff = reader.readNextInt();
		
		state.getSymTable().put(label, buff);
		
		return state;
	}
	
	
	
	public String toString()
	{
		return "Read(" + var_id.toString() + ", " + label + ")";
	}
	
}
