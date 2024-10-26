public class tree {

  private class Node {

    private String value;
    private Node left, right;

    private Node(String value) {
      this.value = value;
      this.left = this.right = null;
    }

    public void print() {
      if (left != null) left.print();
      System.out.println(value);
      if (right != null) right.print();
    }
  }

  private Node root;

  public tree() {
    root = null;
  }

  public void display() {
    root.print();
  }

  public void addtree(Node n) {
    root = n;
  }

  public void printtree() {
    Queue<Node> q = new Queue<>();
    Node a = this.root;
    Node prnt = null;

    q.enqueue(a);
    Node current = a;

    while (current != null) {
      current = q.dequeue();
      prnt = current;
      if (current != null) {
        System.out.println(prnt.value);
      } else {
        return;
      }

      q.enqueue(current.left);
      q.enqueue(current.right);
    }
  }

  public static void main(String[] args) {
    tree t = new tree();
    Node a = t.new Node("A");
    Node b = t.new Node("B");
    Node c = t.new Node("C");
    Node d = t.new Node("D");
    Node e = t.new Node("E");
    Node f = t.new Node("F");
    Node g = t.new Node("G");
    Node h = t.new Node("H");
    Node i = t.new Node("I");
    Node j = t.new Node("J");
    Node k = t.new Node("K");
    Node l = t.new Node("L");
    Node m = t.new Node("M");
    Node n = t.new Node("N");
    Node o = t.new Node("O");
    Node p = t.new Node("P");

    tree t2 = new tree();

    t.addtree(a); //root A

    a.left = b;
    a.right = c;

    b.left = d;
    b.right = e;

    c.left = f;
    c.right = g;

    d.left = h;
    d.right = i;

    /* 
        e.left = j;
        e.right = k;

        f.left = l;
        f.right = m;

        g.left= n;
        g.right=o;*/

    //Sequence sequence = t.new Sequence(t2);

    Sequence sequence = t.new Sequence(t);

    sequence.next();

    sequence.next();
    c.left = null;
    sequence.next();

    sequence.next();

    sequence.next();

    sequence.next();
    sequence.next();

    sequence.next();
    //sequence.next();

  }

  /* 
    public static void main(String[] args) {
        tree t = new tree();
        Node a = t.new Node("A");
        Node b = t.new Node("B");
        Node c = t.new Node("C");
        Node d = t.new Node("D");
        Node e = t.new Node("E");
        Node f = t.new Node("F");
        Node g = t.new Node("G");
        Node h = t.new Node("H");
        Node i = t.new Node("I");
        Node j = t.new Node("J");
        Node k = t.new Node("K");
        Node l = t.new Node("L");
        Node m = t.new Node("M");
        Node n = t.new Node("N");
        Node o = t.new Node("O");

        
        t.addtree(a);//root A

        a.left= b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        d.left = h;
        d.right = i;

        e.left = j;
        e.right = k;

        f.left = l;
        f.right = m;

        g.left= n;
        g.right=o;

        t.printtree();

        
        

        
    }*/

  public class Sequence {

    tree t = new tree();
    Queue<Node> seq;

    public Sequence(tree t2) {
      this.seq = new Queue<>();

      if (t2.root == null) {
        throw new IllegalArgumentException("Tree is empty :(");
      }
      t.root = t2.root;
      seq.enqueue(t.root);
    }

    public String next() {
      Node a = t.root;
      Node current = a;
      if (seq.isEmpty() == true) {
        throw new IllegalArgumentException("No more elements in tree");
      }
      current = seq.dequeue();

      System.out.println(current.value);

      if (current.left != null) {
        seq.enqueue(current.left);
      }
      if (current.right != null) {
        seq.enqueue(current.right);
      }
      return current.value;
    }
  }
}
