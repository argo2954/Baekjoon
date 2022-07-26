import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    
    System.out.println(f(n)/f(k)/f(n-k));
  }
  public static int f(int a){
    if(a==0 || a==1) return 1;
    return a * f(a-1);
  }
}