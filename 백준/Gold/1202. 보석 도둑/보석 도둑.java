import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input | N & K -> int
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        // init | weight & price -> priorityQueue
        PriorityQueue<Jewel> jewels_weight = new PriorityQueue<>((j1, j2)->{
            return j1.weight-j2.weight; // 무게기준 오름차순
        });

        PriorityQueue<Jewel> jewels_price = new PriorityQueue<>((j1, j2)->{
            return j2.price-j1.price;   // 가격기준 내림차순
        });

        // input | M & V -> jewels_weight -> priorityQueue
        for(int i=0; i<N; i++){
            String[] MV = br.readLine().split(" ");

            int weight = Integer.parseInt(MV[0]);
            int price = Integer.parseInt(MV[1]);

            jewels_weight.offer(new Jewel(weight, price));
        }

        // input & sort | weights -> int[] -> 가방의 무게를 입력 받고 오름차순 정렬
        int[] weights = new int[K];
        for(int i=0; i<K; i++)
            weights[i] = Integer.parseInt(br.readLine());

        Arrays.sort(weights);
        
        // solve | [가방의 무게보다 작은 jewels_weight의 노드를 뽑아
        // jewels_price에 offer -> 가장 높은(비싼) 보석의 가격을 answer에 저장 후 poll] -> 반복
        Long answer = 0L;
        for(int weight: weights){
            while(!jewels_weight.isEmpty()){
                if(weight < jewels_weight.peek().weight){
                    break;
                } else{
                    jewels_price.offer(jewels_weight.poll());
                }
            }
            
            if(!jewels_price.isEmpty())
                answer += jewels_price.poll().price;
        }

        // print |
        System.out.println(answer);
    }   

    static class Jewel{
        int weight;
        int price;

        Jewel(int w, int p){
            weight = w;
            price = p;
        }
    }
}
