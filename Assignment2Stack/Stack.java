public abstract class Stack<T> {
    T[] stack;
    int top;
    int size;
    public abstract void push(T value);
    public abstract T pop();
   
}
