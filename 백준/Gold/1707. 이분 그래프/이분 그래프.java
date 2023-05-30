import java.util.*;
import java.io.*;

class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Buffered Reader
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // Buffered Writer
  public static void main(String[] args) throws IOException{
    
    int K = Integer.parseInt(br.readLine());
    
    for(int i=0; i<K; i++){
      String[] VE = br.readLine().split(" ");
      int V = Integer.parseInt(VE[0]);
      int E = Integer.parseInt(VE[1]);
      
      Graph g = new Graph(V);

      for(int j=0; j<E; j++){
        String[] link = br.readLine().split(" ");
        int u = Integer.parseInt(link[0]);
        int v = Integer.parseInt(link[1]);

        g.addEdge(u, v);
      }

      g.loop();
    }
    bw.flush();
  }

  static class Graph{
    class Node{
      boolean marked;
      boolean status;
      LinkedList<Node> adjacent;

      Node(){
        marked = false;
        status = false;
        adjacent = new LinkedList<Node>();
      }  // Node initial
    }  // Class Node

    Node[] nodes;
    
    Graph(int size){
      nodes = new Node[size+1];

      for(int i=0; i<=size; i++){
        nodes[i] = new Node();
      }
    }  // Graph initial

    void addEdge(int i1, int i2){
      Node n1 = nodes[i1];
      Node n2 = nodes[i2];

      n1.adjacent.add(n2);
      n2.adjacent.add(n1);
    }  // linking Node to Node

    void loop() throws IOException{
      int size = nodes.length;
      for(int i=1; i<size; i++){
        if(!find(nodes[i]))
          return;
      }

      bw.write("YES\n");
    }  // Loop function(1~size), for calling find method

    boolean find(Node root) throws IOException{
      if(root.marked) return true;
      
      Queue<Node> queue = new LinkedList<Node>();
      queue.offer(root);
      root.marked = true;
      
      while(!queue.isEmpty()){
        Node n = queue.peek();
        queue.remove();
        
        for(Node r: n.adjacent){
          if(r.marked){
            if(r.status == n.status){
              bw.write("NO\n");
              return false;
            }
          }
          
          if(!r.marked){
            r.status = !n.status;
            r.marked = true;
            queue.offer(r);
          }
        }
      }

      return true;
    }  // Function to find Bipartite Graph
  }  // Class Graph
}