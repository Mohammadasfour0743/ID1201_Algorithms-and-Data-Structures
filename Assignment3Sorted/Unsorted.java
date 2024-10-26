
import java.util.Random;

public class Unsorted {

    public static boolean unsorted_search(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
                }
            }
        return false;
        }
        
    public static long bench(int n, int key) {

        //generate array with random numbers
        Random rnd = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = rnd.nextInt(2 * n);

        long t0 = System.nanoTime();
        
        unsorted_search(array, key);
        long t1 = System.nanoTime();
        return (t1 - t0);
    }


    public static void main(String[] args) {
        Random rnd = new Random();
        int[] sizes = {1000000, 10000000, 25000000, 64000000};
        

        //Warm up JIT
        for (int i = 0; i < 100; i++){
            bench(100000, 10000);
        }
        
        
        for (int n : sizes){
            
            long t = 0;
            for (int i=0; i < 10; i++){
                int key = rnd.nextInt(2 * n);
                t =+ bench(n, key);
            }

            System.out.println(n + " | " + t/10 + "ns");
        }
    }

}
