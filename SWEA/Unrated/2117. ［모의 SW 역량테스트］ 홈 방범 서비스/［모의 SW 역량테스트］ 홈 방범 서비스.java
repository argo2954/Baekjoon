import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N,M,answer;
	static int[][] map;	// 음수(집), 0이상(빈칸)
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		// testCase T
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			// 입력| N,M
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			
			// 입력| map
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				stk =  new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
					if(map[i][j]==1) map[i][j] = -401;
				}
			}

			// 도시 방위 산업 시작
			protect();
			
			// 결과 저장
			result.append("#").append(test_case).append(" ").append(answer).append("\n");
		}

		//출력
		System.out.println(result);
	}

	// 도시 방위 산업 메소드
	static void protect() {
		// 초기화
		answer = 0;
		int index = 1;
		
		// 맵을 순회하며 어느 인덱스에서 방범 서비스를 해야할지 파악
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				// 해당 인덱스에서 방범 서비스 개시
				service(index++, r, c);
			}
		}
	}
	
	// 범위 벗어났는지 확인 메소드
	static boolean isOut(int r, int c) {return r<0 || c<0 || r>=N || c>=N; }
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	// 방법 서비스 ON: BFS
	static void service(int index, int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		map[r][c] = map[r][c]<0? -index: index;
		queue.offer(new int[] {r,c});
		
		int k = 1;
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-->0) {
				int[] kan = queue.poll();
				r = kan[0]; 
				c = kan[1];
				
				// 이전에 방문하지 않은 집인 경우 
				if(map[r][c]==-index) count++;
				
				// 범위 확장 				
				for(int i=0; i<4; i++) {
					int newR = r+dr[i];
					int newC = c+dc[i];
					
					// 맵 사이즈를 벗어났거나, 이미 처리된 인덱스인 경우 
					if(isOut(newR, newC)) continue;
					if(map[newR][newC]==-index) continue;
					if(map[newR][newC]==index) continue;
					
					// 이전에 방문하지 않은 집인 경우 
					if(map[newR][newC]<0) map[newR][newC] = -index;
					// 빈칸인 경우
					else map[newR][newC] = index;
					queue.offer(new int[] {newR,newC});
				}
			}

			// 회사가 이득을 볼 수 있는 경우 (이득이 0인 경우도 포함)
			if(k*k+(k-1)*(k-1) <= count*M) {
				answer = Math.max(answer, count);
			}
			k++;
		}
	}
}
