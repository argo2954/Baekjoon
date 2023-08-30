import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        /**
         * 패턴
         * 1 : 1
         * 2 : 2
         * 3 : 3, 1+2, 2+1
         * 4 : 1+3, 1+2+1, 3+1
         * 5 : 1+3+1, 2+3, 2+1+2, 3+2
         * 6 : 1+2+3, 1+2+1+2, 1+3+2, 2+1+3, 2+1+2+1, 2+3+1, 3+1+2, 3+2+1
         * ...
         * 1을 구성하는 요소 중 1로 시작하는 것은 1개, 2로 시작하는 것 0개, 3으로 시작하는 것 0개
         * 2를 구성하는 요소 중 1로 시작하는 것은 2개, 2로 시작하는 것 1개, 3으로 시작하는 것 0개
         * 3을 구성하는 요소 중 1로 시작하는 것은 1개, 2로 시작하는 것 1개, 3으로 시작하는 것 1개
         * 1은 1을 더하지 못하고, 2와 3을 더할 수 있음 -> 2+1, 3+1 -> 3, 4
         * 2는 2를 더하지 못하고, 1과 3을 더할 수 있음 -> 1+2, 3+2 -> 3, 5
         * 3은 1, 2, 3 하나씩 더할 수 있음 -> 1+2, 1+3, 2+1, 2+3, 1+3, 2+3 -> 3, 4, 3, 5, 4, 5
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input | T->int, Ns->int[]
        int T = Integer.parseInt(br.readLine());

        int[] Ns = new int[T];
        int max = 3;
        for(int i=0; i<T;i++){
            Ns[i] = Integer.parseInt(br.readLine());

            if(Ns[i]>max)
                max = Ns[i];
        }

        // init | map->int[][4]
        int[][] map = new int[max+1][4];
        map[1][0] = 1; map[1][1] = 1; map[1][2] = 0; map[1][3] = 0;
        map[2][0] = 1; map[2][1] = 0; map[2][2] = 1; map[2][3] = 0;
        map[3][0] = 3; map[3][1] = 1; map[3][2] = 1; map[3][3] = 1;

        for(int i=4; i<=max; i++){
            int d = 1000000009;
            map[i][1] = (map[i-1][2]%d + map[i-1][3]%d)%d;
            map[i][2] = (map[i-2][1]%d + map[i-2][3]%d)%d;
            map[i][3] = (map[i-3][1]%d + map[i-3][2]%d)%d;
            /**
             * 나머지 연산의 분배법칙
             * (A+B+C)%D = ((A+B)+C)%D = ((A+B)%D + C%D)%D
             * = (((A%D)+(B%D))%D + C%D)%D
             *  */ 
            map[i][0] = ((map[i][1]%d + map[i][2]%d)%d + map[i][3]%d)%d;
            
        }

        // print
        for(int num: Ns)
            System.out.println(map[num][0]);
    }
}
