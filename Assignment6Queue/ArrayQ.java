import java.util.NoSuchElementException;

public class ArrayQ {
    private int[] q;
    private int i; //index of first element
    private int k; //index of first free slot
    private int qsize; //nb of elements in queue
    private int n; //qsize of array

    public ArrayQ(int capacity){
        q = new int[capacity];
        i=0; k=0; qsize = 0;
        n = capacity;
    }

    public void enq(int item){
        if (k == i && qsize != 0){
            
            int[] biggerQ = new int[n * 2];
            for(int j=0; j < qsize ;j++){
                biggerQ[j] = q[(i + j) % n];
            }
            q =  biggerQ;
            i = 0;
            k = qsize;
            n = n * 2;
        }
        
        q[k] = item;
        k = (k + 1) % n;
        qsize++;   
    }

    public int deq(){

        if (qsize == 0){
            throw new NoSuchElementException("Queue is empty");}

        int a = q[i];
        q[i] = 0; //set to null
        i = (i + 1)%n;
        qsize--;

        return a;

    }

    public void printQ(){
        for (int j = 0; j < n; j++) {
            System.out.print(q[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQ queue = new ArrayQ(5);

        

        
        queue.printQ();

        queue.enq(1);
        queue.enq(2);
        queue.enq(3);
        queue.enq(4);
        queue.deq();
        queue.enq(5);
        queue.enq(6);
        queue.enq(7);
        
        
        System.out.println();
        queue.printQ();
        
        System.out.println(queue.deq());
        System.out.println(queue.deq());
        System.out.println(queue.deq());

        queue.printQ();

        queue.enq(11);
        queue.enq(12);
        queue.enq(13);
        queue.enq(14);
        queue.enq(15);
        queue.enq(16);
        queue.enq(17);
        //queue.enq(18);
        queue.printQ();
        
    }
}
