import java.util.Random;

public class Merge2 {


    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        
        
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
        // for all indices from lo to hi
        for ( int k = lo; k <= hi; k++) {
        // if i is greater than mid then
        // move the j'th item to the org array, update j
        if(i > mid){
            org[k] = aux[j++];
        }
        // else if j is greate than hi then
        // move the i'th item to the org array, update i
        else if(j > hi){
            org[k] = aux[i++];
        }
        // else if the i'th item is smaller than the j'th item,
        // move the i'th item to the org array, update i
        else if(aux[i] < aux[j]){
            org[k] = aux[i++];
        }
        // else
        // move the j'th item to the org array, update j
        else {org[k] = aux[j++];}
        }
        }


        private static void sort(int[] org, int[] aux, int lo, int hi) {
            if (lo != hi) {
            int mid = (lo + hi)/2;
            // sort the items from lo to mid
            sort(aux, org, lo, mid);

            // sort the items from mid+1 to hi
            sort(aux, org, mid+1, hi);
            // merge the two sections using the additional array

            merge(org, aux, lo, mid, hi);
        }
    }


    public static void sort(int[] org) {
        if (org.length == 0)
        return;
        int[] aux = new int[org.length];
        //copy all elements to the aux array
        for (int i=0; i<org.length;i++){
            aux[i] = org[i];
        }
        //switch places of aux and org
        sort(aux, org, 0, org.length -1);
        }


        private static int[] generateRandom(int n) {
            Random rnd = new Random();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = rnd.nextInt(100); // Generate a random number between 0 and 99
            }
            return array;
         }
         
         public static long bench(int n) {
            int[] array = generateRandom(n);
         
            long t0 = System.nanoTime();
            sort(array);
            long t1 = System.nanoTime();
         
            return (t1-t0);
         
         }
    

         public static void main(String[] args) {
            //implement better sizes,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
             int[] sizes =  { 10000, 50000, 100000, 300000,400000, 500000,600000, 800000, 1000000};
          
             //Warm up JIT
             for (int i = 0; i < 10; i++){
                bench(100);
            }
            for (int n:sizes){
             long t = 0;
             for (int i = 0; i < 10; i++){
                t =+ bench(n);
                 
          
             }
             System.out.println(n + " | " + t/10 + "ns");
            }
          }
          
}
