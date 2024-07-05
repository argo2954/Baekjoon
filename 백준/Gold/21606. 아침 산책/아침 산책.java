import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static List<Integer> in = new LinkedList<>();
    static List<Integer>[] adjacent;
    static boolean[] check;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        adjacent = new List[N+1];

        String input = br.readLine();
        for(int i=1; i<=N; i++){
            A[i] = input.charAt(i-1)-'0';
            if(A[i] == 1) in.add(i);

            adjacent[i] = new LinkedList<>();
        }

        for(int i=1; i<N; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk .nextToken());
            int b = Integer.parseInt(stk .nextToken());

            adjacent[a].add(b);
            adjacent[b].add(a);
        }

        twoThousandYearsLater();

        System.out.println(answer);
    }

    static void twoThousandYearsLater(){
        check = new boolean[N+1];
        for(int index: in){
            if(check[index]) continue;
            onsStepTwoStep(index);
        }
    }

    static void onsStepTwoStep(int index){
        Queue<int[]> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        queue.add(new int[]{index, index}); // next, root
        map.put(index, 1);
        check[index] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int next: adjacent[now[0]]){
                if(check[next]) continue;

                if(A[next] == 1){
                    map.put(now[1], map.get(now[1])+1);
                    map.put(next, 1);

                    queue.add(new int[]{next, next});
                    check[next] = true;
                    continue;
                }

                queue.add(new int[]{next, now[1]});
                check[next] = true;
            }
        }

        for(int value: map.values()){
            answer += value * (value-1);
        }
    }
}