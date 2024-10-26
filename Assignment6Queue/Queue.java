

public class Queue {
    Node head;
    private class Node {
        Integer item;
        Node next;

        private Node(Integer item, Node list) {
            this.item = item;
            this.next = list;
        }
    }
        
        public Queue() {
            head = null;
        }

        Queue(int n) {
            if (n <= 0){return;}
            head = new Node(0, null);
            Node c = head;
            for (int i = 1; i < n; i++){
                c.next = new Node(i, null);
                c = c.next;
            }
             
        }


        public void enqueue(Integer item) {
            Node n = new Node(item, null);
            
            if(head == null){head = n;}
           
            else{
            Node c = head;  
            while(c.next != null){
                c=c.next;
            }
            c.next = n;}
        }
        public Integer dequeue() {
            if(head == null){return null;}
            int a = head.item;
            head = head.next;
            return a;
        }

        public void printQueue(){
            Node c = head;
            while (c != null){
                System.out.println(c.item + " ");
                c = c.next;
            }
            System.out.println();
        }

        public static long benchenq(int size){
            Queue q = new Queue(size);

            long t0 = System.nanoTime();
            q.enqueue(5);
            long t1 = System.nanoTime();

            return t1-t0;
        }

        public static long benchdeq(int size){
            Queue q = new Queue(size);

            long t0 = System.nanoTime();
            q.dequeue();
            long t1 = System.nanoTime();

            return t1-t0;
        }

        public static void main(String[] args) {
            //JIT warmup
            for (int i = 0; i < 100; i++){
            benchenq(50);
        }

        int[] sizes =  { 100, 500, 1000, 3000, 5000, 8000, 10000};

        for (int n:sizes){
            
            long t = 0;
            for (int i = 0; i < 10; i++){
               t =+ benchenq(n);
            }
            System.out.println(n + " | " + t/10 + "ns");
           }

        }

    }
