import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();

    int max = 0;
    int min = 1000000;
    while(N-- > 0){
      int a = in.nextInt();
      if(max<a) max = a;
      if(min>a) min = a;
    }
    System.out.println(max*min);
    
    in.close();
  }
}