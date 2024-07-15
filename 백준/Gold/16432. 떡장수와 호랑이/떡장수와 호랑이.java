import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] TTEOK; 
    static int[][] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력| N
        N = Integer.parseInt(br.readLine());
        TTEOK = new int[N + 1][10];

        // 입력| TTEOK 조합
        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(stk.nextToken());
            TTEOK[i][0] = size;
            
            while (stk.hasMoreTokens()) {
                int index = Integer.parseInt(stk.nextToken());
                TTEOK[i][index] = 1;
            }
        }

        // dp 배열 초기화
        dp = new int[N + 1][10];

        // 첫 번째 날 초기화
        for (int j = 1; j < 10; j++) {
            if (TTEOK[1][j] == 1) {
                dp[1][j] = 1;
            }
        }

        // dp 테이블 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < 10; j++) {
                if (TTEOK[i][j] == 1) {
                    for (int k = 1; k < 10; k++) {
                        if (dp[i - 1][k] == 1 && j != k) {
                            dp[i][j] = 1;
                            break;
                        }
                    }
                }
            }
        }

        // 역추적을 통해 결과 찾기
        Stack<Integer> stack = new Stack<>();
        boolean possible = false;
        for (int j = 1; j < 10; j++) {
            if (dp[N][j] == 1) {
                stack.push(j);
                possible = true;
                break;
            }
        }

        if (!possible) {
            System.out.println(-1);
            return;
        }

        for (int i = N - 1; i >= 1; i--) {
            for (int j = 1; j < 10; j++) {
                if (dp[i][j] == 1 && j != stack.peek()) {
                    stack.push(j);
                    break;
                }
            }
        }

        if (stack.size() != N) {
            System.out.println(-1);
        } else {
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }
    }
}