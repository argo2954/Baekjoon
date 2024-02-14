import java.io.*;
class Main {
  public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
  public static int n, answer;
  public static int[] chess;
  
  public static void main(String[] args) throws IOException{
    n = Integer.parseInt(in.readLine());
    chess = new int[n];
    f(0,0);

    out.write(answer + "\n");
    in.close();
    out.close();
  }
  static void f(int x, int q){
    //N개의 퀸을 놓았을 때 answer+1 , 함수종료
    if(q==n) {answer++; return;} 
    if(x==n) return;
    
    for(int i=0; i<n; i++){
      boolean flag = true;
      for(int j=0; j<x; j++){
        if(chess[j]==i || chess[j]+x-j==i || chess[j]-x+j==i){
          flag = false;
          break;
        }
      }
      if(flag){
        chess[x] = i;
        f(x+1, q+1);
      }
    }
  }
}