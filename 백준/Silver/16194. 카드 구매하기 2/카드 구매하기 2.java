import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input | N->int , Pn -> int[]
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int[] Pn = new int[N+1];
        for(int i=1; i<=N; i++){
            Pn[i] = Integer.parseInt(stk.nextToken());
        }

        // solve | 패턴을 사용해서 Pn배열 수정
        for(int i=2; i<=N; i++){
            for(int j=1; j<=i/2; j++){
                Pn[i] = Math.min(Pn[i], Pn[i-j]+Pn[j]);
            }
        }
        
        System.out.println(Pn[N]);
    }
}
