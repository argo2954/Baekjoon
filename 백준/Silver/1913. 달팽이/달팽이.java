import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.LinkedList;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int N2 = Integer.parseInt(br.readLine());
    int x = 0;
    int y = 0;
    
    Arr arr = new Arr(N);
    arr.setAdj();
    arr.dfs();

    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        bw.write(arr.nodes[i][j].data + " ");
        if(arr.nodes[i][j].data==N2){
          y = i+1;
          x = j+1;
        }
      }
      bw.newLine();
    }
    bw.write(y + " " + x + "\n");
    bw.flush();
  }

  static class Arr{
    class Node{
      int data;
      boolean marked;
      LinkedList<Node> adjacent;

      Node(){
        data = 1;
        marked = false;
        adjacent = new LinkedList<Node>();
      }
    }

    Node[][] nodes;
    int size;
    Arr(int size){
      this.size = size;
      nodes = new Node[size][size];

      for(int i=0; i<size; i++){
        for(int j=0; j<size; j++){
          nodes[i][j] = new Node();
        }
      }
    }

    void addEdge(int y1, int x1, int y2, int x2){
      Node n1 = nodes[y1][x1];
      Node n2 = nodes[y2][x2];

      if(!n1.adjacent.contains(n2)){
        n1.adjacent.add(n2);
        n2.adjacent.add(n1);
      }
    }

    void setAdj(){
      int half = size/2;
      for(int i=0; i<half; i++){
        for(int j=0; j<size-1; j++){
          addEdge(j, i, j+1, i);
          addEdge(j, size-i-1, j+1, size-i-1);
          addEdge(i, j, i, j+1);
          addEdge(size-i-1, j, size-i-1, j+1);
        }
      }
    }

    void dfs(){
      Node root = nodes[0][0];
      root.data = size*size;
      root.marked = true;
      
      Stack<Node> stack = new Stack<Node>();
      stack.push(root);

      while(!stack.isEmpty()){
        Node n = stack.pop();
        int data = n.data;
        
        for(Node r: n.adjacent){
          if(!r.marked){
            r.data = data-1;
            r.marked = true;
            stack.push(r);
            break;
          }
        }
      }
    }
  }
}