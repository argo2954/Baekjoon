import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int N,answer;
	static int[][] map; // 가게별 디저트 정보 
	static boolean[][] visit;
	static boolean[] dessert;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		// testCase T
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			//입력| 디저트 
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			// 맛집 탐방
			findJMT();
			
			// 결과 저장 
			if(answer==0) answer = -1;
			result.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(result);
	}
	
	// 범위 벗어났는지 확인 메소드 
	static boolean isOut(int r, int c) {return r<0 || c<0 || r>=N || c>=N;}
	
	// 이동 경로: 오위 -> 오아 -> 왼아 -> 왼위
	static int[] dr = {-1,1,1,-1};
	static int[] dc = {1,1,-1,-1};
	
	// 맛집탐방
	static void findJMT() {
		answer = 0;
		
		// 맵 순회하면서 맛집 탐방 시작 
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				// 사각형으로 돌 수 있는지 확인
				row  = r;
				col = c;
				visit = new boolean[N][N];
				visit[r][c] = true;
				dessert = new boolean[101];
				dessert[map[r][c]] = true;
				search(r,c,1,0);
			}
		}
	}
	
	static int row,col;
	static void search(int r, int c, int count, int direction) {
		for(int i=0; i<2; i++) {
			int d = direction+i;
			if(d==4) break;
			
			int newR = r+dr[d];
			int newC = c+dc[d];
			
			if(newR==row && newC==col) answer = Math.max(answer, count);
			
			if(isOut(newR, newC)) continue;			
			if(visit[newR][newC]) continue;
			if(dessert[map[newR][newC]]) continue;
			
			visit[newR][newC] = true;
			dessert[map[newR][newC]] = true;
			search(newR, newC, count+1, d);
			visit[newR][newC] = false;
			dessert[map[newR][newC]] = false;
		}
	}
}

		