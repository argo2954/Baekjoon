import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// input | H, W, blocks
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(stk.nextToken());
		int W = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine());
		int[] blocks = new int[W];
		for(int i=0; i<W; i++) {
			blocks[i] = Integer.parseInt(stk.nextToken());
		}
		
		// 양쪽 벽을 기준으로 높은 벽 체크
		int[][] maxWall = new int[W][2];
		maxWall[0][0] = blocks[0];
		maxWall[W-1][1] = blocks[W-1];
		
		for(int i=1; i<W; i++) {
			// 가장 높은 벽: 왼쪽 기준
			maxWall[i][0] = Math.max(maxWall[i-1][0], blocks[i]);
			
			// 가장 높은 벽: 오른쪽 기준
			maxWall[W-i-1][1] = Math.max(maxWall[W-i][1], blocks[W-i-1]);
		}
		
		// dp
		int answer = 0;
		for(int i=1; i<W-1; i++) {
			int min = Math.min(maxWall[i-1][0], maxWall[i+1][1]);
			if(min-blocks[i] > 0) {
				answer += min-blocks[i];
			}
		}
		
		System.out.println(answer);
		br.close();
	}

}
