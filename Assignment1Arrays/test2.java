public class test2 {
    public static void main(String[] args) {
        int[] given = {0,1,2,3,4,5,6,7,8,9}; //test22222222222222222222222
            int sum = 0;
            for (int i = 0; i < 10; i++) {
            long t0 = System.nanoTime();
            sum += given[i];
            long t1 = System.nanoTime();
            System.out.println("one operation in " + (t1 - t0) + " ns");
    }
}

}
