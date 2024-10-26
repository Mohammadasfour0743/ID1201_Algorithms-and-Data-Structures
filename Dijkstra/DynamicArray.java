import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable<T> {
    private T[] array;
    private int size;   // The current capacity of the array
    private int count;  // The number of elements currently in the array

    public DynamicArray() {
        this.size = 500;  // Start with an initial size
        this.array = (T[]) new Object[size];  // Create an array with initial capacity
        this.count = 0;  // Initially, the array has no elements
    }

    // Add a new element to the end of the array
    public void add(T val) {
        if (count == size) {
            resize(size * 2);  // Double the size of the array if full
        }
        array[count++] = val;  // Add the new element and increase the count
    }


    // Add a new element at a specific index
    public void add(int index, T element) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (count == size) {
            resize(size * 2);  // Double the size if the array is full
        }
        // Shift elements to the right to make space for the new element
        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        count++;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        array[index] = element;
    }
    

    // Get an element at a specific index
    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    // Get the current size (number of elements in the array)
    public int getSize() {
        return count;
    }

    // Private method to resize the array
    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];  // Create a new array with the new size
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];  // Copy the old elements to the new array
        }
        array = newArray;  // Replace the old array with the new one
        size = newSize;  // Update the size to the new size
    }

    // Optional method to remove the last element if needed
    public T removeLast() {
        if (count == 0) {
            throw new IllegalStateException("No elements to remove");
        }
        T val = array[--count];  // Get the last element and decrease the count
        if (count < size / 4 && size > 4) {
            resize(size / 2);  // Shrink the size if too much space is unused
        }
        return val;
    }

    // Iterate over the elements manually (without using Iterator or imports)
    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(array[i]);
        }
    }

    // Implement Iterable<T>
    @Override
    public Iterator<T> iterator() {
        return new DynamicArrayIterator();
    }

    // Inner class for the iterator
    private class DynamicArrayIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < count;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[currentIndex++];
        }
    }
}
