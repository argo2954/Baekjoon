import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // input | N & K -> int 
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        // input | students -> int[N]
        int[] students = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            students[i] = Integer.parseInt(stk.nextToken());

        // init | diffs -> int[N-1] -> 이웃한 두 학생의 키 차이
        int[] diffs = new int[N-1];
        for(int i=0; i<N-1; i++)
            diffs[i] = students[i+1] - students[i];

        // sort | diffs -> 오름차순
        // ex | 2 2 1 4 -> 1 2 2 4
        Arrays.sort(diffs);

        // solve | 가장 비용이 많이 드는(차이가 많은) 구간에 경계를 두어 비용을 최소화함
        // -> (N-1)개의 경계 중 (K-1)개의 경계를 둘 수 있음
        int answer = 0;
        for(int i=0; i<N-K; i++)
            answer += diffs[i];

        // print
        System.out.println(answer);
    }
}
