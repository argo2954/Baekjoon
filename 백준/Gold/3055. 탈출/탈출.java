import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char[][] map;
	static Queue<int[]> flood = new ArrayDeque<>();
	static Queue<int[]> hedgehog = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        
        map = new char[R][C];
        for(int i=0; i<R; i++) {
        	map[i] = br.readLine().toCharArray();
        	
        	for(int j=0; j<C; j++) {
        		if(map[i][j] == 'S') hedgehog.add(new int[] {i,j});
        		if(map[i][j] == '*') flood.add(new int[] {i,j});
        	}
        }
         
         // 출력
         System.out.println(twoThousandYearsLater());
	}
	
	private static String twoThousandYearsLater() {
		int day = 0;
		
		while(!hedgehog.isEmpty()) {
			day++;
			if(oneStepTwoStepPollJjackPollJjack()) {
				return day+"";
			}
		}
		
		return "KAKTUS";
	}

	// 땅굴로 도망쳐
	private static boolean oneStepTwoStepPollJjackPollJjack() {
		// 도망치기
		int size = hedgehog.size();
		while(size-- > 0) {
			int[] state = hedgehog.poll();
			if(map[state[0]][state[1]] != 'S') continue;
			
			for(int i=0; i<4; i++) {
				int r = state[0]+dr[i];
				int c = state[1]+dc[i];
				
				if(isOut(r, c)) continue;
				if(map[r][c] == 'X') continue;
				if(map[r][c] == '*') continue;
				if(map[r][c] == 'S') continue;
				
				if(map[r][c] == 'D') return true;
				
				map[r][c] = 'S';
				hedgehog.offer(new int[] {r,c});
			}
		}
		
		// 홍수 확장
		size = flood.size();
		while(size-- > 0) {
			int[] state = flood.poll();
			
			for(int i=0; i<4; i++) {
				int r = state[0]+dr[i];
				int c = state[1]+dc[i];
				
				if(isOut(r, c)) continue;
				if(map[r][c] == 'X') continue;
				if(map[r][c] == '*') continue;
				if(map[r][c] == 'D') continue;
				
				map[r][c] = '*';
				flood.offer(new int[] {r,c});
			}
		}
		
		return false;
	}
	
	// 범위
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static boolean isOut(int r, int c) {
		return r<0 || c<0 || r>=R || c>=C;
	}
	
}
