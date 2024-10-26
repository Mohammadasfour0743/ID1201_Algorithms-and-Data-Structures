import java.util.Random;

public class BinaryTree {
    private class Node{

        private Integer value;
        private Node left, right;
        private Node(Integer value) {
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

    public BinaryTree() {
        root = null;
    }



    public void add(Integer value){
        root = addHelper(value, root);
        
    }

    private Node addHelper(Integer value, Node root){
        Node n = new Node(value);
        if (root == null){
            root = n;
            return root;
        }

        if (root.value == value){return root;}
        if(value < root.value){
            root.left = addHelper(value, root.left);
        }
        else if(value > root.value){
            root.right = addHelper(value, root.right);
        }
        return root;

    }

    public boolean lookup(Integer value){
        boolean found = lookupHelper(value, root);
        return found;
    }

    private boolean lookupHelper(Integer value, Node root){
        boolean find = false;
        if(root == null){
            return false;
        }

        else if(root.value == value){
            find = true;
        }
        else if(value < root.value){
            find = lookupHelper(value, root.left);
        }
        else if(value > root.value){
            find = lookupHelper(value, root.right);
        }
        return find;



    }

    

    public void display() {
        root.print();
	}
	

    public void add2(Integer value){
        Node n = new Node(value);
        if(root == null){
            root = n;
            return;
        }

        Node current = root;
        Node previousNode = null;
        while(current != null){
            previousNode = current;
            if (value < current.value){
                current = current.left;
            }
            else if(value > current.value){
                current = current.right;
            }
            else {return;} //value already in tree
        }
        current = previousNode;
        if(value < current.value){
            current.left = n;
        }
        else if(value > current.value){
            current.right = n;
        }
    }

    public static long benchTree(int size){
        BinaryTree t = new BinaryTree();
        Random rnd = new Random();

        for (int i = 0; i < size; i++){
            t.add(rnd.nextInt(100));
        }

        long t0 = System.nanoTime();
        t.add(100);
        long t1 = System.nanoTime();

        return t1-t0;

    }

    public void print(){
        Dynamic<Node> stk = new Dynamic<>(10);
        Node current = this.root;
        int len = 0; //keep track of length of stack
        //go to left-most node
        while (current != null ){
            stk.push(current);
            len++;
            current = current.left;
        }//current will be null
        
        while (len > 0){
            
            current = stk.pop();
            len--;
            System.out.println(current.value);
            
            //stk.pop();

            if(current.right != null){
                
                current = current.right;
                
                while (current != null) {
                    stk.push(current);
                    len++;
                    current = current.left;
                    
                }
                
            }
            
        }
        

    }


 

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(4);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.add(1);
        tree.add(3);
        tree.add(5);
        tree.add(8);
        tree.add(16);
        tree.add(32);
        

        tree.print();
    }

}
    
