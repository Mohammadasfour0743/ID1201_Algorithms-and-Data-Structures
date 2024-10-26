import java.io.BufferedReader;
import java.io.FileReader;

public class hash2 {

  Area[] area;
  int size;

  public class Area {

    Integer code;
    String name;
    Integer pop;

    public Area(Integer code, String name, Integer pop) {
      this.code = code;
      this.name = name.trim();
      this.pop = pop;
    }
  }

  public hash2(String file, int size) {
    this.size = size;
    this.area = new Area[this.size * 2];
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;

      while ((line = br.readLine()) != null) {
        String[] row = line.split(",");
        Integer code = Integer.valueOf(row[0].trim().replaceAll("\\s", ""));

        add(code, row[1].trim(), Integer.valueOf(row[2]));
      }
    } catch (Exception e) {
      System.out.println(" file " + file + " not found");
    }
  }

  public int hashFunction(Integer inputArea) {
    return inputArea % size;
  }

  public void add(Integer zip1, String city, Integer pop) {
    int index = hashFunction(zip1);
    Area a = new Area(zip1, city, pop);

    while (area[index] != null) {
      index = (index + 1) % size;
    }
    area[index] = a;
  }

  public void add(Area a) {
    int index = hashFunction(a.code);

    while (area[index] != null) {
      index = (index + 1) % size;
    }
    area[index] = a;
  }

  public int lookup(Integer code1) {
    int index = hashFunction(code1);
    int check = 0;
    if (area[index] == null) {
      throw new IllegalArgumentException("no such element");
    }

    while (area[index] != null) {
      Integer a = area[index].code;
      check++;
      if (a.equals(code1)) {
        return check;
      }
      index = (index + 1) % size;
    }

    throw new IllegalArgumentException(
      "Element not here. Number of check: " + check
    );
  }

  public static long benchmark(hash2 zipfile, Area zipValue) {
    long t0 = System.nanoTime();
    zipfile.lookup(zipValue.code);
    long t1 = System.nanoTime();

    return t1 - t0;
  }

  public static void main(String[] args) {
    String file = "postnummer.csv";
    Integer zipValue = 98499; //"984 99” , "111 15"

    hash2 h = new hash2(file, 20000);
    Area area1 = h.new Area(11115, "lebanon", 4);
    Area area2 = h.new Area(98499, "lebanon", 5);
    Area area3 = h.new Area(65473, "lebanon", 5);
    //h.add(area1);
    //h.add(area2);
    h.add(area3);

    long total = 0;
    int trials = 100;
    int chk = h.lookup(zipValue);

    System.out.println(chk);

    /* 
    for (int i = 0; i < trials; i++) {
      long time = benchmark(h, area3);
      total += time;
    }
    System.out.println(zipValue + " | " + total / trials);
  }*/
  }
}
