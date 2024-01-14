import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[100][100];
		int answer = 0;
		for(int paper=0; paper<N; paper++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			
			for(int i=x; i<x+10; i++) {
				for(int j=y; j<y+10; j++) {
					if(!map[i][j]) {
						answer++;
						map[i][j] = true;
					}
				}
			}
		}

		System.out.println(answer);
		br.close();
	}

}
