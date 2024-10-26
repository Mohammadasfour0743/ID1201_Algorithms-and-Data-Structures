import java.util.Random;

public class Binary {
    
public static boolean binary_search(int[] array, int key) {
    int first = 0;
    int last = array.length-1;
    while (true) {
        // jump to the middle
        int index = first + (last - first) / 2;

        if (array[index] == key) {
            //if element is in the middle, exit
            return true;
        }

        if (array[index] < key && index < last) {
        // if the key is on the right of the middle, move first pointer after the middle
            first = index + 1 ;
        
        }
        else if (array[index] > key && index > first) {
        // else if key on the left, move last pointer to the left of middle
            last = index - 1 ;}
        
        else {
            //if you reach here, then the element is not in the array
            return false;}
        }
        // Why do we land here? What should we do?
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
        

        long t0 = System.nanoTime();
        
        binary_search(array, key);
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




