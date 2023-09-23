import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input | N & K -> INT
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        /* 패턴
         * 0-1: 0
         * 0-2: 00
         * 0-3: 000
         * 0-4: 0000
         * 
         * 1-1: 1
         * 1-2: 01, 10
         * 1-3: 001, 010, 100
         * 1-4: 0001, 0010, 0100, 1000
         * 
         * 2-1: 2
         * 2-2: 02, 11, 20
         * 2-3: 002, 011, 020, 101, 110, 200
         * 2-4: 0002, 0011, 0020, 0101, 0110, 0200, 1001, 1010, 1100, 2000
         */
        // init |
        int[][] cases = new int[N+1][K+1];
        Arrays.fill(cases[0], 1);

        // solve
        for(int n=1; n<=N; n++){
            for(int k=1; k<=K; k++){
                cases[n][k] = (int)(((long)cases[n-1][k] + cases[n][k-1]) % 1000000000);
            }
        }
        
        // print
        System.out.println(cases[N][K]);
    }
}
