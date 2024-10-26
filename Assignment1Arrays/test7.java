import java.util.Random;

public class test7 {

    

    
    public static void main(String[] args) {
        int[] sizes = {100, 200, 400, 800, 1600, 3200};
        // JIT warmup
        bench(1000,10000000);
        int loop = 1000;
        int k = 10;
        for(int n : sizes) {
            long min = Long.MAX_VALUE;
            for (int i = 0; i < k; i++) {
            long t = bench(n, loop);
            if (t < min) min = t;
            }
            System.out.println(n + " " + min + " ns");
        }
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
