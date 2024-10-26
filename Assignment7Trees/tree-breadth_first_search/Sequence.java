// public class Sequence<T> {
//     private QueueImproved<BinaryTree<T>.Node> queue;



//     //constructor
//     public Sequence(QueueImproved<BinaryTree<T>.Node> queue){
//         this.queue=queue;
//     }


//     public T next(){
//         // create queue
//         //QueueImproved<BinaryTree<T>.Node> queue = new QueueImproved<>();


//         if(queue.isEmpty()){
//             throw new IllegalArgumentException("Tree doesn't exist");
//         }

//         //queue.enqueue(root);
//         BinaryTree<T>.Node val = queue.dequeue();
//        // BinaryTree<T>.Node val;

//         T current=val.getV();

//         val=queue.dequeue();
//         System.out.print(val.getV()+ " ");

//         if (val.getL()!= null) {
//             queue.enqueue(val.getL());
//         }
            
//         if (val.getR()!=null) {
//             queue.enqueue(val.getR());
//         }

//         return current;
//     }


// }


public class Sequence<T> {
    private QueueImproved<BinaryTree<T>.Node> queue;

    public Sequence(QueueImproved<BinaryTree<T>.Node> queue) {
        this.queue = queue;
    }

    public T next() {
        if (queue.isEmpty()) {
            throw new IllegalArgumentException("Tree is empty");
        }

        BinaryTree<T>.Node currentNode = queue.dequeue();

        if (currentNode.getL() != null) {
            queue.enqueue(currentNode.getL());
        }
        if (currentNode.getR() != null) {
            queue.enqueue(currentNode.getR());
        }

        return currentNode.getV();
    }
}

