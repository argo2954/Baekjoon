import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M,R;
    static int[][] arrays;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        arrays = new int[N][M];

        for(int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arrays[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
    
        rotate();

        StringBuilder result = new StringBuilder();
        for(int[] arr: arrays){
            for(int num: arr){
                result.append(num+" ");
            }
            result.append("\n");
        }

        System.out.print(result);
    }

    static void rotate(){
        int min = Math.min(N,M);

        for(int i=0; i<min/2; i++){
            addAll(i);
            fillAll(i);
        }
    }

    static void addAll(int cur){
        for(int i=cur; i<M-cur; i++) queue.add(arrays[cur][i]);
        for(int i=cur+1; i<N-cur; i++) queue.add(arrays[i][M-cur-1]);
        for(int i=M-cur-2; i>=cur; i--) queue.add(arrays[N-cur-1][i]);
        for(int i=N-cur-2; i>cur; i--) queue.add(arrays[i][cur]);
    }

    static void fillAll(int cur){
        // int r = R;
        int r = R % (2 * ((N - 2 * cur - 1) + (M - 2 * cur - 1)));

        while(r-->0){
            queue.add(queue.poll());
        }

        for(int i=cur; i<M-cur; i++) arrays[cur][i] = queue.poll();
        for(int i=cur+1; i<N-cur; i++) arrays[i][M-cur-1] = queue.poll();
        for(int i=M-cur-2; i>=cur; i--) arrays[N-cur-1][i]= queue.poll();
        for(int i=N-cur-2; i>cur; i--) arrays[i][cur] = queue.poll();
    }
}
