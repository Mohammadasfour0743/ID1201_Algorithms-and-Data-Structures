import java.util.Random;

public class insertion {


    public static void sort(int[] elements) {
        int first = 0;
        int last = elements.length - 1;
        int current = first + 1;
        int hole;
        int e;
    
        while (current <= last) {
          e = elements[current];
          hole = current;
          while (hole > first && e < elements[hole - 1]) {
            elements[hole] = elements[hole - 1];
    
            hole--;
          }
    
          elements[hole] = e;
          current++;
        }
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
    int[] sizes =  { 1000, 5000, 10000, 30000, 50000, 100000};
 
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
