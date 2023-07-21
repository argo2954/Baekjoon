import java.io.*;
import java.util.*;
class Main {
  public static void main(String[] args) throws IOException{
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(in.readLine());
    boolean[] barr = new boolean[2000002];
    
    //입력
    for(int i=0; i<N; i++){
      int input = Integer.parseInt(in.readLine());
      barr[input+1000001] = true;
    }
      
    //정렬 및 출력
    for(int i=1; i<2000002; i++){
      if(barr[i]==true)
        out.write((i-1000001)+"\n");
    }
    
    in.close();
    out.close();
  }
}