import java.util.Random;

public class test6 {

    

    
    public static void main(String[] args) {
        int n = 1000;
        int loop = 1000;
        int k = 10;
        long min = Long.MAX_VALUE;
        long max = 0;
        long total = 0;
        bench(n, 1000000);
        for (int i = 0; i < k; i++) {
        long t = bench(n, loop);
        if (t > max) max = t;
        if (t < min) min = t;
        total += t;
        }

        System.out.println(" avg: " + ((double) total)/loop/k);
        System.out.println(" min: " + ((double) min)/loop);
        System.out.println(" max: " + ((double) max)/loop);
}

    

    public static  int run(int[] array, int[] indx) {
        int sum = 0;
        for (int i = 0; i < indx.length ; i++) {
        sum = sum + array[indx[i]];
        }
        return sum;
        }

    public static long bench(int n, int loop) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = i;

        Random rnd = new Random();

        int[] indx = new int[loop];
        for (int i = 0; i < loop; i++) indx[i] = rnd.nextInt(n);
        int sum = 0;

        long t0 = System.nanoTime();
        run(array, indx);
        long t1 = System.nanoTime();
        return (t1 - t0);
        }

    
}
