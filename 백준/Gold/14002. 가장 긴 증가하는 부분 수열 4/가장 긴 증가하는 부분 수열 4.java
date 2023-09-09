import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input | N -> int, stk -> stringToken
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        /** init | Ai = int[N][3]
         * [][0]: 수열
         * [][1]: 길이
         * [][2]: 이전 수(인덱스)
         */
        int[][] Ai = new int[N][3];
        for(int i=0; i<N; i++){
            Ai[i][0] = Integer.parseInt(stk.nextToken());
            Ai[i][1] = 1;
            Ai[i][2] = i;
        }

        // solve
        // len: 가장 긴 수열의 길이
        // index: 가장 긴 수열의 마지막 인덱스
        int len = 1; 
        int index = 0;
        //loop | 왼쪽 수들과 비교 
        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(Ai[j][0]<Ai[i][0] && Ai[j][1]>=Ai[i][1]){
                    Ai[i][1] = Ai[j][1]+1;
                    Ai[i][2] = j;

                    if(Ai[i][1]>len){
                        len = Ai[i][1];
                        index = i;
                    }
                }
            }
        }

        // make indexs | 
        int[] indexs = new int[len];
        for(int i=len-1; i>=0; i--){
            indexs[i] = index;
            index = Ai[index][2];
        }


        // print
        String answer = "";
        for(int i=0; i<len; i++)
            answer +=  Ai[indexs[i]][0] + " ";
        
        System.out.println(len);
        System.out.println(answer);
    }
}
