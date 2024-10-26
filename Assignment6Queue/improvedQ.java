

public class improvedQ {
    Node head;
    Node tail;
    private class Node {
        Integer item;
        Node next;

        private Node(Integer item, Node list) {
            this.item = item;
            this.next = list;
        }
    }
        
        public improvedQ() {
            head = null;
            tail=null;
        }

        improvedQ(int n) {
            if (n <= 0){return;}
            head = new Node(0, null);
            
            Node c = head;
            for (int i = 1; i < n; i++){
                c.next = new Node(i, null);
                c = c.next;
            }
            tail = c;
             
        }


        public void improvedenq(Node n) {
           
            
            if (head == null){
                head = n;}

            if(tail != null){
                tail.next = n;
            }
            tail = n;   
        }

        public Node dequeue() {
            if(head==null){return null;}
            
            Node a = head;
            head = head.next;
            a.next = null;
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

        

        public static void main(String[] args) {
            improvedQ queue = new improvedQ();
            Node a = queue.new Node(10, null);
            Node a2 = queue.new Node(20, null);
            Node a3 = queue.new Node(300, null);

            queue.improvedenq(a);
            queue.improvedenq(a2);
            queue.improvedenq(a3);

            queue.dequeue();
            queue.printQueue();

        }

    }
