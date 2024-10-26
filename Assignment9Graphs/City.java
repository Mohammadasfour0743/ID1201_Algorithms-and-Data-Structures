public class City {

  String name;
  Connection[] connections;
  int count;

  public City(String name) {
    this.name = name;
    this.connections = new Connection[60];
    this.count = 0;
  }

  public void connect(City nextCity, int distance) {
    if (count < connections.length) {
      connections[count] = new Connection(nextCity, distance);
      count++;
    } else {
      System.out.println("Maximum connections reached for " + name);
    }
  }

  public int getCount() {
    return count;
  }

  public String getName() {
    return name;
  }

  public Connection[] getConnections() {
    return connections;
  }
}
