public class Dynamic<T> extends Stack<T> {

    public Dynamic(int size) {
        this.size = size;
        stack = (T[]) new Object[size];
        top = 0;
    }
     
    public T[] increaseSize(T[] fake){
        int len = stack.length;
        T bigger[] = (T[]) new Object[2 * len];
        //T bigger[] = new T[2*len];
        for(int i=0; i < len; i++) {
           bigger[i] = fake[i];
        }
        return bigger;  
    }

    public void push(T val)  {
        int len = stack.length;      
        if(top == len) {
            stack = increaseSize(stack);
        }
        stack[top++] = val;     
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
        Stack<Integer> s = new Dynamic<>(16);
        s.push(32);
        System.out.println("pushed : 32");
        s.push(33);
        System.out.println("pushed : 33" );
        s.push(34);
        System.out.println("pushed : 34" );
        


        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());

        
        }

    
}
