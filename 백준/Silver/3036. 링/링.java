import java.util.*;
class Main {
  public static void main(String[] args) {
    //입력
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int[] arr = new int[N];
    for(int i=0; i<N; i++)
      arr[i] = in.nextInt();
    
    for(int i=1; i<N; i++){
      int gcd = gcd(arr[0], arr[i]);
      int a = arr[0]/gcd;
      int b = arr[i]/gcd;
      System.out.println(a+"/"+b);
    }
    
    in.close();
  }
  public static int gcd(int a, int b){
    while(b!=0){
      int r = a%b;
      a = b;
      b = r;
    }
    return a;
  }
}