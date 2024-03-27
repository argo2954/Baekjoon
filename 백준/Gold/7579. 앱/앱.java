import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] memories;	// 앱 정보{메모리}
	static int[] costs;	// 앱 정보{비용}
	static int[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력| N,M
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		// 입력| app 정보
		memories = new int[N+1];
		costs = new int[N+1];
		int sumOfCost = 0;
		StringTokenizer stk1 = new StringTokenizer(br.readLine());
		StringTokenizer stk2 = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			memories[i] = Integer.parseInt(stk1.nextToken());
			costs[i] = Integer.parseInt(stk2.nextToken());
			sumOfCost += costs[i];
		}
		
		// 선언 및 초기화|dp
		dp = new int[N+1][sumOfCost+1];
		for(int i=1; i<=N; i++) {	// i번째 까지의 app 기준, 0~sumOfCost의 비용을 사용했을 때 최대 메모리확인
			for(int j=0; j<=sumOfCost; j++) {
				if(j - costs[i] >= 0) {
					dp[i][j] = dp[i-1][j-costs[i]]+memories[i];
				}
				
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
			}
		}
		
		for(int i=0; i<=sumOfCost; i++) {
			if(dp[N][i] >= M) {
				System.out.println(i);
				return;
			}
		}
	}

}
