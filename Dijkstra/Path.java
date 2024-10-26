public class Path {
  
  public City city;
  public Path prev;  // Changed to Path type
  private Integer dist;

  public Path(City city, Path prev, Integer dist) {  // prev is now a Path
    this.city = city;
    this.prev = prev;
    this.dist = dist;
  }

  public City getCity() {
    return city;
  }

  public Integer getDist() {
    return dist;
  }

  public Path getPrev() {
    return prev;
  }

  // Method to print the path from source to destination
  public void printPath() {
    if (prev != null) {
      prev.printPath(); // Recursively call on the previous Path
    }
    System.out.println(city.name + " (Distance: " + dist + ")");
  }

  @Override
  public String toString() {
    return "Path{" + "city=" + city + ", prev=" + prev + ", dist=" + dist + '}';
  }
}
