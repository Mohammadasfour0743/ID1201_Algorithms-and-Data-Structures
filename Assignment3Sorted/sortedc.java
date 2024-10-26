import java.util.Random;

public class sortedc {

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


    public static boolean sorted_search(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index+1] >= key) {
                return true;
                }
            }
        return false;
        }

        public static long bench(int n, int key) {

            //generate array with random numbers
            
            int[] array = generateSorted(n);
            
    
            long t0 = System.nanoTime();
            
            sorted_search(array, key);
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
                    //if(t < min){min = t;}
                }
    
                System.out.println(n + " | " + t/10 + "ns");
            }
        }
    
}
