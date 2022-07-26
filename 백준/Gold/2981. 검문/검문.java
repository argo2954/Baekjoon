//참고
//https://st-lab.tistory.com/155
import java.util.*;
class Main {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    //입력
    int N = in.nextInt();
    int[] arr = new int[N];
    for(int i=0; i<N; i++)
      arr[i] = in.nextInt();

    //배열 오름차순 정렬
    Arrays.sort(arr);

    //두 수 차이의 최대공약수
    int gcd = arr[1]-arr[0];
    for(int i=2; i<N; i++)
      gcd = gcd(gcd, arr[i]-arr[i-1]);

    //최대공약수의 약수를 찾아 출력
    for(int i=2; i<=gcd; i++)
      if(gcd%i==0) System.out.println(i);

    in.close();
  }
  //최대공약수 함수
  public static int gcd(int a, int b){
    while(b != 0){
      int r = a%b;
      a = b;
      b = r;
    }
    return a;
  }
}
