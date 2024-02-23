import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 입력| V E
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(stk.nextToken());
			int E = Integer.parseInt(stk.nextToken());
			
			// 입력| 간선들
			List<int[]>[] edges = new LinkedList[V+1];
            for(int i=1; i<=V; i++) {edges[i] = new LinkedList<>();}
			for(int i=0; i<E; i++) {
				stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				int c = Integer.parseInt(stk.nextToken());
                edges[a].add(new int[]{b,c});
                edges[b].add(new int[]{a,c});
			}
			
			// 생성| 우선순위 큐, 방문 배열
            Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1]-e2[1]);
            boolean[] visited = new boolean[V+1];
            
            // 트리 만들기
            // step1| 첫 노드 넣기
            long answer = 0;
            int cnt = 0;
            visited[1] = true;
            for(int[] edge: edges[1]) {pq.offer(edge);}
			
            // step2| pq탐색
            while(!pq.isEmpty()){
                int[] edge = pq.poll();
                
                // 이전 방문한 노드인 경우 pass
                if(visited[edge[0]]) continue;

                // 방문한 노드가 아니므로 결과에 더해줌
                answer += edge[1];
                visited[edge[0]] = true;
                cnt++;

                // 트리 완성 확인
                if(cnt==V-1) break;

                // 트리 마저 완성
                for(int[] e: edges[edge[0]]){
                    // 이전 방문한 노드인 경우 pass
                    if(visited[e[0]]) continue;
                    // 방문한 노드가 아니므로 pq에 넣어줌
                    pq.offer(e);
                }
            } 
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
	
}