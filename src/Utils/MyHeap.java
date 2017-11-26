package Utils;


import Utils.Interfaces.MyIDictionary;
import Utils.Interfaces.MyIHeap;

import java.util.Set;

public class MyHeap<V> implements MyIHeap<V>,MyIDictionary<Long, V> {
    private Long currentPos;
    private MyIDictionary<Long, V> dictionary;

    public MyHeap() {
        this.currentPos = Long.valueOf(1);
    }

    @Override
    public V put(Long key, V value) {
        return dictionary.put(key, value);
    }

    @Override
    public V get(Long key) {
        return dictionary.get(key);
    }

    @Override
    public boolean containsKey(Long key) {
        return dictionary.containsKey(key);
    }

    @Override
    public V remove(Long key) {
        return dictionary.remove(key);
    }

    @Override
    public boolean containsValue(V value) {
        return dictionary.containsValue(value);
    }

    @Override
    public Set<Long> keySet() {
        return dictionary.keySet();
    }

    @Override
    public Long allocNew(V value) {
        dictionary.put(this.currentPos, value);
        currentPos++;
        return currentPos - 1;
    }

    @Override
    public void freeMemory(Long address) {
        dictionary.remove(address);
    }

    @Override
    public void collectGarbage(MyIDictionary<String, Integer> symTable) {
        for (Long i:dictionary.keySet())
        {
            if (!symTable.containsValue(i))
        }
    }

    @Override
    public V dereference(Long address) {
        return dictionary.get(address);
    }
}
