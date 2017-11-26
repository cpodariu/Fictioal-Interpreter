package Utils.Interfaces;

import Utils.Interfaces.MyIDictionary;

public interface MyIHeap<V> {
    public Long allocNew(V value);
    public void freeMemory(Long address);
    public void collectGarbage(MyIDictionary<String,Integer> symTable);
    public V dereference(Long address);
}
