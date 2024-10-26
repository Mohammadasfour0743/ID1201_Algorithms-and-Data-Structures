

class LinkedList {
    Cell first;
    private class Cell {
        int head; //Value stored inside the cell
        Cell tail; //reference to the next cell

        Cell(int val, Cell tl) {
            head = val;
            tail = tl;
        }
    }

    LinkedList() {
        first = null; 
    }

    LinkedList(int n) {
        if (n <= 0){return;}
        first = new Cell(0, null);
        Cell c = first;
        for (int i = 1; i < n; i++){
            c.tail = new Cell(i, null);
            c = c.tail;
        }
         
    }

    public void add(int item) {
        first = new Cell(item, first);
    }

    public int length(){
        if (first == null){
            return 0;
        }

        int count = 0;
        Cell c = first;
        while(c != null){
            count++;
            c = c.tail;
        }

        return count;

    }

    public boolean find(int item){
        if(first.head == item){
            return true;
        }
        
        Cell c = first;
        while(c != null){
            if (c.head == item){return true;}
            c=c.tail;
        }
        return false;
    }

    public void printlist(){
        Cell c = first;
        while (c != null){
            System.out.println(c.head + " ");
            c = c.tail;
        }
        System.out.println();
    }

    public void remove(int item){
        if (first == null){return;}

        if (first.head == item){
            first = first.tail;
            return;
        }

        Cell pre = first;
        while(pre.tail != null){
            if (pre.tail.head == item){
                pre.tail = pre.tail.tail;
                return;
            }
            pre = pre.tail;
        }
    }

    public int pop(){
        int a = first.head;
        first = first.tail;
        return a;
    }

    public void append(LinkedList b) {
        
        if (b.first == null){return;}

        Cell c = this.first;
        if (c == null){c = b.first; return;}
        
        while(c.tail != null){
            c = c.tail;
        }

        c.tail = b.first;
        b.first = null;
        
        }

 
    public static long bench(int SizeA, int SizeB){
        LinkedList a = new LinkedList(SizeA);
        LinkedList b = new LinkedList(SizeB);

        long t0 = System.nanoTime();
        a.append(b);
        long t1 = System.nanoTime();

        return t1-t0;
    }





    public static void main(String[] args) {
        LinkedList l = new LinkedList(3);

        l.printlist();

        l.add(15);
        System.out.println(l.pop());

        System.out.println();
        l.printlist();
    }
    
/*
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
           } */
        
    }



    