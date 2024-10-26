import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // Initialize the map with the file
    Map map = new Map("europe.csv");

    // Get the cities
    City city1 = map.lookup("München");
    City city2 = map.lookup("Linköping");

    // Check if both cities were found
    if (city1 == null || city2 == null) {
      System.out.println("One or both cities were not found.");
      return;
    }

    // Find the shortest path
    Dijkstra dijkstra = new Dijkstra();
    long t0 = System.nanoTime();
    Path shortestPath = dijkstra.dijkstra(city1, city2);
    long t1 = System.nanoTime();
    long timeTaken = (t1 - t0) / 1_000_000;

    // Check if a path was found
    if (shortestPath == null) {
      System.out.println("No path found between " + city1.name + " and " + city2.name);
    } else {
      // Print the shortest path
      System.out.println(
        "Shortest path from " +
        city1.name +
        " to " +
        city2.name +
        " is: " +
        shortestPath.getDist() +
        " km"
      );
      System.out.println("Time taken: " + timeTaken  + " ms");
      // Print the full path
     


    }
  }
}
