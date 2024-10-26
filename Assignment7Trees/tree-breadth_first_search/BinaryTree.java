// import java.util.Stack;

// public class BinaryTree<T> {

//         public class Node  {
//             private T value;      // Change Integer to generic type T
//             private Node left, right;
    
//             public Node(T value) {
//                 this.value = value;
//                 this.left = this.right = null;
//             }

//             public T getV(){
//                 return value;
//             }

//             public Node getR(){
//                 return right;
//             }

//             public Node getL(){
//                 return left;
//             }

//         }   
//         private Node root;
    
//         public BinaryTree() {
//             root = null;
//         }
//         // public Sequence<T> sequence(){
//         //     //create the queue
//         //     QueueImproved<BinaryTree<T>.Node> queue = new QueueImproved<>();
           
//         //     // enqueue the root
//         //     if(root!=null){
//         //         queue.enqueue(root);
//         //     }

//         //     Sequence<T> sequence=new Sequence<>(queue);
//         //     return sequence;
//         // }


//         public Sequence<T> sequence() {
//             // Create a queue of BinaryTree<T>.Node objects
//             QueueImproved<BinaryTree<T>.Node> queue = new QueueImproved<>();
            
//             // Enqueue the root node if it exists
//             if (root != null) {
//                 queue.enqueue(root);
//             }
        
//             // Pass the queue to the Sequence constructor
//             Sequence<T> sequence = new Sequence<>(queue);
//             return sequence;
//         }
        
//     public void bfs(){
//         // create queue
//         QueueImproved<Node> queue = new QueueImproved<>();

//         if(root==null){
//             throw new IllegalArgumentException("Tree doesn't exist");
//         }

//         queue.enqueue(root);
//         Node val;

//         while(!queue.isEmpty()){
//             val=queue.dequeue();
//             System.out.print(val.value+ " ");

//             if (val.left!= null) {
//                 queue.enqueue(val.left);
//             }
            
//             if (val.right!=null) {
//                 queue.enqueue(val.right);
//             }
//            // val=queue.peek();
//         }
//     }

//     public void print() {
//         Stack<Node> stk = new Stack<>();
//         Node cur = this.root;
//         int stackSize = 0; // Track stack size manually
    
//         // Traverse while there are nodes to visit
//         while (cur != null || stackSize > 0) {
//             // Traverse to the leftmost node
//             while (cur != null) {
//                 stk.push(cur);
//                 stackSize++; // Manually track the push operation
//                 cur = cur.left;
//             } 
//             // Pop the node from the stack, and print its value
//             cur = stk.pop();
//             stackSize--; // Manually track the pop operation
//             System.out.print(cur.value+ " ");
    
//             // Move to the right subtree
//             cur = cur.right;
//         }
//     }
    
//     public static void main(String[] args) {
//         //QueueImproved<Node> queue = new QueueImproved<>();     
//      // BinaryTree<String> tree= new BinaryTree<>();
//         // tree.root=tree.new Node("A");
//         // tree.root.left=tree.new Node("B");
//         // tree.root.right=tree.new Node("C");
//         // tree.root.left.left=tree.new Node("D");
//         // tree.root.left.right=tree.new Node("E");
//         // tree.root.left.left.left=tree.new Node("H");
//         // tree.root.left.left.right=tree.new Node("I");


//         // tree.root.left.right.left=tree.new Node("J");
//         // tree.root.left.right.right=tree.new Node("K");


//         // tree.root.right.left=tree.new Node("F");
//         // tree.root.right.right=tree.new Node("G");


//         // tree.root.right.left.left=tree.new Node("L");
//         // tree.root.right.left.right=tree.new Node("M");

//         // tree.root.right.right.left=tree.new Node("N");
//         // tree.root.right.right.right=tree.new Node("O");
//         // tree.print();  // works perfect
//         // System.out.println();
//         // tree.bfs();
//         // Sequence<String> sequence= tree.sequence();
//         // System.out.println(sequence.next());


//         BinaryTree<String> tree = new BinaryTree<>();

//     tree.root = tree.new Node("A");
//     tree.root.left = tree.new Node("B");
//     tree.root.right = tree.new Node("C");

//     // Call the sequence method
//     Sequence<String> sequence = tree.sequence();

//     // Fetch and print the next element
//     System.out.println(sequence.next());


//     }

// }


import java.util.Stack;

public class BinaryTree<T> {

    public class Node  {
        private T value;      // Change Integer to generic type T
        private Node left, right;

        public Node(T value) {
            this.value = value;
            this.left = this.right = null;
        }

        public T getV(){
            return value;
        }

        public Node getR(){
            return right;
        }

        public Node getL(){
            return left;
        }
    }   

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Sequence<T> sequence() {
        QueueImproved<BinaryTree<T>.Node> queue = new QueueImproved<BinaryTree<T>.Node>();
    
        if (root != null) {
            queue.enqueue(root);
        }
    
        return new Sequence<T>(queue); // Explicitly specify <T>
    }
    
    public void bfs(){
        // create queue
        QueueImproved<Node> queue = new QueueImproved<>();

        if(root==null){
            throw new IllegalArgumentException("Tree doesn't exist");
        }

        queue.enqueue(root);
        Node val;

        while(!queue.isEmpty()){
            val=queue.dequeue();
            System.out.print(val.value+ " ");

            if (val.left!= null) {
                queue.enqueue(val.left);
            }
            
            if (val.right!=null) {
                queue.enqueue(val.right);
            }
           // val=queue.peek();
        }
    }

    public void print() {
        Stack<Node> stk = new Stack<>();
        Node cur = this.root;
        int stackSize = 0; // Track stack size manually

        // Traverse while there are nodes to visit
        while (cur != null || stackSize > 0) {
            // Traverse to the leftmost node
            while (cur != null) {
                stk.push(cur);
                stackSize++; // Manually track the push operation
                cur = cur.left;
            } 
            // Pop the node from the stack, and print its value
            cur = stk.pop();
            stackSize--; // Manually track the pop operation
            System.out.print(cur.value+ " ");

            // Move to the right subtree
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        //QueueImproved<Node> queue = new QueueImproved<>();     
     BinaryTree<String> tree= new BinaryTree<>();
        tree.root=tree.new Node("A");
        tree.root.left=tree.new Node("B");
        tree.root.right=tree.new Node("C");
        // tree.root.left.left=tree.new Node("D");
        // tree.root.left.right=tree.new Node("E");
        // tree.root.left.left.left=tree.new Node("H");
        // tree.root.left.left.right=tree.new Node("I");

        // tree.root.left.right.left=tree.new Node("J");
        // tree.root.left.right.right=tree.new Node("K");

        // tree.root.right.left=tree.new Node("F");
        // tree.root.right.right=tree.new Node("G");

        tree.root.left.left=tree.new Node("D");



        Sequence<String> sequence = tree.sequence();

        System.out.println(sequence.next());
        System.out.println(sequence.next());
        System.out.println(sequence.next());
        System.out.println(sequence.next());

    }
}
