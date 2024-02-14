import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		long max = 0;
		
		int[] trees = new int[N+1];
		stk = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			trees[i] = Integer.parseInt(stk.nextToken());
			max += trees[i];	
		}
		
		// 나무 오름차순(높이순)
		Arrays.sort(trees);
		
		// index에 해당하는 나무의 높이를 기준으로 절단했을 때 높이 저장
		long[] heights = new long[N+1];
		heights[0] = max;
		for(int i=1; i<=N; i++) {
			heights[i] = heights[i-1] - (long)(trees[i]-trees[i-1])*(N-i+1);
		}
		
		// heights 중 M보다 작거나 같은 기준 찾기
		// 나중에 이분탐색으로 하기
		int answer = 0;
		for(int i=0; i<=N; i++) {
			if(M >= heights[i]) {
				int minus = (int)((M-heights[i])/(N-i+1));					
				if((M-heights[i])%(N-i+1)!=0){
					minus++;
				}
				
				answer = trees[i] - minus;
				break;
			}
		}
		
		System.out.println(answer);
	}

}