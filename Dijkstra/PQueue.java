import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PQueue {
    private ArrayList<Path> queue;

    public PQueue() {
        queue = new ArrayList<>();
    }

    // Add a new path to the queue and maintain sorted order based on distance
    // public void enqueue(Path path) {
    //     int insertIndex = 0;
    //     // Find the correct position to insert the path
    //     while (insertIndex < queue.size() && queue.get(insertIndex).getDist() <= path.getDist()) {
    //         insertIndex++;
    //     }
    //     // Insert the path at the correct position
    //     queue.add(insertIndex, path);
    // }


    public void enqueue(Path path) {
        int insertIndex = 0;
        while(insertIndex < queue.size() && queue.get(insertIndex).getDist() <= path.getDist()) {
            insertIndex++;
        }
        queue.add(insertIndex, path);
        System.out.println("Enqueued Path: " + path.getCity().name + " with distance " + path.getDist());
    }
    
    public Path dequeue() {
        if(queue.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Path path = queue.remove(0);
        System.out.println("Dequeued Path: " + path.getCity().name + " with distance " + path.getDist());
        return path;
    }
    

    // Remove and return the path with the smallest distance (the first element)
    // public Path dequeue() {
    //     if (queue.isEmpty()) {
    //         throw new NoSuchElementException("Queue is empty");
    //     }
    //     return queue.remove(0); // Remove and return the first element
    // }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    
}
