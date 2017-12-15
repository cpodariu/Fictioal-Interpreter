import Controller.Controller;
import Model.*;
import Model.Expressions.ArithExp;
import Model.Expressions.ConstExp;
import Model.Expressions.HeapReadExp;
import Model.Expressions.VarExp;
import Model.Statements.BaeStatements.*;
import Model.Statements.FileStatements.CloseRFileStmt;
import Model.Statements.FileStatements.OpenRFileStmt;
import Model.Statements.FileStatements.ReadFileStmt;
import Model.Statements.HeapStatements.HeapAllocStmt;
import Model.Statements.HeapStatements.HeapWriteStmt;
import Repo.Repository;
import Utils.PrimitiveADT.MyDictionary;
import Utils.MyFileReader;
import Utils.PrimitiveADT.MyList;
import Utils.PrimitiveADT.MyStack;
import View.ExitCommand;
import View.RunExampleCommand;
import View.TextMenu;

import java.lang.invoke.ConstantCallSite;

public class Interpreter {
	public static void main(String[] args) {
		MyFileReader.currentId  = 0;
		String log = "log.txt";
//		System.out.print("Log file name: \n");
//		Scanner s = new Scanner(System.in);
//		log = s.nextLine();
		
		
		PrgState st1 = new PrgState();
		Repository r1 = new Repository(st1, log);
		Controller c1 = new Controller(r1);
		IStmt ex1 = new CompStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(new
				VarExp("v")));
		c1.getState().getStack().push(ex1);
		
		PrgState st2 = new PrgState();
		Repository r2 = new Repository(st2, log);
		Controller c2 = new Controller(r2);
		IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp('+',new ConstExp(2),new
				ArithExp('*',new ConstExp(3), new ConstExp(5)))),
				new CompStmt(new AssignStmt("b",new ArithExp('+',new VarExp("a"), new
						ConstExp(1))), new PrintStmt(new VarExp("b"))));
		c2.getState().getStack().push(ex2);
		
		PrgState st3 = new PrgState();
		Repository r3 = new Repository(st3, log);
		Controller c3 = new Controller(r3);
		IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExp('-',new ConstExp(2), new
				ConstExp(2))),
				new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
						AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));
		c3.getState().getStack().push(ex3);
		
		
		PrgState st4 = new PrgState();
		Repository r4 = new Repository(st4, log);
		Controller c4 = new Controller(r4);
		c4.getState().getStack().push(new CloseRFileStmt(new VarExp("var_f")));
		c4.getState().getStack().push(new IfStmt(new VarExp("var_c"),
										new CompStmt(new ReadFileStmt(new VarExp("var_f"), "var_c"), new PrintStmt(new VarExp("var_c"))),
										new PrintStmt(new ConstExp(0))));
		c4.getState().getStack().push(new CompStmt(new ReadFileStmt(new VarExp("var_f"), "var_c"), new PrintStmt(new VarExp("var_c"))));
		c4.getState().getStack().push(new OpenRFileStmt("var_f", "in.txt"));

//		v=10;new(v,20);new(a,22);print(v)
		PrgState st5 = new PrgState();
		Repository r5 = new Repository(st5, log);
		Controller c5 = new Controller(r5);
		c5.getState().getStack().push(new PrintStmt(new VarExp("v")));
		c5.getState().getStack().push(new HeapAllocStmt("a", new ConstExp(22)));
		c5.getState().getStack().push(new HeapAllocStmt("v", new ConstExp(20)));
		c5.getState().getStack().push(new AssignStmt("v", new ConstExp(20)));

//		 v=10;new(v,20);new(a,22);print(100+rH(v));print(100+rH(a))

		PrgState st6 = new PrgState();
		Repository r6 = new Repository(st6, log);
		Controller c6 = new Controller(r6);
		c6.getState().getStack().push(new PrintStmt(new ArithExp('+', new ConstExp(100), new HeapReadExp("a"))));
		c6.getState().getStack().push(new PrintStmt(new ArithExp('+', new ConstExp(100), new HeapReadExp("v"))));
		c6.getState().getStack().push(new HeapAllocStmt("a", new ConstExp(22)));
		c6.getState().getStack().push(new HeapAllocStmt("v", new ConstExp(20)));
		c6.getState().getStack().push(new AssignStmt("v", new ConstExp(10)));

//		v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a))

		PrgState st7 = new PrgState();
		Repository r7 = new Repository(st7, log);
		Controller c7 = new Controller(r7);
		c7.getState().getStack().push(new PrintStmt(new HeapReadExp("a")));
		c7.getState().getStack().push(new PrintStmt(new VarExp("a")));
		c7.getState().getStack().push(new HeapWriteStmt("a", new ConstExp(20)));
		c7.getState().getStack().push(new HeapAllocStmt("a", new ConstExp(22)));
		c7.getState().getStack().push(new HeapAllocStmt("v", new ConstExp(20)));
		c7.getState().getStack().push(new AssignStmt("v", new ConstExp(10)));

//      v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a));a=0


		PrgState st8 = new PrgState();
		Repository r8 = new Repository(st8, log);
		Controller c8 = new Controller(r8);
		c8.getState().getStack().push(new AssignStmt("a", new ConstExp(1)));
		c8.getState().getStack().push(new PrintStmt(new HeapReadExp("a")));
		c8.getState().getStack().push(new PrintStmt(new VarExp("a")));
		c8.getState().getStack().push(new HeapWriteStmt("a", new ConstExp(20)));
		c8.getState().getStack().push(new HeapAllocStmt("a", new ConstExp(22)));
		c8.getState().getStack().push(new HeapAllocStmt("v", new ConstExp(20)));
		c8.getState().getStack().push(new AssignStmt("v", new ConstExp(10)));


		PrgState st9 = new PrgState();
		Repository r9 = new Repository(st9, log);
		Controller c9 = new Controller(r9);
		c9.getState().getStack().push(new PrintStmt(new VarExp("a")));
		c9.getState().getStack().push(new CompStmt( new AssignStmt("a", new ArithExp('-', new VarExp("a"), new ConstExp(1))),
													new PrintStmt(new VarExp("a"))));
		c9.getState().getStack().push(new WhileStmt(new ArithExp(new VarExp("a"), new ConstExp(4), '-')));
		c9.getState().getStack().push(new AssignStmt("a", new ConstExp(6)));


		TextMenu t = new TextMenu();
		t.addCommand(new ExitCommand("0", "exit"));
		t.addCommand(new RunExampleCommand("1", "Example 1", c1));
		t.addCommand(new RunExampleCommand("2", "Example 2", c2));
		t.addCommand(new RunExampleCommand("3", "Example 3", c3));
		t.addCommand(new RunExampleCommand("4", "Example 4", c4));
		t.addCommand(new RunExampleCommand("5", "Example 5", c5));
		t.addCommand(new RunExampleCommand("6", "Example 6", c6));
		t.addCommand(new RunExampleCommand("7", "Example 7", c7));
		t.addCommand(new RunExampleCommand("8", "Example 8", c8));
		t.addCommand(new RunExampleCommand("9", "Example 9", c9));
		t.show();
	}
}
