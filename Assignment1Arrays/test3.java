import java.util.Random;

public class test3 {
    public static void main(String[] args) {
        int[] given = {0,1,2,3,4,5,6,7,8,9};
        Random rnd = new Random();
        int sum = 0;
        long t0 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
        sum += given[rnd.nextInt(10)];
        }
        
        long t1 = System.nanoTime();
        System.out.println(" one read operation in " + (t1 - t0)/1000 + " nanoseconds");
    }
}
