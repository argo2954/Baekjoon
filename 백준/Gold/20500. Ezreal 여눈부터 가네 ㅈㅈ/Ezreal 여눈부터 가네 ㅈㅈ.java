import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Mod 활용
 * ((x*10) + 5) % 15
 * = ((x*10)%15 + 5%15)%15
 * = (((x%15)*(10%15))%15 + 5%15)%15
 */

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력| N
		int N = Integer.parseInt(br.readLine());
		
		// mod15 연산 결과 저장 dp
		long[][] mod15 = new long[N+1][15];
		mod15[1][1] = mod15[1][5] = 1;
		
		// N탐색 시작
		for(int i=2; i<=N; i++) {
			for(int j=0; j<15; j++) {
				int append1 = (((j)*10)%15 + 1)%15;
				int append5 = (((j)*10)%15 + 5)%15;
				
				mod15[i][append1] = (mod15[i][append1] + mod15[i-1][j])%1000000007; 
				mod15[i][append5] = (mod15[i][append5] + mod15[i-1][j])%1000000007; 
			}
		}
		
		// 출력
		System.out.println(mod15[N][0]);
	}

}