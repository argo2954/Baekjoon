import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Graph g = new Graph(N);

    for(int i=1; i<N; i++){
      String[] links = br.readLine().split(" ");
      int n = Integer.parseInt(links[0]);
      int m = Integer.parseInt(links[1]);
      g.addEdge(n, m);
    }
    
    g.find();
  }

  static class Graph{
    class Node{
      int data;
      boolean marked;
      LinkedList<Node> adjacent;

      Node(int data){
        this.data = data;
        marked = false;
        adjacent = new LinkedList<Node>();
      }
    }

    Node[] nodes;
    int size;
    
    Graph(int size){
      this.size = size+1;
      nodes = new Node[this.size];
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

    void find(){
      int[] answer = new int[size];
      Arrays.fill(answer, 0);
      Node root = nodes[1];
      root.marked = true;
      
      Queue<Node> queue = new LinkedList<Node>();
      queue.offer(root);

      while(!queue.isEmpty()){
        Node n = queue.peek();
        int parent = n.data;
        queue.remove();
        
        for(Node r: n.adjacent){
          if(!r.marked){
            r.marked = true;
            if(answer[r.data] == 0){
              answer[r.data] = parent;
            }
            queue.offer(r);
          }
        }
      }

      for(int i=2; i<size; i++){
        System.out.println(answer[i]);
      }
    }
  }
}