import Controller.Controller;
import Model.*;
import Repo.Repository;
import Utils.MyDictionary;
import Utils.MyFileReader;
import Utils.MyList;
import Utils.MyStack;
import View.ExitCommand;
import View.RunExampleCommand;
import View.TextMenu;

import java.util.Scanner;

public class Interpreter {
	public static void main(String[] args) {
		MyFileReader.currentId  = 0;
		String log = "/home/cpodariu/Desktop/log.txt";
//		System.out.print("Log file name: \n");
//		Scanner s = new Scanner(System.in);
//		log = s.nextLine();
		
		
		PrgState st1 = new PrgState(new MyStack<IStmt>(), new MyDictionary<String, Integer>(), new MyList<String>(), new MyDictionary<Integer, MyFileReader>());
		Repository r1 = new Repository(st1, log);
		Controller c1 = new Controller(r1);
		IStmt ex1 = new CompStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(new
				VarExp("v")));
		c1.getState().getStack().push(ex1);
		
		PrgState st2 = new PrgState(new MyStack<IStmt>(), new MyDictionary<String, Integer>(), new MyList<String>(), new MyDictionary<Integer, MyFileReader>());
		Repository r2 = new Repository(st2, log);
		Controller c2 = new Controller(r2);
		IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp('+',new ConstExp(2),new
				ArithExp('*',new ConstExp(3), new ConstExp(5)))),
				new CompStmt(new AssignStmt("b",new ArithExp('+',new VarExp("a"), new
						ConstExp(1))), new PrintStmt(new VarExp("b"))));
		c2.getState().getStack().push(ex2);
		
		PrgState st3 = new PrgState(new MyStack<IStmt>(), new MyDictionary<String, Integer>(), new MyList<String>(), new MyDictionary<Integer, MyFileReader>());
		Repository r3 = new Repository(st3, log);
		Controller c3 = new Controller(r3);
		IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExp('-',new ConstExp(2), new
				ConstExp(2))),
				new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
						AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));
		c3.getState().getStack().push(ex3);
		
		
		PrgState st4 = new PrgState(new MyStack<IStmt>(), new MyDictionary<String, Integer>(), new MyList<String>(), new MyDictionary<Integer, MyFileReader>());
		Repository r4 = new Repository(st4, log);
		Controller c4 = new Controller(r4);
		c4.getState().getStack().push(new CloseRFileStmt(new VarExp("var_f")));
		c4.getState().getStack().push(new CompStmt(new ReadFileStmt(new VarExp("var_f"), "var_c"), new PrintStmt(new VarExp("var_c"))));
		c4.getState().getStack().push(new OpenRFileStmt("var_f", "in.txt"));
		
		
		TextMenu t = new TextMenu();
		t.addCommand(new ExitCommand("0", "exit"));
		t.addCommand(new RunExampleCommand("1", "Example 1", c1));
		t.addCommand(new RunExampleCommand("2", "Example 2", c2));
		t.addCommand(new RunExampleCommand("3", "Example 3", c3));
		t.addCommand(new RunExampleCommand("4", "Example 4", c4));
		t.show();
	}
}
