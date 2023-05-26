import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

class Main {
  public static void main(String[] args) throws IOException{
    input();
    System.out.println(g.find(start, end));
  }
  
  static Graph g;
  static int start, end;
  static void input() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int size = Integer.parseInt(br.readLine());
    g = new Graph(size);

    String[] startEnd = br.readLine().split(" ");
    start = Integer.parseInt(startEnd[0]);
    end = Integer.parseInt(startEnd[1]);

    int adjacent = Integer.parseInt(br.readLine());

    for(int i=0; i<adjacent; i++){
      String[] adj = br.readLine().split(" ");
      g.addEdge(Integer.parseInt(adj[0]), Integer.parseInt(adj[1]));
    }
  }

  static class Graph{
    static class Node{
      int index;
      int degree;
      boolean marked;
      LinkedList<Node> adjacent;

      Node(int index){
        this.index = index;
        degree = 1;
        marked = false;
        adjacent = new LinkedList<Node>();
      }
    }

    Node[] nodes;

    Graph(int size){
      nodes = new Node[size+1];
      for(int i=0; i<=size; i++){
        nodes[i] = new Node(i);
      }
    }

    void addEdge(int i1, int i2){
      Node n1 = nodes[i1];
      Node n2 = nodes[i2];
      n1.adjacent.add(n2);
      n2.adjacent.add(n1);
    }

    int find(int start, int end){
      Node root = nodes[start];

      Queue<Node> queue = new LinkedList<Node>();
      queue.offer(root);
      root.marked = true;

      while(!queue.isEmpty()){
        Node n = queue.peek();
        int degree = n.degree;
        queue.remove();
        
        for(Node r: n.adjacent){
          if(!r.marked){
            r.degree = degree+1;
            
            if(r.index == end)
              return degree;

            queue.offer(r);
            r.marked = true;
          }
        }
      }

      return -1;
    }
  }
}