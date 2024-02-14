import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,r,c;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		System.out.println(Z());
	}
	
	static int[][] arr = {{0,1},{2,3}};
	static int Z() {
		int answer = 0;
		
		while(N>1) {
			int powN = (int)Math.pow(2, N);
			int powN_1 = (int)Math.pow(2, N-1);
			if(r >= powN/2) {
				answer += powN_1*powN_1*2;
				r -= powN_1;
			}
			if(c >= powN/2) {
				answer += powN_1*powN_1;
				c -= powN_1;
			}
			
			N--;
		}
		
		answer += arr[r][c];
		
		return answer;
	}


}