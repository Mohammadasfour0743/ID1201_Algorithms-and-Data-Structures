import java.util.NoSuchElementException;

public class ArrayQ<T> {
    private T[] q; // generic array to hold the queue elements
    private int i; // index of the first element
    private int k; // index of the first free slot
    private int qsize; // number of elements in queue
    private int n; // size of the array

    @SuppressWarnings("unchecked")
    public ArrayQ(int capacity) {
        q = (T[]) new Object[capacity]; // create a generic array
        i = 0;
        k = 0;
        qsize = 0;
        n = capacity;
    }

    public void enq(T item) {
        // If the array is full, we need to resize it
        if (k == i && qsize != 0) {
            resize(n * 2);
        }

        q[k] = item; // insert the item
        k = (k + 1) % n; // move the free slot index circularly
        qsize++;   
    }

    public T deq() {
        if (qsize == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        T a = q[i];
        q[i] = null; // set to null to avoid memory leak
        i = (i + 1) % n; // move the front index circularly
        qsize--;

        return a;
    }

    public void printQ() {
        for (int j = 0; j < n; j++) {
            System.out.print(q[j] + " ");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] biggerQ = (T[]) new Object[newCapacity];
        for (int j = 0; j < qsize; j++) {
            biggerQ[j] = q[(i + j) % n]; // copy elements in correct order
        }
        q = biggerQ;
        i = 0; // reset the first element index
        k = qsize; // set the first free slot index
        n = newCapacity; // update the capacity
    }

    public static void main(String[] args) {
        ArrayQ<Integer> queue = new ArrayQ<>(5); // Integer queue

        queue.printQ();

        queue.enq(1);
        queue.enq(2);
        queue.enq(3);
        queue.enq(4);
        queue.deq();
        queue.enq(5);
        queue.enq(6);
        queue.enq(7);

        System.out.println();
        queue.printQ();

        System.out.println(queue.deq());
        System.out.println(queue.deq());
        System.out.println(queue.deq());

        queue.printQ();

        queue.enq(11);
        queue.enq(12);
        queue.enq(13);
        queue.enq(14);
        queue.enq(15);
        queue.enq(16);
        queue.enq(17);

        queue.printQ();
    }
}
