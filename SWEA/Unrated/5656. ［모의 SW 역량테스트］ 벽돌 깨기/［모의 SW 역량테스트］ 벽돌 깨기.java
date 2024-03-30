import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


class Solution
{
	static int N,W,H,answer;
	static int[][] originMap;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			W = Integer.parseInt(stk.nextToken());
			H = Integer.parseInt(stk.nextToken());

			originMap = new int[H][W];
			for(int i=0; i<H; i++){
				stk = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++){
					originMap[i][j] = Integer.parseInt(stk.nextToken());
				}
			}

			twoThousandYearsLater();
			result.append("#").append(test_case).append(" ").append(answer).append("\n");
		}

		System.out.println(result);
	}

	static void twoThousandYearsLater(){
		answer = Integer.MAX_VALUE;

		for(int i=0; i<W; i++){
			afterNDay(makeNewMap(originMap), 0, i);
		}
	}

	static int[][] makeNewMap(int[][] map){
		int[][] newMap = new int[H][W];
		for(int i=0; i<H; i++) newMap[i] = Arrays.copyOf(map[i], W);

		return newMap;
	}

	static void afterNDay(int[][] map, int day, int target){
		if(day == N){
			int count = 0;
			for(int[] row: map){
				for(int col: row){
					if(col != 0) count++;
				}
			}
			
			answer = Math.min(answer, count);
			return;
		}

		bombYangGang(map, target);
		for(int i=0; i<W; i++){
			afterNDay(makeNewMap(map), day+1, i);
		}
	}

	static void bombYangGang(int[][] map, int target){
		int r=0, c=target;
		for(int i=0; i<H; i++) {
			if(map[i][c] != 0){
				r = i; 
				break;
			}
		}

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{r,c,map[r][c]});
		map[r][c] = 0;

		while(!queue.isEmpty()){
			int[] state = queue.poll();
			int range = state[2];
			
			for(int d=1; d<range; d++){
				for(int i=0; i<4; i++){
					int newR = state[0]+dr[i]*d;
					int newC = state[1]+dc[i]*d;

					if(isOut(newR, newC)) continue;
					if(map[newR][newC] == 0) continue;
					if(map[newR][newC] == 1) {map[newR][newC] = 0; continue;}

					queue.offer(new int[]{newR,newC,map[newR][newC]});
					map[newR][newC] = 0;
				}
			}
		}

		for(int j=0; j<W; j++){
			int index = 0;
			for(int i=H-1; i>=0; i--){
				if(map[i][j]==0){
					index = i;
					break;
				}
			}
			for(int i=index-1; i>=0; i--){
				if(map[i][j]!=0){
					map[index][j] = map[i][j];
					map[i][j] = 0;
					index--;
				}
			}
		}
	}

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean isOut(int r,int c){
		return r<0 || c<0 || r>=H || c>=W;
	}
}