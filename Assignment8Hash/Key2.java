import java.io.BufferedReader;
import java.io.FileReader;

public class Key2 {

  Area[] postnr;
  int max = 100000;
  int a = 0;

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

  public Key2(String file) {
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
    Integer zipValue2 = Integer.valueOf(zipValue);
    return (postnr[zipValue2]);
  }

  public void collisions(int mod) {
    int mx = 20;
    int[] data = new int[mod];
    int[] cols = new int[mx];

    // keys[] are the zip codes
    for (int i = 0; i < max; i++) {
        if(postnr[i] == null){continue;}

      Integer index = postnr[i].code % mod;
      data[index]++;
    }

    for (int i = 0; i < mod; i++) {
      if (data[i] < mx) cols[data[i]]++;
    }

    System.out.print(mod + ": ");

    for (int i = 1; i < mx; i++) {
      System.out.print("\t" + cols[i]);
    }

    System.out.println();
  }

  public static long benchmark(Key2 zipfile, String zipValue) {
    long t0 = System.nanoTime();
    zipfile.lookup(zipValue);
    long t1 = System.nanoTime();

    return t1 - t0;
  }

  public static void main(String[] args) {
    String file = "postnummer.csv";
    String zipValue = "11115"; //"984 99” , "111 15"

    Key2 table = new Key2(file);
    table.collisions(14000);
}
}