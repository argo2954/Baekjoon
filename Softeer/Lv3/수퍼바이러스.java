import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      // input| K&P -> int, N->long
      StringTokenizer stk = new StringTokenizer(br.readLine());
      int K = Integer.parseInt(stk.nextToken());
      int P = Integer.parseInt(stk.nextToken());
      long N = Long.parseLong(stk.nextToken());
      
      /*
       * (K * P^(10*N)) % 1000000007
       * mod 분배 법칙에 의해
       * ((K%1000000007) * ((P^(10*N))*1000000007)) % 100000007
       * (P^(10*N))*1000000007) 해결 필요
       */

      /*
       * P^163 = P^82 * P^82 * P^1
       */
      mod = 1000000007l;
      pows = new long[10];
      pows[0] = 1;
      
      for(int i=1; i<10; i++)
        pows[i] = (pows[i-1]%mod) * (P%mod) % mod;  
      

      System.out.println((K%mod) * (findPowValue(N*10)%mod) % mod);
    }


    static long mod;
    static long[] pows;
    static long findPowValue(long squareRoot){
      if(squareRoot<10){
        return pows[(int)squareRoot];
      }
      long half = findPowValue(squareRoot/2);

      if(squareRoot%2 == 1){
        return ((half%mod) * (pows[1]%mod) % mod)  * (half%mod) % mod;
      }

      return (half%mod) * (half%mod) % mod;
    }
  
}