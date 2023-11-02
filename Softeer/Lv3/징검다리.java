import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      // input| N->int, Ai->int[]
      int N = Integer.parseInt(br.readLine());

      StringTokenizer stk = new StringTokenizer(br.readLine());
      int[] Ai = new int[N];
      for(int i=0; i<N; i++){
        Ai[i] = Integer.parseInt(stk.nextToken());
      }

      // init| step->int[]: DP를 위한 배열
      int[] step = new int[N];
      
      // solve| step 이전 스탭과 비교해 값 더하기
      int max = 0;
      for(int currentStep=1; currentStep<N; currentStep++){
        for(int previousStep=0; previousStep<currentStep; previousStep++){
          if(step[previousStep] >= step[currentStep] && Ai[previousStep] < Ai[currentStep]){
            step[currentStep] = step[previousStep]+1;
            
            if(step[currentStep] > max)
              max = step[currentStep];
          }
        }
      }

      // print
      System.out.println(max+1);
    }
}