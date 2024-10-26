import java.io.BufferedReader;
import java.io.FileReader;

public class hash1 {

  Bucket[] bucket;
  int max = 13513;

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

  class Bucket {

    Area[] area;
    int count;

    public Bucket() {
      this.area = new Area[1]; //initially holds 1 area
      //this.count = 0; //nb of elements inside bucket
    }
  }

  public hash1(String file) {
    this.bucket = new Bucket[this.max];
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;

      while ((line = br.readLine()) != null) {
        String[] row = line.split(",");
        Integer code = Integer.valueOf(row[0].trim().replaceAll("\\s", ""));
        Area area = new Area(code, row[1].trim(), Integer.valueOf(row[2])); //create the area

        add(area);
      }
    } catch (Exception e) {
      System.out.println(" file " + file + " not found");
    }
  }

  public int hashFunction(Area area) {
    int zipint = Integer.valueOf(area.code);
    return zipint % max;
  }

  public void add(Area area) {
    int index = hashFunction(area);
    if (bucket[index] == null) {
      bucket[index] = new Bucket();
    }
    //check for resizing

    if (bucket[index].count == bucket[index].area.length) {
      Area[] bigger = new Area[bucket[index].area.length * 2];
      for (int i = 0; i < bucket[index].area.length; i++) {
        bigger[i] = bucket[index].area[i];
      }
      bucket[index].area = bigger;
    }
    bucket[index].area[bucket[index].count] = area;
    //bucket[index].count++;
  }

  public Area lookup(Area area) {
    int index = hashFunction(area);

    if (bucket[index] == null) {
      throw new IllegalArgumentException("No element here");
    }
    Area needed = null;
    for (int i = 0; i < bucket[index].area.length; i++) {
      if (bucket[index].area[i].code == area.code) {
        needed = bucket[index].area[i];
      }
    }

    return needed;
  }

  public static long benchmark(hash1 zipfile, Area zipValue) {
    long t0 = System.nanoTime();
    zipfile.lookup(zipValue);
    long t1 = System.nanoTime();

    return t1 - t0;
  }

  public static void main(String[] args) {
    String file = "postnummer.csv";
    String zipValue = "98499"; //"984 99” , "111 15"

    hash1 buck = new hash1(file);
    Area area1 = buck.new Area(98499, "lebanon", 4);
    Area area2 = buck.new Area(65423, "lebanon", 5);
    buck.add(area1);
    buck.add(area2);

    long total = 0;
    int trials = 10;

    for (int i = 0; i < trials; i++) {
      long time = benchmark(buck, area2);
      total += time;
    }
    System.out.println(12345 + " | " + total / trials);
  }
}
