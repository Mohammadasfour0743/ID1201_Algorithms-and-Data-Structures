public class City {

    String name;
    DynamicArray<Connection> connections;
    Integer id;
    int count;
  
    public City(String name, Integer id) {
      this.name = name;
      this.connections = new DynamicArray<>();
      this.count = 0;
      this.id = id;
      
    }
  
    public void connect(City nextCity, int distance) {
        Connection newC = new Connection(nextCity, distance); // Create a new Connection object
        connections.add(newC); // Add the new Connection to the dynamic array
    }
  
    
  
    public String getName() {
      return name;
    }
  
    

    public Connection getConnection(int index) {
        return connections.get(index); // Return the specified connection
    }


    public DynamicArray<Connection> getConnections(){
        return connections;
    }


    // Method to get the number of connections
    public int getSize() {
        return connections.getSize(); // Return the current number of connections
    }
  }
  