import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 N
		int N = Integer.parseInt(br.readLine());
		int[][] max = new int[N+1][3];
		int[][] min = new int[N+1][3];
		
		// 입력 max
		for(int i=1; i<=N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			max[i][0] = min[i][0] = Integer.parseInt(stk.nextToken());
			max[i][1] = min[i][1] = Integer.parseInt(stk.nextToken());
			max[i][2] = min[i][2] = Integer.parseInt(stk.nextToken());

			max[i][0] += Math.max(max[i-1][0], max[i-1][1]);
			max[i][1] += Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2]));
			max[i][2] += Math.max(max[i-1][1], max[i-1][2]);
			
			min[i][0] += Math.min(min[i-1][0], min[i-1][1]);
			min[i][1] += Math.min(min[i-1][0], Math.min(min[i-1][1], min[i-1][2]));
			min[i][2] += Math.min(min[i-1][1], min[i-1][2]);
		}
		
		int answer1 = Math.max(max[N][0], Math.max(max[N][1], max[N][2]));
		int answer2 = Math.min(min[N][0], Math.min(min[N][1], min[N][2]));
		System.out.println(answer1 + " " + answer2);
	}
}