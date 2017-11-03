package Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MyStack<T> extends Stack<T> implements MyIStack<T> {

    public String toString()
    {
        List<T> l = new ArrayList<T>(this);
        Collections.reverse(l);
        return l.toString();
    }
}
