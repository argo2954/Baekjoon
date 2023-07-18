import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        // input
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            if(n==1)
                sum++;
            else if(n>1)
                plus.add(n);
            else// include zero
                minus.add(n);
        }

        // bifurcation
        // case1: plus
        while(!plus.isEmpty()){
            int num = plus.remove();

            if(!plus.isEmpty()){
                num *= plus.remove();
            }

            sum += num;
        }
        // case2: minus
        while(!minus.isEmpty()){
            int num = minus.remove();

            if(!minus.isEmpty()){
                num *= minus.remove();
            }

            sum += num;
        }
        

        System.out.println(sum);
    }
}
