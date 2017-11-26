package Model;

import Model.Statements.IStmt;
import Utils.MyFileReader;
import Utils.Interfaces.MyIDictionary;
import Utils.Interfaces.MyIList;
import Utils.Interfaces.MyIStack;

public class PrgState {
    MyIStack<IStmt> exeStack;
    MyIDictionary<String,Integer> symTable;
    MyIList<String> out;
    MyIDictionary<Integer, MyFileReader> fileTable;

    public PrgState(MyIStack<IStmt> exeStack,MyIDictionary<String,Integer> symTable, MyIList<String> out )
    {
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
    }
    
    public PrgState(MyIStack<IStmt> exeStack,MyIDictionary<String,Integer> symTable, MyIList<String> out, MyIDictionary<Integer, MyFileReader>fileTable)
    {
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
        this.fileTable = fileTable;
    }

    public MyIStack<IStmt> getStack()
    {
        return exeStack;
    }

    public MyIDictionary<String, Integer> getSymTable()
    {
        return symTable;
    }

    public MyIList<String> getOut()
    {
        return out;
    }

    public String toString()
    {
        String res = "\nExe Stack:\n" + exeStack.toString() +
                "\nSym Table:\n" + symTable.toString() +
                "\nOut:\n" + out.toString() +
                "\nFiles:\n" + fileTable.toString() + "\n";
        return res;
    }
	
	public MyIDictionary<Integer, MyFileReader> getFileTable() {
		return fileTable;
	}
}
