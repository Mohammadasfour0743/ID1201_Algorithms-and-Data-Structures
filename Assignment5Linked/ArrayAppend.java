public class ArrayAppend {

    public static int[] append(int[] a, int[] b){
        int n = a.length;
        int m = b.length;
        int[] c = new int[n + m];

        for (int i = 0; i < n; i++){
            c[i] = a[i];
        }
        for (int i = n; i < m; i++){
            c[i] = b[i];
        }

        return c;
    }

    public static long bench(int n, int m) {
        int[] a = new int[m];
        int[] b = new int[n];

        long t0 = System.nanoTime();
        append(a, b);
        long t1 = System.nanoTime();

        return t1-t0;
    }

    public static void main(String[] args) {

        //JIT warmup
        for (int i = 0; i < 10; i++){
            bench(5000, 5000);
        }


        int fixedSize = 100;
        int[] sizes =  { 100, 500, 1000, 3000, 5000, 8000, 10000};
        

        for (int n:sizes){
            
                long t = 0;
                for (int i = 0; i < 10; i++){
                   t =+ bench(n, fixedSize);
                }
                System.out.println(n + " | " + t/10 + "ns");
               }
           }
        
    
}
