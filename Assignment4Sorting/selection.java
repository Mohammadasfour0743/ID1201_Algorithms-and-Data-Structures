import java.util.Random;


public class selection {
    
   public static void sort(int[] elements) {
    int first = 0;
    int last = elements.length - 1;
    int current;
    int least;

    while (first < last) {
       least = first;
       current = first + 1;
       while (current <= last) {
          if (elements[current] < elements[least]) {
             least = current;            
          }
          current++;         
       }
       int p = elements[first];
       elements[first] = elements[least];
       elements[least] = p;

       first++;
       
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
   int[] sizes =  { 1000, 5000, 10000, 30000, 50000, 80000, 100000};

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
