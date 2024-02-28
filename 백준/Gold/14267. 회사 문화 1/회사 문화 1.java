import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] union; //[사원번호]{상사번호, 내칭찬} 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력| N,M
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		// 입력| union 상사번호
		union = new int[N+1][2];
		stk = new StringTokenizer(br.readLine());
		for(int idx=1; idx<=N; idx++) {
			union[idx][0] = Integer.parseInt(stk.nextToken());
		}
		 
		// 입력| union 칭찬
		for(int idx=1; idx<=M; idx++) {
			stk = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			union[i][1] += w;
		}
		
		// 칭찬 구하기
		StringBuilder result = new StringBuilder();
		for(int idx=1; idx<=N; idx++) {
			int i = union[idx][0];
			int w = union[idx][1];
			
			while(i!=-1) {
				w += union[i][1];
				i = union[i][0];
			}
			result.append(w).append(" ");
			
			// 내 위로 칭찬 다 구했으니까 값 바꿔두기
			union[idx][0] = -1;
			union[idx][1] = w;
		}
		
		// 출력
		System.out.println(result);
	}

}