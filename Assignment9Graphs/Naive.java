public class Naive {

  private static Integer shortest(City from, City to, Integer max) {
    if (max < 0) return null;
    if (from == to) return 0;
    Integer shrt = null;

    for (int i = 0; i < from.connections.length; i++) {
      if (from.connections[i] != null) {
        Connection conn = from.connections[i];
        City next = conn.getDest();
        Integer duration = conn.getDur();

        if (duration >= max) {
          continue;
        }

        Integer remainingTime = max - duration;

        Integer recurDur = shortest(next, to, remainingTime);

        if (recurDur != null) {
          Integer current = recurDur + duration; //add all values we get and the time for next
          if (shrt == null || current < shrt) {
            shrt = current;
          }
        }
      }
    }
    return shrt;
  }

  public static void main(String[] args) {
    Map map = new Map("trains.csv"); // Load the map from CSV
    // Define the routes to benchmark
    String[][] routes = {
      { "Malmö", "Göteborg", "300" },
      { "Göteborg", "Stockholm", "500" },
      { "Malmö", "Stockholm", "500" },
      { "Stockholm", "Sundsvall", "500" },
      { "Stockholm", "Umeå", "500" }, 
      { "Göteborg", "Sundsvall", "500"},
      { "Sundsvall", "Umeå", "600" },
      { "Umeå", "Göteborg", "1000" },
      { "Göteborg", "Umeå", "1000" },
    };

    for (String[] route : routes) {
      String from = route[0];
      String to = route[1];
      Integer max = Integer.valueOf(route[2]);

      long t0 = System.nanoTime(); // Start timing
      Integer dist = shortest(map.lookup(from), map.lookup(to), max);
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
