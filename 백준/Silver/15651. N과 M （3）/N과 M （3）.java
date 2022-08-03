import java.io.*;
class Main {
  public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
  public static int n, m;
  
  public static void main(String[] args) throws IOException{
    String[] s = in.readLine().split(" ");
    n = Integer.parseInt(s[0]);
    m = Integer.parseInt(s[1]);
    
    f(0,"");

    in.close();
    out.close();
  }
  static void f(int d, String s) throws IOException{
    if(d==m){
      out.write(s + "\n");
      return;
    }
    for(int i=1; i<=n; i++){
      f(d+1, s+i+" ");
    }
    
  }
}