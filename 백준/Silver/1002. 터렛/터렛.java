import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    //테스트 케이스 입력    
    int T = in.nextInt();
    while(T-- > 0){
      //xyr xyr2 입력
      int[] xyr = new int[6];//x, y, r, x, y, r
      for(int i=0; i<6; i++)
        xyr[i] = in.nextInt();

      //연산
      int dist = (xyr[0]-xyr[3])*(xyr[0]-xyr[3]) 
        + (xyr[1]-xyr[4])*(xyr[1]-xyr[4]);//두 원의 중심 사이의 거리 제곱
      //무한대일 때
      if(dist == 0 && xyr[2]==xyr[5])
        System.out.println(-1);
      //1개일 때
      else if(dist == (xyr[2]+xyr[5])*(xyr[2]+xyr[5])) //외접
        System.out.println(1);
      else if(dist == (xyr[2]-xyr[5])*(xyr[2]-xyr[5]))//내접
        System.out.println(1);    
      //0개일 때
      else if(dist > (xyr[2]+xyr[5])*(xyr[2]+xyr[5]))//두 원이 떨어져 있을 때
        System.out.println(0);
      else if(dist < (xyr[2]-xyr[5])*(xyr[2]-xyr[5]))//한 원이 들어가 있을 때
        System.out.println(0);
      //2개일 때
      else
        System.out.println(2);
    }
  }
}