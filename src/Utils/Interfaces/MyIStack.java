package Utils.Interfaces;

public interface MyIStack<T> {
    public T push(T elem);
    public T pop();
    public String toString();
    public boolean isEmpty();
}