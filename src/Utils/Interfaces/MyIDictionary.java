package Utils.Interfaces;

import java.util.Set;

public interface MyIDictionary <k,V>{
    V put(k key, V value);
    V get(k key);
    String toString();
    boolean containsKey(k key);
    public V remove(k key);
    boolean containsValue(V value);
    Set<k> keySet();
}