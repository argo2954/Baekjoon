import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력| N, M
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        // 초기화| map
        int[][] map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map[i][j] = INF;
            }
        }

        for(int i=0; i<M; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            map[a][b] = 1;
        }

        // 플로이드 워셜
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j) continue;

                for(int k=1; k<=N; k++){
                    if(i==k || j==k) continue;
                    
                    if(map[j][i]==1 && map[i][k]==1) map[j][k] = 1;
                }
            }
        }

        // 정답 확인
        int answer = 0;
        for(int i=1; i<=N; i++){
            int cnt = 0;
            for(int j=1; j<=N; j++){
                if(map[i][j]!=INF || map[j][i]!=INF) cnt++;
            }
            if(cnt == N-1) answer++;
        }

        // 출력
        System.out.println(answer);
    }
}