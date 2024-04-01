import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] factorial = new long[4000001];
	static int MOD = 1000000007;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 조합 초기작업
		factorial[0] = factorial[1] = 1l;
		for(int i=2; i<=4000000; i++) {
			factorial[i] = (factorial[i-1]*i)%MOD;
		}

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int R = Integer.parseInt(stk.nextToken());
		System.out.println(((factorial[N] * f(R,MOD-2)%MOD)%MOD * f(N-R,MOD-2)%MOD)%MOD);
	}
	
	static long f(int r, int p) {
		if(p==1) {
			return factorial[r];
		}
		else if(p%2 == 0) {
			long result = f(r,p/2);
			return  (result * result)%MOD;
		}
		else {
			long result = f(r,(p-1)/2);
			return ((result * result)%MOD * f(r,1))%MOD;			
		}
	}
}
