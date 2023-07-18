import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> classes = new PriorityQueue<>();

        // input N
        int N = Integer.parseInt(br.readLine());
        int[][] Times = new int[N][2];
        
        for(int i=0; i<N; i++){
            String[] S = br.readLine().split(" ");
            Times[i][0] = Integer.parseInt(S[0]); 
            Times[i][1] = Integer.parseInt(S[1]); 
        }

        // sort array
        Arrays.sort(Times, (i1, i2)->{
            return i1[0]!=i2[0]? i1[0]-i2[0]: i1[1]-i2[1]; 
        });

        // push a start time of first class to classes
        classes.offer(Times[0][1]);
        // 1toN -> push finish time of class & compare
        for(int i=1; i<N; i++){
            int start = Times[i][0];
            int finish = Times[i][1];
            // when the start variable is bigger than the first time of classes
            if(classes.peek() <= start){
                classes.poll();
            }
            // create new class
            classes.offer(finish);
        }

        System.out.println(classes.size());
    }
}
