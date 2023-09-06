import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        // input | N->int, stk->StringTokenizer
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        // init | Ai->int[] Using stk , asc & desc->Stack<Integer>
        int[][] Ai = new int[N][2];
        for(int i=0; i<N; i++){
            Ai[i][0] = Integer.parseInt(stk.nextToken());
            Ai[i][1] = 1;
        }

        // solve |
        int answer = 1;
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if(Ai[i][0]<Ai[j][0] && Ai[i][1]>=Ai[j][1]){
                    Ai[j][1] = Ai[i][1]+1;
                    if(Ai[j][1]>answer)
                        answer = Ai[j][1];
                }
            }
        }

        // print
        System.out.println(answer);
    }
}
