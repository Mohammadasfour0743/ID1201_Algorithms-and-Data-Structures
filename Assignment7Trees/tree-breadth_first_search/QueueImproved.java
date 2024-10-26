// QueueImproved.java
public class QueueImproved<T> {
    private Node head;  // Points to the front of the queue
    private Node tail;  // Points to the end of the queue

    // Inner Node class representing each element in the linked list
    private class Node {
        T item;           // Change BinaryTree.Node to generic type T
        Node next;       // Pointer to the next node

        // Constructor for Node class
        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    // Constructor initializes an empty queue
    public QueueImproved() {
        this.head = null;  // Initialize head as null
        this.tail = null;  // Initialize tail as null
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to add a new node to the queue
    public void enqueue(T newNode) {
        Node newTail = new Node(newNode, null); // Create a new tail node
        if (isEmpty()) {
            head = newTail; // If queue is empty, head points to new node
        } else {
            tail.next = newTail; // Link the old tail to the new node
        }
        tail = newTail; // Update the tail to the new node
    }

    // Method to remove and return the front node from the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = head.item; // Get the item at the head
        head = head.next; // Move head to the next node
        if (head == null) {
            tail = null; // If queue is empty, update tail
        }
        return item; // Return the dequeued item
    }

    // Method to peek at the front item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.item; // Return the item at the head
    }



    public static void main(String[] args) {
    //     //int[] sizes = {100, 500, 1000, 2000, 4000, 8000, 12000}; // Different sizes to benchmark

    //     int[] sizes = {100, 200, 500, 1000, 1500, 2500, 5000}; 
    //     // Extended warm-up for JIT
    //     for (int i = 0; i < 200; i++) { // Warm-up iterations
    //         benchmarkEnqueue(1000); // Warm up by enqueueing 1000 items
    //     }

    //     // Benchmarking
    //     int trials = 200; // Number of trials for each size
    //     System.out.println("Size | Average Execution Time (ns)");
    //     for (int size : sizes) {
    //         long totalTime = 0;
    //         for (int i = 0; i < trials; i++) {
    //             System.gc(); // Suggest GC to avoid heap buildup
    //             totalTime += benchmarkEnqueue(size); // Benchmark the enqueue operation
    //         }
    //         long avgTime = totalTime / trials; // Average time over all trials
    //         System.out.println(size + " | " + avgTime + " ns");
    //     }
    // }
}
}
