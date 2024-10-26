import java.util.ArrayList;
import java.util.NoSuchElementException;

public class QPrior<T extends Path> {
    private ArrayList<T> heap;

    public QPrior() {
        heap = new ArrayList<>();
    }

    // Return the index of the parent of the node at index i
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Return the index of the left child of the node at index i
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Return the index of the right child of the node at index i
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Add a new element to the heap (enqueue operation)
    public void enqueue(T item) {
        heap.add(item); // Add the new item at the end
        int index = heap.size() - 1;
        heapifyUp(index); // Heapify up to maintain the min-heap property
    }

    // Heapify up to ensure the heap property after adding an element
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(parent(index)).getDist() > heap.get(index).getDist()) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Remove and return the element with the minimum distance (dequeue operation)
    public T dequeue() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        T root = heap.get(0); // The root element (min)
        T lastItem = heap.remove(heap.size() - 1); // Remove the last item

        if (!heap.isEmpty()) {
            heap.set(0, lastItem); // Move the last item to the root
            heapifyDown(0); // Heapify down to maintain the min-heap property
        }

        return root;
    }

    // Heapify down to ensure the heap property after removing the root
    private void heapifyDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int smallest = index;

        if (left < heap.size() && heap.get(left).getDist() < heap.get(smallest).getDist()) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right).getDist() < heap.get(smallest).getDist()) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Return the number of elements in the heap
    public int size() {
        return heap.size();
    }

    // Peek at the element with the minimum distance without removing it
    public T peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }
}
