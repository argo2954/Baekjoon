import java.io.*;
import java.util.*;

class Main {
  static int n, m, v; // node count, line count, top number
  static int[][] links; // adjacent list between nodes
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Buffered Reader
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // Buffered Writer

  // Graph class //
  static class Graph {
    static class Node { // Node class
      int data;
      LinkedList<Node> adjacent;
      boolean marked;

      Node(int data) { // Node initial
        this.data = data;
        this.marked = false;
        adjacent = new LinkedList<Node>();
      }
    }// Node class

    Node[] nodes; // Node list

    Graph(int size) { // Graph initial
      nodes = new Node[size + 1];
      for (int i = 0; i <= size; i++) {
        nodes[i] = new Node(i);
      }
    }// Graph initial

    void nodeClear() { // to clear marked in node of nodes
      for (Node n : nodes)
        n.marked = false;
    }// to clear(false) the marked in node of nodes

    void addEdge(int i1, int i2) { // Node to node setting
      Node n1 = nodes[i1];
      Node n2 = nodes[i2];
      if (!n1.adjacent.contains(n2)) {
        n1.adjacent.add(n2);
      }
      if (!n2.adjacent.contains(n1)) {
        n2.adjacent.add(n1);
      }
    }// to set adjacent(node to node)

    void setAdjacent() { // connect between nodes & sort adjacent in nodes
      for (int[] link : links) {
        addEdge(link[0], link[1]);
      }
      for (Node node : nodes) {// ascending
          Collections.sort(node.adjacent, (o1, o2) ->  o1.data - o2.data);
      }
    }// connect between nodes & sort adjacent in nodes
    
    void dfs(int index) throws IOException { // depth first search by index
      Node root = nodes[index];
      Stack<Node> stack = new Stack<Node>();
      stack.push(root);
      root.marked = true;
      visit(root);
      
      while (!stack.empty()) {
        Node r = stack.peek();
        boolean noAdjacent = true;
        for (Node n : r.adjacent) {
          if (!n.marked) {
            n.marked = true;
            visit(n);
            stack.push(n);

            noAdjacent = false;
            break;
          }
        }
        if(noAdjacent) stack.pop();
      }
      bw.newLine();
      bw.flush();
    }// depth first search by index

    void bfs(int index) throws IOException { // breadth first search by index
      nodeClear();
      Node root = nodes[index];
      Queue<Node> queue = new LinkedList<Node>();
      queue.offer(root);
      root.marked = true;

      while (!queue.isEmpty()) {
        Node r = queue.peek();
        queue.remove();
        for (Node n : r.adjacent) {
          if (!n.marked) {
            n.marked = true;
            queue.offer(n);
          }
        }
        visit(r);
      }
      bw.newLine();
      bw.flush();
    }// breadth first search by index

    void visit(Node n) throws IOException { // print visit node
      bw.write(n.data + " ");
    }// print visit node
  }
  static void input() throws IOException { // input function
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);
    v = Integer.parseInt(input[2]);

    links = new int[m][2];
    for (int i = 0; i < m; i++) {
      String[] ab = br.readLine().split(" ");
      int a = Integer.parseInt(ab[0]);
      int b = Integer.parseInt(ab[1]);
      links[i][0] = a;
      links[i][1] = b;
    }
  }// input function

    // main //
  public static void main(String[] args) throws IOException {
    input();
    Graph g = new Graph(n);

    g.setAdjacent();
    g.dfs(v);
    g.bfs(v);
  }
}