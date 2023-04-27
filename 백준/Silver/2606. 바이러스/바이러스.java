import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {
  static int n, m, answer = 0; // node count, line count, answer
  static int[][] links; // adjacent list between nodes
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Buffered Reader
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // Buffered Writer

  public static void main(String[] args) throws IOException {
    
    input();
    Graph g = new Graph(n);
    g.setAdjacent();
    g.findVirus();
    
    bw.write(answer-1 +"");
    bw.flush();
  }

  // GRAPH CLASS//
  static class Graph { // Graph class
    static class Node { // Node class
      int data;
      boolean marked;
      LinkedList<Node> adjacent;

      Node(int data) { // Node initial
        this.data = data;
        marked = false;
        adjacent = new LinkedList<Node>();
      }// Node initial
    }// Node class

    Node[] nodes;

    Graph(int size) { // Graph initial
      nodes = new Node[size + 1];
      for (int i = 0; i <= size; i++)
        nodes[i] = new Node(i);
    }// Graph initial

    void addEdge(int i1, int i2) { // to set adjacent(node to node)
      Node n1 = nodes[i1];
      Node n2 = nodes[i2];

      if (!n1.adjacent.contains(n2))
        n1.adjacent.add(n2);
      if (!n2.adjacent.contains(n1))
        n2.adjacent.add(n1);
    }// to set adjacent(node to node)

    void setAdjacent() { // connect between nodes
      for (int[] link : links) {
        addEdge(link[0], link[1]);
      }
    }// connect between nodes

    void findVirus() throws IOException{ // find the number of virus-infected computers from 1
      Queue<Node> queue = new LinkedList<Node>();
      Node root = nodes[1];
      queue.offer(root);
      root.marked = true;

      while (!queue.isEmpty()) {
        Node n = queue.peek();
        queue.remove();
        for (Node r : n.adjacent) {
          if (!r.marked) {
            r.marked = true;
            queue.offer(r);
          }
        }
      }

      for (Node n : nodes) {
        if (n.marked){
          answer++;
          // bw.write(n.data + "\n");
        }
      }
    }// Find the number of virus-infected computers from 1

  }// Graph class

  // INPUT FUNCTION//
  static void input() throws IOException { // input function
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    links = new int[m][2];
    for (int i = 0; i < m; i++) {
      String[] ab = br.readLine().split(" ");
      int a = Integer.parseInt(ab[0]);
      int b = Integer.parseInt(ab[1]);
      links[i][0] = a;
      links[i][1] = b;
    }
  }// input function
}