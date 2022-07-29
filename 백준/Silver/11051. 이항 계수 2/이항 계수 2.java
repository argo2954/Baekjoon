import java.util.*;
class Main {
  static final int M = 10007;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();

    System.out.println(f(n,k));
    
    in.close();
  }
  
  //파스칼 법칙(점화식) 이용 
  //Memorization
  static int[][] me = new int[1001][1001];
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
    me[n][k] = (f(n-1, k-1)%M + f(n-1, k)%M)%M;
    return me[n][k];
  }
}