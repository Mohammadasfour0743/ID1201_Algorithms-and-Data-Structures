public class ColTest {

  private City[][] cities1; // first one is the city, second one is bucket
  private int size; // Current number of elements in the hash cities1
  private int capacity; // Size

  public ColTest(int capacity) {
    this.capacity = capacity;
    cities1 = new City[capacity][]; // Initialize the cities1 as a 2D array
    size = 0;
  }

  private static Integer hashFunction(String name, int mod) {
    int hash = 0;
    for (int i = 0; i < name.length(); i++) {
      hash = (hash * 31 + name.charAt(i)) % mod;
    }
    return hash;
  }

  public City lookup1(String name) {
    int index = hashFunction(name, capacity);

    if (cities1[index] == null) { //if city does not exist, create
      cities1[index] = new City[capacity];
    }

    for (int i = 0; i < cities1[index].length; i++) { //check if can find it
      if (
        cities1[index][i] != null && cities1[index][i].getName().equals(name)
      ) {
        return cities1[index][i];
      }
    }
    City added = new City(name);
    for (int i = 0; i < cities1[index].length; i++) { //if you can´t create new one with same name and add it to this location
      if (cities1[index][i] == null) {
        cities1[index][i] = added;
        return added;
      }
    }
    return null;
  }

  public void collisions(int mod) {
    int max = 20; // Maximum number of elements to consider
    int[] data = new int[mod]; // Array to count the number of cities in each bucket
    int[] cols = new int[max]; // Array to count how many buckets have a specific number of collisions

    // Count how many cities hash to each index (mod-based index)
    for (int i = 0; i < capacity; i++) {
      if (cities1[i] != null) {
        int modIndex = i % mod; // Use mod to distribute across the new mod size
        data[modIndex] = 0; // Initialize counter for this bucket
        for (int j = 0; j < cities1[i].length; j++) {
          if (cities1[i][j] != null) {
            data[modIndex]++; // Count the cities in this bucket
          }
        }
      }
    }

    // Count how many buckets have a certain number of cities
    for (int i = 0; i < mod; i++) {
      if (data[i] < max) {
        cols[data[i]]++; // Count the collisions for each bucket
      }
    }

    // Print the results
    System.out.print(mod + ": ");
    for (int i = 1; i < max; i++) {
      System.out.print("\t" + cols[i]);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // Define different mod sizes to test
    int[] modSizes = { 10, 20, 50, 70, 90 };

    // Create the map with an initial capacity (larger than mod size to avoid instant collisions)
    int capacity = 100;
    ColTest map = new ColTest(capacity);

    // Add some cities to the map
    String[] cities = {
      "New York",
      "Los Angeles",
      "Chicago",
      "Houston",
      "Phoenix",
      "Philadelphia",
      "San Antonio",
      "San Diego",
      "Dallas",
      "San Jose",
      "Austin",
      "Jacksonville",
      "Fort Worth",
      "Columbus",
      "Charlotte",
      "San Francisco",
      "Indianapolis",
      "Seattle",
      "Denver",
      "Washington",
    };

    // Insert cities into the map
    for (String city : cities) {
      map.lookup1(city);
    }

    // Test for collisions with different mod sizes
    for (int mod : modSizes) {
      map.collisions(mod);
    }
  }
}
