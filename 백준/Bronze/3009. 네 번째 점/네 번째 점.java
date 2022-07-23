import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[][] arr = new int[3][2];
    //입력
    for(int i=0; i<3; i++){
      arr[i][0] = in.nextInt();
      arr[i][1] = in.nextInt();
    }

    //한번만 나온 숫자 찾기
    int x = arr[0][0];
    int y = arr[0][1];
    if(arr[1][0] != arr[2][0]){
      if(x==arr[1][0])
        x = arr[2][0];
      else
        x = arr[1][0];
    }
    if(arr[1][1] != arr[2][1]){
      if(y==arr[1][1])
        y = arr[2][1];
      else
        y = arr[1][1];
    }
      
    System.out.println(x + " " +  y);
  }
}