// Assuming bfs.Node is an external class you want to store in the queue
public class Queue<T> {
    static class Node<T> {
        T item;  // This holds bfs.Node or any other type of item
        Node<T> next;

        private Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    Node<T> head;

    public Queue() {
        head = null;
    }
    public int len = 0;

    // Method to enqueue an item of type T (not a Node<T> directly)
    public void enqueue(T item) {
        Node<T> node = new Node<>(item, null); // Create a new Queue.Node<T>
        
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        len++;
    }

    // Method to dequeue the item of type T (bfs.Node in your case)
    public T dequeue() {
        if (head == null) {
            return null;
        }
        Node<T> node = head;  // Get the front node
        head = head.next;     // Move the head
        node.next = null;     // Clear the next pointer
        len--;
        return node.item;     // Return the item (of type T)
        
    }

    public void printQueue() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.item + " ");  // Print the item (bfs.Node in your case)
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty(){
        boolean is = true;
        if (len > 0){
            return false;
        }
        return is;
    }

   
}
