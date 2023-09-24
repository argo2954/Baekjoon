import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input| N ->int, stk -> StringTokenizer
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        /*
         * init| Ai->int[N+2][3]
         * Ai[n][0]: 수열 값
         * Ai[n][1]: 연속 값(왼쪽 부터)
         * Ai[n][2]: 연속 값(오른쪽 부터)
         */
        int[][] Ai = new int[N+2][3];
        for(int n=1; n<=N; n++){
            Ai[n][0] = Integer.parseInt(stk.nextToken());
            Ai[n][1] = Math.max(Ai[n][0], Ai[n][0]+Ai[n-1][1]);
        }
        for(int n=N; n>0; n--){
            Ai[n][2] = Math.max(Ai[n][0], Ai[n][0]+Ai[n+1][2]);
        }

        // solve
        int answer = Integer.MIN_VALUE;
        for(int n=1; n<=N; n++){
            answer = Math.max(answer, Ai[n][1]);
            answer = Math.max(answer, Ai[n][1]+Ai[n+1][2]);
            answer = Math.max(answer, Ai[n-1][1]+Ai[n+1][2]);
        }
        
        System.out.println(N==1? Ai[1][0]: answer);
    }
}
