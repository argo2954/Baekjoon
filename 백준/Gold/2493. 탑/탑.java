import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		Queue<Top> queue = new PriorityQueue<>();
		queue.add(new Top(Integer.parseInt(stk.nextToken()), 1));
		
		int[] answer = new int[N];
		answer[0] = 0;
		
		for(int i=1; i<N; i++) {
			int height = Integer.parseInt(stk.nextToken());
			
			while(!queue.isEmpty()) {
				int preHeight = queue.peek().height;
				if(preHeight<=height) {
					queue.poll();
				} else {
					answer[i] = queue.peek().index;
					break;
				}
			}
			queue.add(new Top(height, i+1));
		}

		StringBuilder result = new StringBuilder();
		for(int i=0; i<N; i++) {
			result.append(answer[i]+ " ");
		}
		
		System.out.println(result);
		
	}
	
	static class Top implements Comparable<Top>{
		int height;
		int index;
		public Top(int height, int index) {
			super();
			this.height = height;
			this.index = index;
		}
		@Override
		public int compareTo(Top o) {
			// TODO Auto-generated method stub
			return this.height - o.height;
		}
		
		
		
		
	}
}