import java.io.*;
import java.util.LinkedList;
import java.util.Stack;


class Main {
  static int n, m;
  static int[] map;
  static Graph g;
  public static void main(String[] args) throws IOException{
    input();
    g.dfs();
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static void input() throws IOException{
    String[] input = br.readLine().split(" ");
    
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    g = new Graph(n);

    for(int i=0; i<m; i++){
      String[] s = br.readLine().split(" ");
      int u = Integer.parseInt(s[0]);
      int v = Integer.parseInt(s[1]);
      g.addEdge(u, v);
    }
  }
  static class Graph{
    static class Node{
      int data;
      boolean marked;
      LinkedList<Node> adjacent;

      Node(int data){
        this.data = data;
        marked = false;
        adjacent = new LinkedList<Node>();
      }
    }  // Node initial

    Node[] nodes;

    Graph(int size){
      nodes = new Node[size + 1];
      for(int i=0; i<=size; i++){
        nodes[i] = new Node(i);
      }
    }  // Graph initial
    void addEdge(int i1, int i2){
      Node n1 = nodes[i1];
      Node n2 = nodes[i2];
      
      n1.adjacent.add(n2);
      n2.adjacent.add(n1);
    }  // Set Node to Node
    
    void dfs() throws IOException{
      int answer = 0;
      
      for(Node root: nodes){
        if(root.marked) continue;
        
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
  
        while(!stack.isEmpty()){
          Node n = stack.pop();
          for(Node r: n.adjacent){
            if(!r.marked){
              stack.push(r);
              r.marked = true;
            }
          }
        }
        answer++;
      }
      
      bw.write((answer-1) + "\n");  // -1 mean: for(Node root: nodes) contains node(index 0), So -1 is except nodes[0]
      bw.flush();
    }
  }
}