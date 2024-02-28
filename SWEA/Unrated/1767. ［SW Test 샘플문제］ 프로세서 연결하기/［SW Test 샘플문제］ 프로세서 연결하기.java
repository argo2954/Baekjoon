import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	
	static int N,answer,depth;
	static boolean[][] map;
	static List<int[]> cpus;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			// 입력| N
			N = Integer.parseInt(br.readLine());
			
			// 초기화
			answer = Integer.MAX_VALUE;
			depth = 0;
			map = new boolean[N][N];
			cpus = new ArrayList<>();
			
			// 입력| 맵
			for(int i=0; i<N; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					boolean state = false;
					int isCpu = Integer.parseInt(stk.nextToken());
					if(isCpu==1) {
						if(i!=0 && i!=N-1 && j!=0 && j!=N-1)
							cpus.add(new int[] {i,j});
						state = true;
					}
					
					map[i][j] = state;
				}
			}
			
			// find
			find(0,0,0);
			
			// 출력
			System.out.printf("#%d %d\n",test_case,answer);
		}
	}
	
	
	static void find(int cnt, int index, int sum) {
		if(cnt == depth) {
			answer = Math.min(answer, sum);
		}
		else if(cnt>depth) {
			answer = sum;
			depth++;
		}
			
		if(index == cpus.size()) {
			return;
		}
		
		int[] cpu = cpus.get(index);
		int r = cpu[0];
		int c = cpu[1];
		
		for(int i=1; i<=4; i++) {
			int[] go = fill(r,c,i);
			if(go[0] == 1) {
				find(cnt+1, index+1, sum+go[1]);
				remove(r,c,i);
			}
		}
        find(cnt, index+1, sum);
	}
	
	static int[] fill(int r, int c, int direction) {
		int cnt = 0; 
				
		if(direction==1) { // 위
			for(int i=0; i<r; i++) {
				if(map[i][c]) {// 선을 연결하지 못하는 경우
					for(int j=0; j<i; j++) map[j][c] = false;
					return new int[] {0,0};
				}
				map[i][c] = true;
				cnt++;
			}
		}else if(direction==2) { // 오른쪽
			for(int i=N-1; i>c; i--) {
				if(map[r][i]) { // 선을 연결하지 못하는 경우
					for(int j=N-1; j>i; j--) map[r][j] = false;
					return new int[] {0,0};
				}
				map[r][i] = true;
				cnt++;
			}
		}
		else if(direction==3) { // 아래
			for(int i=N-1; i>r; i--) {
				if(map[i][c]) {// 선을 연결하지 못하는 경우
					for(int j=N-1; j>i; j--) map[j][c] = false;
					return new int[] {0,0};
				}
				map[i][c] = true;
				cnt++;
			}
		}
		else { // 왼쪽
			for(int i=0; i<c; i++) {
				if(map[r][i]) { // 선을 연결하지 못하는 경우
					for(int j=0; j<i; j++) map[r][j] = false;
					return new int[] {0,0};
				}
				map[r][i] = true;
				cnt++;
			}
		}
		
		return new int[] {1,cnt};
	}
	
	static void remove(int r, int c, int direction) {
		if(direction==1) { // 위
			for(int i=0; i<r; i++) {
				map[i][c] = false;
			}
		}else if(direction==2) { // 오른쪽
			for(int i=N-1; i>c; i--) {
				map[r][i] = false;
			}
		}
		else if(direction==3) { // 아래
			for(int i=N-1; i>r; i--) {
				map[i][c] = false;
			}
		}
		else { // 왼쪽
			for(int i=0; i<c; i++) {
				map[r][i] = false;
			}
		}
	}
}