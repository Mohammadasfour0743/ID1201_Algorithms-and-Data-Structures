public class StaticStack {
    int[] stack;
    int top;
    public StaticStack(int size) {
        stack = new int[size];
        top = 0;
    }
    public void push(int val) throws IndexOutOfBoundsException {
        if (top == stack.length) {
            throw new IndexOutOfBoundsException("Reached stack limit.");
        }
        else{stack[top++] = val;}
        
    }
    public int pop() throws IndexOutOfBoundsException{
        int a;
        if (top > 0) {
            a = stack[--top];}      
            
         else{
            throw new IndexOutOfBoundsException("It`s empty bro");
        }
        return a; 
    }
    public static void main(String[] args) {
    StaticStack s = new StaticStack(16);
    s.push(32);
    s.push(33);
    s.push(34);
    System.out.println("pop : " + s.pop());
    System.out.println("pop : " + s.pop());
    System.out.println("pop : " + s.pop());
    
    }


    }