import java.util.Random;

public class search {
    private static long search1(int n, int loop) {
    Random rnd = new Random();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
    array[i] = rnd.nextInt(n*2);
    }
    int[] keys = new int[loop];
    for (int k = 0; k < loop; k++) {
    keys[k] = rnd.nextInt(n*2);
    }
    int sum = 0;
    long t0 = System.nanoTime();
    for (int i = 0; i < loop; i++) {
    int key = keys[i];
    for (int j = 0; j < n; j++) {
    if (key == array[j]) {
    sum++;
    break;
    }
    }
    }
    long t1 = System.nanoTime();
    return (t1 - t0);
    }


    public static void main(String[] args) {
        int[] sizes = {100, 500, 2000, 5000, 10000};
        search1(10000, 100000);
        int loop = 15000;
        
        for (int n: sizes) {
            long min = Long.MAX_VALUE;
            for (int i = 0; i < 10; i++) {
                long t = search1(n, loop);
                if (t < min) {min = t;}
            }
            System.out.println(n + " " + min + "ns");

        }
    }


}
