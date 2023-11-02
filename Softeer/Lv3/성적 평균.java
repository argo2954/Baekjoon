package Lv3;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      // input| N&K -> int
      StringTokenizer stk = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(stk.nextToken());
      int K = Integer.parseInt(stk.nextToken());

      // input| Si -> int[]
      stk = new StringTokenizer(br.readLine());
      int[] Si = new int[N];
      
      for(int i=0; i<N; i++){
        Si[i] = Integer.parseInt(stk.nextToken());
      }
        
      // solve&print
      for(int i=0; i<K; i++){
        // input| start&end -> int: 구간 시작~끝
        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        int sum = 0;
        for(int j = start-1; j<end; j++){
          sum += Si[j];
        }
    
        bw.write(String.format("%.2f\n", (float)sum/(end-start+1)));
      }

      bw.flush();
      br.close();
      bw.close();
    }
}