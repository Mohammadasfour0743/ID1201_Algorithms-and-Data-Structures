import java.io.*;
public class HP35 {
public static void main(String[] args) throws IOException {
    Stack<Integer> stack = new Dynamic<>(16);
    System.out.println("HP-35 pocket calculator!");
    boolean run = true;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(run) {
        System.out.print(" > ");
        String input = br.readLine();
        int a,b,c;
            switch (input) {
            case "+":
                a = stack.pop();
                b = stack.pop();
                c = a + b;
                stack.push(c);
            break;
            case "-":
                 a = stack.pop();
                 b = stack.pop();
                 c = b - a;
                stack.push(c);
            break;
            case "*":
                 a = stack.pop();
                 b = stack.pop();
                 c = a * b;
                stack.push(c);
            break;
            case "/":
                 a = stack.pop();
                 b = stack.pop();
                 c = b / a;
                stack.push(c);
            break;
            case "":
            run = false;
            break;
            default:
            Integer nr = Integer.parseInt(input);
            stack.push(nr);
            break;
        }
    }
    System.out.printf("the result is: %d\n\n", stack.pop());
    
    }
}