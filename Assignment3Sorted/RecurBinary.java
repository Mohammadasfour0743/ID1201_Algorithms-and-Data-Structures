import java.util.Random;

public class RecurBinary {

    private static boolean recursive(int[] arr, int key, int min, int max) {
        // Base case: if the range is invalid, return false
        
        if (min > max) {
            return false;
        }
        

        // Find the middle index
        int mid = min + (max - min) / 2;

        // Base case, return true
        if (arr[mid] == key) {
            return true;
        }

        //  search in the left half
        if (arr[mid] > key) {
            
            return recursive(arr, key, min, mid - 1);
        }

        // search in the right half
        else {
            
            return recursive(arr, key, mid + 1, max);
        }
    }

    

    private static int[] generateSorted(int n) {

        //generate array with sorted random numbers
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
        nxt += rnd.nextInt(10) + 1;
        array[i] = nxt;
        }
        return array;
    }


    public static long bench(int n, int key) {

        //generate array with random numbers
        
        int[] array = generateSorted(n);
        int min = 0,max=array.length-1;

        long t0 = System.nanoTime();
        
        recursive(array, key, min, max);
        long t1 = System.nanoTime();
        return (t1 - t0);
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] sizes = { 1000000, 5000000, 10000000, 30000000, 50000000, 100000000};
        //Warm up JIT
        for (int i = 0; i < 100; i++){
            bench(100000, 10000);
        } 
        for (int n : sizes){       
            long t = 0;
            int key = rnd.nextInt(2 * n); 
            for (int i=0; i < 10; i++){
                
                
                t =+ bench(n, key);
                
            }

            System.out.println(n + " | " + t/10 + "ns");
        }
    }

     
    
}
