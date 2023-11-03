import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      // input & init | N & schedules
      int N = Integer.parseInt(br.readLine());
      
      int[][] schedules = new int[N][2];
      
      for(int i=0; i<N; i++){
          StringTokenizer stk = new StringTokenizer(br.readLine());
          int start = Integer.parseInt(stk.nextToken());
          int end = Integer.parseInt(stk.nextToken());
          schedules[i][0] = start;
          schedules[i][1] = end;
      }

      // sort | schedules -> 1.끝나는 시간(오름차순) 2.시작시간(오름차순)
      Arrays.sort(schedules, (arr1, arr2)->{
          return arr1[1]!=arr2[1]? arr1[1]-arr2[1]: arr1[0]-arr2[0];
      });
      
      // solve | 
      int answer = 0;
      int end = 0;
      for(int[] schedule: schedules){
          if(end <= schedule[0]){
              answer++;
              end = schedule[1];
          }
      }
      
      System.out.println(answer);
    }
}