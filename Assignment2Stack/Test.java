public class Test {
    public static void main(String[] args) {
    Stack<Integer> stack = new Dynamic<Integer>(16);
    for (Integer i = 0; i < 32; i++) {
    stack.push(i);
    }
    Integer j = stack.pop();
    while( j != null) {
    System.out.printf(" pop: %d\n", j);
    j = stack.pop();
    }
    }
    }
    