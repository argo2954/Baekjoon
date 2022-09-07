import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException{
    //입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] input = new String[N];
    for(int i=0; i<N; i++)
      input[i] = br.readLine();

    int t = 0;
    while(t<N){
      //변수
      int answer = 0;
      String s = input[t];
      int len = s.length();
      
      //전부 순회하며 최대중량 구하기 
      int cnt = 0;
      for(int i=0; i<len; i++){
        // X인 경우 cnt=0으로 변경
        if(s.charAt(i)=='X') cnt = 0;
        // O인 경우 cnt++하고, asnwer+=cnt
        else answer += ++cnt;
      }

      System.out.println(answer);
      t++;
    }

    br.close();
  }
}