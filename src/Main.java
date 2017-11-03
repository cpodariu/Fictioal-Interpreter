import Controller.Controller;
import Model.*;
import Repo.Repository;
import Utils.MyDictionary;
import Utils.MyList;
import Utils.MyStack;

import javax.naming.ldap.Control;

public class Main {

    public static void main(String[] args) {
        PrgState st  = new PrgState(new MyStack<IStmt>(), new MyDictionary<String,Integer>(), new MyList<String>());
        Repository r = new Repository(st);
        Controller c = new Controller(r);
        st.getStack().push(new CompStmt(new AssignStmt("a", new ArithExp('-',new ConstExp(2), new
                ConstExp(2))),
                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
                        AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v")))));
        c.allSteps();
    }
}
