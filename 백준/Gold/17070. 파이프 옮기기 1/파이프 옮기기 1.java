import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리: 11828 KB
// 시간: 84 ms
public class Main {

	static int N;
	static long[][][] map; // 0(맵), 1(가로파이프), 2(세로파이프), 3(대각선파이프)
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력| N
		N = Integer.parseInt(br.readLine());
		map = new long[4][N+2][N+2];
		
		// 입력| 맵
		for(int i=1; i<=N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[0][i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		// 시간이 흐르고..
		map[1][1][2] = 1;
		for(int i=1; i<=N; i++) {
			for(int j=3; j<=N; j++) {
				if(map[0][i][j]==1) continue;

				map[1][i][j] = map[1][i][j-1] + map[3][i][j-1];
				map[2][i][j] = map[2][i-1][j] + map[3][i-1][j];
				
				if(map[0][i][j-1]!=1 && map[0][i-1][j]!=1) 
					map[3][i][j] = map[1][i-1][j-1] + map[2][i-1][j-1] + map[3][i-1][j-1];
			}
		}
		

		System.out.println(map[1][N][N] + map[2][N][N] + map[3][N][N]);
	}

}