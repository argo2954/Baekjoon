import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      // input| W&N-> int
      StringTokenizer stk = new StringTokenizer(br.readLine());
      int W = Integer.parseInt(stk.nextToken());
      int N = Integer.parseInt(stk.nextToken());
      // input| MP->int[][]
      int[][] MP = new int[N][2];
      for(int i=0; i<N; i++){
        stk = new StringTokenizer(br.readLine());
        MP[i][0] = Integer.parseInt(stk.nextToken());
        MP[i][1] = Integer.parseInt(stk.nextToken());
      }
      br.close();

      // sort| MP -> 1. 가격 내림차순, 2. 무게 내림차순
      Arrays.sort(MP, (o1, o2)->{
        return o1[1]!=o2[1]? o2[1]-o1[1]: o2[0]-o1[0];
      });

      // solve
      int totalPrice = 0;
      for(int[] mp: MP){
        int weight = Math.min(W, mp[0]);
        
        totalPrice += weight * mp[1];
        W -= weight;

        if(W==0) break;
      }

      System.out.println(totalPrice);
    }
}