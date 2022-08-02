import java.util.*;
class Main {
  public static boolean[] check; 
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    check = new boolean[n+1];
    
    f(n,m,0,"");
    
    in.close();
  }
  static void f(int n, int m, int d, String s){
    if(d==m){
      System.out.println(s);
      return;
    }
    for(int i=1; i<=n; i++){
      if(!check[i]){
        check[i] = true;
        f(n,m,d+1,s+i+" ");
        check[i] = false;
      }
    }
    
  }
}