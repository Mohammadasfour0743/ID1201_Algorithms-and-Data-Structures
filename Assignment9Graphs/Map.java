import java.io.BufferedReader;
import java.io.FileReader;

public class Map {

  // Hash table to store City objects
  private City[][] cities;
  private final int mod = 13513; // Size of the hash table (prime number)
  

  // Constructor to initialize the cities array and read from the file
  public Map(String file) {
    cities = new City[mod][];
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] row = line.split(",");
        String cityName1 = row[0].trim();
        String cityName2 = row[1].trim();
        int distance = Integer.parseInt(row[2].trim());

        // Lookup or create cities
        City city1 = lookup(cityName1);
        City city2 = lookup(cityName2);

        // Connect the two cities bidirectionally
        city1.connect(city2, distance);
        city2.connect(city1, distance);
        
      }
    } catch (Exception e) {
      System.out.println("File " + file + " not found or corrupt");
    }
  }

  // Hash function for city names
  public int hashFunction(String cityName) {
    int hash = 0;
    for (int i = 0; i < cityName.length(); i++) {
      hash = (hash * 31 + cityName.charAt(i)) % mod; // String hash function
    }
    return hash;
  }

  // Method to look up a city by name or create it if it doesn't exist
  public City lookup(String cityName) {
    int index = hashFunction(cityName);

    if (cities[index] == null) { //if city does not exist, create a new one here with bucket size 3
        cities[index] = new City[3];
      }

    // Check the bucket at `index`
    for (int i = 0; i < cities[index].length; i++) {
      // If the city already exists in the bucket, return it
      if (
        cities[index][i] != null && cities[index][i].getName().equals(cityName)
      ) {
        return cities[index][i];
      }
    }

    // If the city doesn't exist in the bucket, create a new one and add it to the first empty slot
    City added = new City(cityName);
    for (int i = 0; i < cities[index].length; i++) {
      if (cities[index][i] == null) {
        cities[index][i] = added;
        return added;
      }
    }

    // If the bucket is full, increase the bucket size
    int newSize = cities[index].length * 2;
    City[] newArray = new City[newSize];
    for(int i=0; i < cities[index].length; i++){
        newArray[i] = cities[index][i];
    }
    cities[index] = newArray;

    //then add the city
    for (int i = 0; i < cities[index].length; i++) {
        if (cities[index][i] == null) {
          cities[index][i] = added;
          return added;
        }
      }

      throw new IllegalStateException("failed for some reason idk");

  }
  
    // Main method for testing
    public static void main(String[] args) {
        // Create a Map object using the "trains.csv" file
        Map cityMap = new Map("trains.csv");
    
        // Iterate over the hash table (cities) to print the cities and their connections
        for (int i = 0; i < cityMap.cities.length; i++) {
            City[] bucket = cityMap.cities[i]; // Get the bucket at index `i`
            if (bucket != null) { // Check if the bucket is not null (there are cities in this index)
                for (int j = 0; j < bucket.length; j++) {
                    City city = bucket[j]; // Get the city in the bucket slot
                    if (city != null) { // Check if the city is not null
                        System.out.println("City: " + city.getName());
                        // Print the connections for this city
                        for (int k = 0; k < city.connections.length; k++) {
                            Connection conn = city.connections[k];
                            if (conn != null) { // Check if the connection is not null
                                System.out.println("  Connected to: " + conn.destination.getName() + " (Distance: " + conn.duration + " km)");
                            }
                        }
                    }
                }
            }
        }
    }
    
    
}
