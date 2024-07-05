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
    static long answer = 0;

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
            // 하나의 실내로부터 나올 수 있는 조직의 수 만큼 반복
            for(int adj: adjacent[index]){
                if(A[adj] == 1) answer++;
                else if(check[adj]) continue;
                else onsStepTwoStep(index, adj);
            }
        }
    }

    static void onsStepTwoStep(int index, int adj){
        Queue<Integer> queue = new ArrayDeque<>();

        long cnt = 1;
        queue.add(adj);
        check[adj] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int next: adjacent[now]){
                if(check[next] || next==index) continue;

                if(A[next] == 1){
                    cnt++;
                    continue;
                }

                queue.add(next);
                check[next] = true;
            }
        }

        answer += cnt * (cnt-1);
    }
}