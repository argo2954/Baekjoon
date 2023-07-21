import java.io.*;
import java.util.*;
class Main {
  public static void main(String[] args) throws IOException{
    //입력
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(in.readLine());
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    for(int i=0; i<N; i++)
      heap.add(Integer.parseInt(in.readLine()));

    //정렬 및 출력
    for(int i=0; i<N; i++)
      out.write(heap.poll() + "\n");
    
    in.close();
    out.close();
  }
}