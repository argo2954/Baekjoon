import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int L = Integer.parseInt(stk.nextToken());
		
		int[] heights = new int[N];
		stk = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			heights[i] = Integer.parseInt(stk.nextToken());
		}
		
		// 정렬| 오름차순
		Arrays.sort(heights);
		
		// 순회
		for(int height: heights) {
			if(L < height) break;
			
			L++;
		}
		
		// 출력
		System.out.println(L);
	}

}