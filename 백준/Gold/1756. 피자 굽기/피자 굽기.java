import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int INF = Integer.MAX_VALUE;
    static int N,M;
    static int[] diameter;
    static int[] doughs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        // 초기화
        diameter = new int[N+1];
        diameter[0] = INF;

        // 입력| 지름
        stk = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            diameter[i] = Integer.parseInt(stk.nextToken());
            if(diameter[i-1] < diameter[i]){
                diameter[i] = diameter[i-1];
            }
        }

        // 입력| 피자 반죽
        doughs = new int[M];
        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            doughs[i] = Integer.parseInt(stk.nextToken());
        }

        // 결과 확인
        int depth = N;
        int dough = 0;
        while(depth != 0 && dough<M){
            if(doughs[dough] <= diameter[depth]){
                dough++;
            }

            depth--;
        }

        // 결과 출력
        System.out.println(depth!=0? depth+1: 0);
    }
}