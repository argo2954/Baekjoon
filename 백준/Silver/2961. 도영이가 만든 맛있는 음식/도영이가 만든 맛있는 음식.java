import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ingredients = new int[N][2];
		for(int i=0; i<N; i++) {
			String[] strs = br.readLine().split(" ");
			ingredients[i][0] = Integer.parseInt(strs[0]);
			ingredients[i][1] = Integer.parseInt(strs[1]);
		}
		
		findAsnwer(0, N, 1, 0, false);
		System.out.println(answer);
	}
	
	static long answer = Long.MAX_VALUE;
	static int[][] ingredients;
	public static void findAsnwer(int index, int depth, long ssin, long ssn, boolean useIngredient) {
		if(index == depth) {
			// 재료를 하나도 사용하지 않은 경우
			if(!useIngredient) {
				return;
			}
			
			long gap = ssin>ssn? ssin-ssn: ssn-ssin;
			answer = Math.min(answer, gap);
			return;
		}
		
		findAsnwer(index+1, depth, ssin*ingredients[index][0], ssn+ingredients[index][1], true);
		findAsnwer(index+1, depth, ssin, ssn, useIngredient);
	}
}
