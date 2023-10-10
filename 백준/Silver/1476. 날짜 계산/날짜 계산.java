import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input | E, S, M -> int
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        // solve | loop
        int answer = 1;
        int e = 1, s = 1, m = 1;
        while(true){
            if(e==E && s==S && m==M){
                System.out.println(answer);
                return;
            }

            e = e==15? 1: e+1;
            s = s==28? 1: s+1;
            m = m==19? 1: m+1;   
            answer++;      
        }
    }
}
