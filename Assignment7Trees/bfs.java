import java.util.Random;

public class bfs {
    private class Node{

        private String value;
        private Node left, right;
        private Node(String value) {
            this.value = value;
            this.left = this.right = null;
        }

        public void print() {
            if(left != null)
                left.print();
            System.out.println(value);
            if(right != null)
                right.print();
            }
            
    }

    private Node root;

    public bfs() {
        root = null;
    }


    public void display() {
        root.print();
	}
	

    public void addbfs(Node n){
        root = n;
    }

    
    public void printbfs(){
        Queue<Node> q = new Queue<>();
        if(this.root == null){
            throw new IllegalArgumentException("Tree is empty");
        }
        Node a = this.root;
        Node prnt = null;
        
        q.enqueue(a);
        Node current = a;

        while(current != null){
            current = q.dequeue();          
            if (current != null){
                System.out.println(current.value);
            }
            else {return;} 
            q.enqueue(current.left);
            q.enqueue(current.right);
            
            

        }

    }
    


 

    public static void main(String[] args) {
        bfs t = new bfs();
        Node a = t.new Node("A");
        Node b = t.new Node("B");
        Node c = t.new Node("C");
        Node d = t.new Node("D");
        Node e = t.new Node("E");
        Node f = t.new Node("F");
        Node g = t.new Node("G");
        Node h = t.new Node("H");
        Node i = t.new Node("I");
        Node j = t.new Node("J");
        Node k = t.new Node("K");
        Node l = t.new Node("L");
        Node m = t.new Node("M");
        Node n = t.new Node("N");
        Node o = t.new Node("O");

        
        t.addbfs(a);//root A

        a.left= b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        d.left = h;
        d.right = i;

        e.left = j;
        e.right = k;

        f.left = l;
        f.right = m;

        g.left= n;
        g.right=o;

        t.printbfs();

        
        

        
    }
}
