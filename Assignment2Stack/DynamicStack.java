
public class DynamicStack {

    int[] stack;
    //int size = stack.length;
    int top;
    

    public DynamicStack(int size) {
        
        stack = new int[size];
        top = 0;
        if(size <= 0){
            throw new IllegalArgumentException("Size = 0 is not allowed.");
        }
    }

    public int[] increaseSize(int[] old){
        int len = stack.length;
        int bigger[] = new int[2*len];
        for(int i=0; i < len; i++) {
           bigger[i] = old[i];
        }
        return bigger;  
    }

    public int[] reduceStack(int[] old){
        int len = stack.length;
        int smaller[] = new int[len / 2];
        for (int i = 0; i<len / 2; i++){
            smaller[i] = old[i];
        }
        return smaller;
    }

    public void push(int val)  {
        int len = stack.length;      
        if(top == len) {
            stack = increaseSize(stack);
        }
        stack[top++] = val;
        
    }

    public int size(){
        return stack.length;
    }

    public int pop() throws IndexOutOfBoundsException{
        int a;
        if (top > 0) {
            a = stack[--top];}      
            
         else{
            throw new IndexOutOfBoundsException("It`s empty bro");
        }

        if (top < stack.length / 2 ){
            stack = reduceStack(stack);
        }
        return a; 
    }

    public static void main(String[] args) {
        DynamicStack s = new DynamicStack(16);
        s.push(32);
        System.out.println("pushed : 32");
        s.push(33);
        System.out.println("pushed : 33" );
        s.push(34);
        System.out.println("pushed : 34" );
        System.out.println(s.size());


        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());

        System.out.println(s.size());
        
        }
    
    
        }


    
