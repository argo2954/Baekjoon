import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력| N
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		map = new int[N+1][M+1];
		
		// 입력(map) & dp
		for(int i=1; i<=N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				
				int max = Math.max(map[i][j-1], Math.max(map[i-1][j],map[i-1][j-1]));
				map[i][j] += max;
			}
		}
		
		// 출력
		System.out.println(map[N][M]);
	}

}