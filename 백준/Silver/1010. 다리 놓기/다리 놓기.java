import java.io.*;
import java.util.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(in.readLine());
    while(T-->0){
      String[] s = in.readLine().split(" ");
      int n = Integer.parseInt(s[0]);
      int m = Integer.parseInt(s[1]);

      out.write(f(m,n) + "\n");
    }
    
    in.close();
    out.close();
  }
   //파스칼 법칙(점화식) 이용 
  //Memorization
  static int[][] me = new int[31][31];
  public static int f(int n, int k){
    if(me[n][k]!=0) return me[n][k];
    if(n==k || k==0){
      me[n][k] = 1;
      return 1;
    }
    if(n-k==1 || k==1){
      me[n][k] = n;
      me[n][n-k] = n;
      return n;
    }
    me[n][k] = f(n-1, k-1) + f(n-1, k);
    return me[n][k];
  }
  
}