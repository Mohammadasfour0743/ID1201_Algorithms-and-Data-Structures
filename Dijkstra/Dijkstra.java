public class Dijkstra {

  public Path dijkstra(City source, City destination) {
    DynamicArray<Path> data = new DynamicArray<>();
    QPrior<Path> queue = new QPrior<>();
    Path start = new Path(source, null, 0);
    queue.enqueue(start);

    while (!queue.isEmpty()) {
      Path currentPath = queue.dequeue();

      // If we've reached the destination, print and return the path
      if (currentPath.getCity().name.equals(destination.name)) {
        System.out.println("Shortest Path from " + source.name + " to " + destination.name + ":");
        currentPath.printPath(); // Print the path from source to destination
        return currentPath;
      }

      // Ensure array has enough capacity for current city's ID
      while (data.getSize() <= currentPath.getCity().id) {
        data.add(null);
      }

      // Check if we've already recorded the shortest path to this city
      if (data.get(currentPath.getCity().id) == null || 
          data.get(currentPath.getCity().id).getDist() > currentPath.getDist()) {

        data.set(currentPath.getCity().id, currentPath);
        System.err.println("data array has: " + data.getSize());
        for (Connection conn : currentPath.getCity().connections) {
          City connCity = conn.getDest();
          Integer totalDist = currentPath.getDist() + conn.duration;
          Path connPath = new Path(connCity, currentPath, totalDist); // Link to currentPath

          // Ensure array has enough capacity for connCity's ID
          while (data.getSize() <= connCity.id) {
            data.add(null);
          }

          // Only enqueue if we haven't found a shorter path already
          if (data.get(connCity.id) == null || data.get(connCity.id).getDist() > totalDist) {
            queue.enqueue(connPath);
          }
        }
      }
    }
    return null;
  }
}
