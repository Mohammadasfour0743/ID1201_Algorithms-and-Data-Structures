public class Paths2 {

  City[] path;
  int sp;

  public Paths2() {
    path = new City[54];
    sp = 0;
  }

  private Integer shortest(City from, City to, Integer max) {
    if (from == to) return 0;

    for (int i = 0; i < sp; i++) {
      if (path[i] == from) return null; // Avoid cycles
    }
    path[sp++] = from; // Mark the city as visited

    Integer shrt = null;

    for (int i = 0; i < from.connections.length; i++) {
      if (from.connections[i] != null) {
        Connection conn = from.connections[i];
        City next = conn.getDest();
        Integer duration = conn.getDur();

        if (max != null && duration >= max) {
          continue;
        }

        // Calculate the remaining max value for the next recursive call
        Integer remainingTime;
        if (max == null) {
          remainingTime = null;
        } else {
          remainingTime = max - duration;
        }
        Integer recurDur = shortest(next, to, remainingTime);

        if (recurDur != null) {
          Integer current = recurDur + duration;

          // Update the shortest path and the max value if a shorter path is found
          if (shrt == null || current < shrt) {
            shrt = current;
            max = shrt; // Update the max value to the newly found shortest path
          }
        }
      }
    }

    path[sp--] = null; // Backtrack
    return shrt;
  }

  public static void main(String[] args) {
    Map map = new Map("trains.csv"); // Load the map from CSV
    Paths2 finder = new Paths2();
    // Define the routes to benchmark
    String[][] routes = {
      { "Malmö", "Hässleholm", "300" },
      { "Malmö", "Linköping", "500" },
      { "Malmö", "Umeå", "500" },
      { "Malmö", "Kiruna", "500" },
      { "Stockholm", "Umeå", "500" }, // Ensure you have connections for Umeå
      { "Göteborg", "Sundsvall", "500" },
      { "Sundsvall", "Umeå", "300" },
      { "Umeå", "Göteborg", "1000" },
      { "Göteborg", "Umeå", "2000" },
    };

    for (String[] route : routes) {
      String from = route[0];
      String to = route[1];
      Integer max = Integer.valueOf(route[2]);

      long t0 = System.nanoTime(); // Start timing
      Integer dist = finder.shortest(map.lookup(from), map.lookup(to), null);
      long time = (System.nanoTime() - t0) / 1_000_000; // Calculate elapsed time

      if (dist != null) {
        System.out.println(
          "Shortest path from " +
          from +
          " to " +
          to +
          ": " +
          dist +
          " min (" +
          time +
          " ms)"
        );
      } else {
        System.out.println(
          "No valid path from " +
          from +
          " to " +
          to +
          " within the max time of " +
          max +
          " min. (" +
          time +
          " ms)"
        );
      }
    }
  }
}
