import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt();
            int M = sc.nextInt();
            
			int[] Ai = new int[N];
            int[] Bi = new int[M];
            
            // input
            for(int i=0; i<N; i++){
            	Ai[i] = sc.nextInt();
            }
            for(int i=0; i<M; i++){
            	Bi[i] = sc.nextInt();
            }
            
            // swap
            if(N<M){
           		int tmp = N;
                N = M;
                M = tmp;
                
                int[] tmps = Ai;
                Ai = Bi;
                Bi = tmps;
            }
            
            
            int max = 0;
            for(int i=0; i<=N-M; i++){
                int mul = 0;
                for(int j=0; j<M; j++){
            	       mul += Ai[i+j]*Bi[j];
                }
                
                max = Math.max(max, mul);
            }
            
            System.out.println(String.format("#%d %d", test_case, max));
		}
	}
}