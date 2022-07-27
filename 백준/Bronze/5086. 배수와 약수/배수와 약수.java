import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
    while(true){
      int a = in.nextInt();
      int b = in.nextInt();
      if(a==b && a==0) break;

      if(b%a==0) System.out.println("factor");
      else if(a%b==0) System.out.println("multiple");
      else
        System.out.println("neither");
    }
    in.close();
  }
}