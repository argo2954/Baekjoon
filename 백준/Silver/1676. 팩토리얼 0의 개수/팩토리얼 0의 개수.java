import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    //5미만이라면 0출력
    if(n<5){
      System.out.println(0);
      return ;
    }
    //5이상인 경우
    int answer = 0;
    for(int i=5; i<=n; i++){
      int t = i;
      //해당 되는 숫자를 5로 나누어 5의 개수 count
      while(t%5==0){
        answer++;
        t /= 5;
      }
    }
    System.out.println(answer);
  }
}