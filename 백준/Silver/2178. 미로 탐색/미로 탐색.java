import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n, m;
  static int[][] miro;

  // MAIN FUNCTION //
  public static void main(String[] args) throws IOException {
    input();
    Graph g = new Graph(n, m);
    g.setAdjacent();
    System.out.println(g.BFS());
  }

  // INPUT FUNCTION //
  static void input() throws IOException {
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    miro = new int[n][m];
    for (int i = 0; i < n; i++) {
      char[] line = br.readLine().toCharArray();
      for (int j = 0; j < m; j++) {
        miro[i][j] = line[j] - '0';
      }
    }
  }

  // GRAPH //
  static class Graph {
    static class Node {
      int data = 1;
      boolean marked;
      boolean end = false;
      LinkedList<Node> adjacent;

      Node(boolean mark) {
        marked = mark;
        adjacent = new LinkedList<Node>();
      } // Node initial
    } // Node class

    Node[][] nodes;
    int n, m;
    int answer = 1;

    Graph(int n, int m) {
      this.n = n;
      this.m = m;
      nodes = new Node[n][m];
      for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
          boolean b = (miro[y][x]==1)? true: false;
          nodes[y][x] = new Node(b);
        }
      }
      nodes[n-1][m-1].end = true;
    } // Graph initial

    void addEdge(int y1, int x1, int y2, int x2) {
      if(y1<0 || x1<0 || y2<0 || x2<0) return;
      if(y1==n || x1==m || y2==n || x2==m) return;
      
      Node n1 = nodes[y1][x1];
      Node n2 = nodes[y2][x2];

      if (n1.marked || n2.marked) { // If marked was true both of them
        if (!n1.adjacent.contains(n2)) 
          n1.adjacent.add(n2);
        if (!n2.adjacent.contains(n1))
          n2.adjacent.add(n1);
      }

    } // Node to node setting

    void setAdjacent() { // connect between nodes
      for(int y=0; y<n; y++){
        for(int x=0; x<m; x++){
          if(miro[y][x] == 1){
            addEdge(y, x, y+1, x);
            addEdge(y, x, y-1, x);
            addEdge(y, x, y, x+1);
            addEdge(y, x, y, x-1);
          }
        }
      }
    }// connect between nodes

    int BFS() {
      Node root = nodes[0][0];
      Queue<Node> queue = new LinkedList<Node>();
      queue.offer(root);
      root.marked = false;
      
      while (!queue.isEmpty()) {
        Node r = queue.peek();
        int rdata = r.data;
        queue.remove();   
        for (Node n : r.adjacent) {
          if (n.marked) {
            n.data = rdata+1;
            
            if (n.end) {
              return n.data;
            }
            
            n.marked = false;
            queue.offer(n);
          }
        }
      }
    return 0;
    }
  }

}