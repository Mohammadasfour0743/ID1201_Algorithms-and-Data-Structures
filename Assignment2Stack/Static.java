public class Static<T> extends Stack<T> {

    public Static(int size) {
        this.size = size;
        stack = (T[]) new Object[size];
        top = 0;
    }

    public void push(T val){
        if (top == stack.length) {
            throw new IndexOutOfBoundsException("Reached stack limit.");
        }
        else{stack[top++] = val;}
        
    }

    public T pop() {
        T a;
        if (top > 0) {
            a = stack[--top];}      
            
         else{
            throw new IndexOutOfBoundsException("It`s empty bro");
        }
        return a; 
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Static<>(16);
        s.push(32);
        s.push(33);
        s.push(34);
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        
        }
    
 }
    

