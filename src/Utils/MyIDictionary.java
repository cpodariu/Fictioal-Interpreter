package Utils;

import java.util.Set;

public interface MyIDictionary <K,V>{
    V put(K key, V value);
    V get(K key);
    String toString();
    boolean containsKey(K key);
    public V remove(K key);
    boolean containsValue(V value);
    Set<K> keySet();
}