import java.io.BufferedReader;
import java.io.FileReader;

public class Key1 {

  Area[] postnr;
  int max = 100000;

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

  public Key1(String file) {
    this.postnr = new Area[this.max];
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;

      while ((line = br.readLine()) != null) {
        String[] row = line.split(",");
        Integer code = Integer.valueOf(row[0].trim().replaceAll("\\s", ""));
        postnr[code++] = new Area(code, row[1].trim(), Integer.valueOf(row[2]));
      }
    } catch (Exception e) {
      System.out.println(" file " + file + " not found");
    }
  }

  public Area lookup(String zipValue) {
    //convert input to Integer
    Integer zipValue2 = Integer.valueOf(zipValue);
    return (postnr[zipValue2]);
  }

  public boolean binarySearch(String zipValue) {
    boolean found = false;
    int min = 0;
    int max = this.max - 1;
    Integer input = Integer.valueOf(zipValue.trim());
    while (min < max) {
      int indx = (min + max) / 2;
      if (postnr[indx] == null) {
        break;
      }
      Integer fileZip = postnr[indx].code;
      if (fileZip == input) {
        found = true;
      } else if (input > fileZip && indx < max) {
        min = indx + 1;
      } else if (input < fileZip && indx > min) {
        max = indx - 1;
      }
    }
    return found;
  }

  public static long benchmark(Key1 zipfile, String zipValue) {
    long t0 = System.nanoTime();
    zipfile.binarySearch(zipValue);
    long t1 = System.nanoTime();

    return t1 - t0;
  }

  public static void main(String[] args) {
    String file = "postnummer.csv";
    String zipValue = "11115"; //"984 99” , "111 15"

    Key1 table = new Key1(file);
    long total = 0;
    int trials = 100;

    for (int i = 0; i < trials; i++) {
      long time = benchmark(table, zipValue);
      total += time;
    }
    System.out.println(zipValue + " | " + total / trials);
  }
}
