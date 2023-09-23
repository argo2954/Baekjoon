import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input | N->int, stk->stringTokenizer
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        
        /* init | Ai ->int[N][4]
         * Ai[k][0] = 수열
         * Ai[k][1] = k기준 오름차순 부분 수열의 개수
         * Ai[k][2] = k기준 내림차순 부분 수열의 개수
         * Ai[k][3] = 수열의 길이
         */
        int[][] Ai = new int[N][4];
        for(int i=0; i<N; i++){
            Ai[i][0] = Integer.parseInt(stk.nextToken());
            Ai[i][1] = 1;
        }

        // solve1
        for(int k=0; k<N; k++){
            for(int i=0; i<k; i++){
                // k기준 오름차순 부분 수열 찾기
                if(Ai[i][0]<Ai[k][0] && Ai[i][1]>=Ai[k][1]){
                    Ai[k][1] = Ai[i][1] +1;
                }
            }
        }
        // solve2
        for(int k=N-1; k>=0; k--){
            for(int i=N-1; i>k; i--){
                // k기준 내림차순 부분 수열 찾기
                if(Ai[k][0]>Ai[i][0] && Ai[k][2]<=Ai[i][2]){
                    Ai[k][2] = Ai[i][2] +1;
                }
            }
            Ai[k][3] = Ai[k][1] + Ai[k][2];
        }
        

        // print
        int answer = 0;
        for(int k=0; k<N; k++){
            answer = Math.max(answer, Ai[k][3]);
        }
        System.out.println(answer);
    }
}
