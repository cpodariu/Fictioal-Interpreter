package Model;

import Utils.MyFileReader;
import Utils.MyIDictionary;
import Utils.MyIList;
import Utils.MyIStack;

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
        String res = "Exe Stack:\n" + exeStack.toString() +
                "\nSym Table:\n" + symTable.toString() +
                "\nOut:\n" + out.toString() + "\n";
        return res;
    }
	
	public MyIDictionary<Integer, MyFileReader> getFileTable() {
		return fileTable;
	}
}
