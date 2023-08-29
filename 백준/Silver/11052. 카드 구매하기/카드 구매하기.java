import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input | N -> int ,  Pn -> int[]
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int[] Pn = new int[N+1];
        for(int i=1; i<=N; i++){
            Pn[i] = Integer.parseInt(stk.nextToken());
        }

        // solve | 패턴이용해 풀이
        for(int i=2; i<=N; i++){
            for(int j=1; j<=i/2; j++){
                int sum = Pn[i-j] + Pn[j];
                if(Pn[i]<sum){
                    Pn[i] = sum;
                }
            }
        }

        // print
        System.out.println(Pn[N]);
    }
}
