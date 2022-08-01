import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in.nextInt();
    long m = in.nextInt();
    
    long cnt5 = f(n,5) - f(m,5) - f(n-m,5);
    long cnt2 = f(n,2) - f(m,2) - f(n-m,2);
    
    System.out.println(Math.min(cnt5, cnt2));
    in.close();
  } 
  
  static long f(long x, long y){
    long r = 0;
    long t = y;
    while(t<=x){
      r = r + x/t;
      t = t*y;
    }
    return r;
  }
}