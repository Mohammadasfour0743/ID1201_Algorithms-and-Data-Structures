import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class T9 {

  private class Node {

    public Node[] next;
    public boolean valid;

    public Node() {
      next = new Node[27];
      valid = false;
    }
  }

  public Node root;

  public T9() {
    root = new Node();
  }

  private static int charTocode(char w) {
    switch (w) {
      case 'a':
        return 0;
      case 'b':
        return 1;
      case 'c':
        return 2;
      case 'd':
        return 3;
      case 'e':
        return 4;
      case 'f':
        return 5;
      case 'g':
        return 6;
      case 'h':
        return 7;
      case 'i':
        return 8;
      case 'j':
        return 9;
      case 'k':
        return 10;
      case 'l':
        return 11;
      case 'm':
        return 12;
      case 'n':
        return 13;
      case 'o':
        return 14;
      case 'p':
        return 15;
      case 'r':
        return 16;
      case 's':
        return 17;
      case 't':
        return 18;
      case 'u':
        return 19;
      case 'v':
        return 20;
      case 'x':
        return 21;
      case 'y':
        return 22;
      case 'z':
        return 23;
      case 'å':
        return 24;
      case 'ä':
        return 25;
      case 'ö':
        return 26;
    }
    return -1;
  }

  public static int keyToIndex(char key) {
    switch (key) {
      case '1':
        return 0;
      case '2':
        return 1;
      case '3':
        return 2;
      case '4':
        return 3;
      case '5':
        return 4;
      case '6':
        return 5;
      case '7':
        return 6;
      case '8':
        return 7;
      case '9':
        return 8;
      default:
        return -1;
    }
  }

  public static char[] IndexToCharArray(int key) {
    char[] a = { 'a', 'b', 'c' };
    char[] b = { 'd', 'e', 'f' };
    char[] c = { 'g', 'h', 'i' };
    char[] d = { 'j', 'k', 'l' };
    char[] e = { 'm', 'n', 'o' };
    char[] f = { 'p', 'r', 's' };
    char[] g = { 't', 'u', 'v' };
    char[] h = { 'x', 'y', 'z' };
    char[] i = { 'å', 'ä', 'ö' };
    switch (key) {
      case 0:
        return a;
      case 1:
        return b;
      case 2:
        return c;
      case 3:
        return d;
      case 4:
        return e;
      case 5:
        return f;
      case 6:
        return g;
      case 7:
        return h;
      case 8:
        return i;
      default:
        return a;
    }
  }

  public void add(String input) {
    char[] word = input.toCharArray();
    Node n = root;
    int current;
    for (char c : word) {
      current = charTocode(c);
      if (n.next[current] == null) {
        n.next[current] = new Node();
      }
      n = n.next[current];
    }
    n.valid = true;
  }

  public ArrayList<String> decode(String inpuString) {
    ArrayList<String> output = new ArrayList<>();
    char[] comb = inpuString.toCharArray();
    int[] index = new int[comb.length];
    int i = 0;
    for (char c : comb) {
      index[i++] = keyToIndex(c);
    }

    collect(output, "", index, comb.length, root);
    return output;
  }

  public void collect(
    ArrayList<String> output,
    String path,
    int[] index,
    int Orglength,
    Node n
  ) {
    // Base case: If the path has reached the length of the input sequence
    if (path.length() == Orglength) {
      if (n.valid) { // If the node is a valid end of a word
        output.add(path); // Add the word to the output list
      }
      return;
    }

    // Get the current digit index from the input sequence
    int currentIteration = path.length();
    int keyIndex = index[currentIteration];

    // Get possible characters for the current key press
    char[] indexChars = IndexToCharArray(keyIndex);

    // Explore each possible character branch in the Trie
    for (char letter : indexChars) {
      int nextNodeCode = charTocode(letter);
      Node nextNode = n.next[nextNodeCode]; //Go to next node

      if (nextNode != null) { // If the branch exists
        collect(output, path + letter, index, Orglength, nextNode);
      }
    }
  }

  public static void main(String[] args) {
    T9 t9 = new T9();
    String filePath = "kelly.txt"; // Adjust the path if needed

    // Step 1: Read words from the file and populate the T9 tree
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        t9.add(line.trim()); // Add each word to the T9 tree
        //System.out.println("Added word: " + line.trim()); // Debug: Print each word added
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Test decoding the key sequences
    String keySequence1 = "225"; //
    String keySequence2 = "117"; //
    String keySequence3 = "617"; //

    // Perform decoding and print the results
    System.out.println(
      "Words for key sequence " + keySequence1 + ": " + t9.decode(keySequence1)
    );

    // Test with a sequence that doesn't match any words
    String keySequence4 = "999";
  }
}
