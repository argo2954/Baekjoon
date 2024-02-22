import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, answer, MAX;
	static int[] population;
	static List<Integer>[] edges;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		// 입력: N
		N = Integer.parseInt(stk.nextToken());
		
		// 입력: 인구
		population = new int[N+1];
		stk = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(stk.nextToken());
			answer = MAX += population[i];
		}
		
		// 간선 연결
		edges = new List[N+1];
		for(int i=1; i<=N; i++) {
			edges[i] = new LinkedList<>();
			stk = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(stk.nextToken());
			for(int j=0; j<size; j++) {
				edges[i].add(Integer.parseInt(stk.nextToken()));
			}
		}
		
		// 최백준 부시러 가보자
		subset();
		
		// 출력
		if(answer==MAX) System.out.println(-1);
		else System.out.println(answer);
	}



	static void subset(){
		// 전체 도시 중에 절반만 사용해도 됨(1:7 == 7:1)
		int end = 1 << N; 
		for(int i=0; i<end; i++){
			boolean[] city1 = new boolean[N+1];
			boolean[] city2 = new boolean[N+1];
			int sum = 0;

			for(int j=1; j<=N; j++){
				if((i & 1<<j) != 0) {
					city1[j] = true;
					// 조직이 둘로 나뉘었을 경우 sum을 이용할 예정
					sum += population[j];
				}else
					city2[j] = true;
			}

			// 조직이 둘로 나뉘었을 경우 정답 수정
			if(isUnion(city1) && isUnion(city2)){
				answer = Math.min(answer, Math.abs(MAX-sum-sum));
			}
		}
	}
	
	static boolean isUnion(boolean[] isVisit) {
		Queue<Integer> queue = new ArrayDeque<>();

		for(int i=1; i<=N; i++) {
			if(!isVisit[i]) {
				queue.offer(i);
                isVisit[i] = true;
				break;
			}
		}
		if(queue.isEmpty()) return false;
		
		while(!queue.isEmpty()) {
			int city = queue.poll();
			for(int edge: edges[city]) {
				if(!isVisit[edge]) {
					queue.offer(edge);
                    isVisit[edge] = true;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(!isVisit[i]) {
				return false;
			}
		}
		return true;
	}

}