import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    //입력
    int K = in.nextInt();
    int max1 = 0;
    int max2 = 0;
    int[][] arr = new int[12][2];
    for(int i=0; i<6; i++){
      arr[i][0] = arr[i+6][0] = in.nextInt();
      arr[i][1] = arr[i+6][1] = in.nextInt();
      if(i%2==0 && max1<arr[i][1]) max1 = arr[i][1];
      if(i%2==1 && max2<arr[i][1]) max2 = arr[i][1];
    }
    
    //연산
    int answer = max1 * max2;
    for(int i=2; i<=7; i++){
      if(arr[i-2][0]==arr[i][0] && arr[i-1][0]==arr[i+1][0]){
        System.out.println(K*(answer-arr[i-1][1]*arr[i][1]));
        return;
      }
    }
  }
}