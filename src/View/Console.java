package View;

import Controller.Controller;
import Exceptions.ExpressionException;
import Model.*;
import Repo.Repository;
import Utils.MyDictionary;
import Utils.MyList;
import Utils.MyStack;

import javax.naming.ldap.Control;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Console {
    private MyDictionary<Integer, IStmt> programs = new MyDictionary<Integer, IStmt>();
    private MyDictionary<Integer, String> commands = new MyDictionary<Integer, String>();

    private Controller ctrl;

    private void oneStep() throws ExpressionException
    {
        ctrl.oneStep();
    }

    private void allSteps() throws ExpressionException
    {
        ctrl.allSteps();
    }

    public Console()
    {
        programs.put(1, new CompStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(new
                VarExp("v"))));
        programs.put(2, new CompStmt(new AssignStmt("a", new ArithExp('+',new ConstExp(2),new
                ArithExp('*',new ConstExp(3), new ConstExp(5)))),
                new CompStmt(new AssignStmt("b",new ArithExp('+',new VarExp("a"), new
                        ConstExp(1))), new PrintStmt(new VarExp("b")))));
        programs.put(3, new CompStmt(new AssignStmt("a", new ArithExp('-',new ConstExp(2), new
                ConstExp(2))),
                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
                        AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v")))));

        commands.put(0, "Exit");
        commands.put(1,"One step");
        commands.put(2, "All steps");
    }

    private void printProgramsMenu()
    {
        System.out.print("Please select a program:\n");
        System.out.print("0. Exit\n");
        for (int key : this.programs.keySet())
        {
            System.out.print(key + ". " + this.programs.get(key).toString() + "\n");
        }
    }

    private void printCommandMenu()
    {
        for (int key : this.commands.keySet())
        {
            System.out.print(key + ". " + this.commands.get(key) + "\n");
        }
    }

    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        int command;
        while (true)
        {
            this.printProgramsMenu();
            command = scanner.nextInt();
            if (command == 0)
                return;
            if (this.programs.containsKey(command))
            {
                this.ctrl = new Controller();
                this.ctrl.getState().getStack().push(this.programs.get(command));
                while (!this.ctrl.getState().getStack().isEmpty())
                {
                    this.printCommandMenu();
                    command = scanner.nextInt();
                    if (command == 0)
                        break;
                    if (command == 1) {
                        try { this.oneStep(); }
                        catch (ExpressionException e)
                        {
                            System.out.print(e.toString() + "\n");
                            break;
                        }
                    }
                    else if (command == 2)
                    {
                        try { this.allSteps(); }
                        catch (ExpressionException e)
                        {
                            System.out.print(e.toString() + "\n");
                            break;
                        }
                    }
                    else
                        System.out.print("The value is not valid");
                }
            }
        }
    }
}