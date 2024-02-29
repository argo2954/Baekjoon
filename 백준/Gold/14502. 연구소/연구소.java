import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,answer;
	static boolean[][] originVisit, visit;
	static List<int[]> virus = new ArrayList<>();
	static List<int[]> empty = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력| N, M
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		// 입력| 방문 배열, 빈칸 리스트, 바이러스 리스트
		originVisit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int state = Integer.parseInt(stk.nextToken());
				if(state==0) empty.add(new int[] {i,j});
				else if(state==2) {virus.add(new int[] {i,j}); originVisit[i][j] = true;}
				else originVisit[i][j] = true;
			}
		}
		
		// 시간이 흐르고...
		answer = 0;
		twoThousandYearLater(0,0);
		System.out.println(answer);
	}
	
	static int[] select = new int[3]; // 조합 선택
	static void twoThousandYearLater(int cnt, int start) {
		// 조합| 빈칸 3개
		if(cnt==3) {
			answer = Math.max(answer, spread());
			return;
		}
		
		for(int i=start; i<empty.size(); i++) {
			select[cnt] = i;
			twoThousandYearLater(cnt+1, i+1);
		}
	}
	
	// 바이러스가 퍼져나가는 메소드
	static int spread() {
		// 배열 복사| 방문배열
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) visit[i] = Arrays.copyOf(originVisit[i], M);
		
		// 벽 세우기
		for(int i=0; i<3; i++) {
			int[] binkan = empty.get(select[i]);
			int r = binkan[0];
			int c = binkan[1];
			visit[r][c] = true;
		}
		
		// bfs탐색
		bfs();
		
		// 바이러스 생존자 확인 및 반환
		return check();
	}
	
	// bfs를 통해 바이러스 퍼트리기
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		
		// 바이러스 큐에 넣기
		for(int[] v: virus) {
			queue.offer(v);
			visit[v[0]][v[1]] = true;
		}
		
		// bfs
		while(!queue.isEmpty()) {
			int[] v = queue.poll();
			
			for(int i=0; i<4; i++) {
				int r = v[0]+dr[i];
				int c = v[1]+dc[i];
				
				if(isOut(r,c)) continue;
				if(visit[r][c]) continue;
				
				queue.offer(new int[] {r,c});
				visit[r][c] = true;
			}
		}
	}
	
	static boolean isOut(int r, int c) {
		return r<0 || c<0 || r>=N || c>=M;
	}
	
	// 바이러스에서 살아남은 생존자 파악 메소드
	static int check() {
		int rest = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visit[i][j]) rest++;
			}
		}
		
		return rest;
	}
}