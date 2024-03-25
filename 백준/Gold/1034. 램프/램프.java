import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력| N, M
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        // 입력| 0의 개수(열 기준)
        String[] table = new String[N];
        for(int i=0; i<N; i++){
            table[i] = br.readLine();
        }

        Map<Long, Integer> map = new HashMap<>();
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            long indexes = 0;
            int count = 0;
            for(int j=0; j<M; j++){
                if(table[i].charAt(j)=='0'){
                    indexes |= 1L<<j;
                    count++;
                }
            }
            if(count > K) continue;
            if((K-count)%2==1) continue;
            if(map.containsKey(indexes)){
                map.put(indexes, map.get(indexes)+1);
            }else{
                map.put(indexes, 1);
            }
        }

        int answer = 0;
        for(Long key: map.keySet()){
            answer = Math.max(answer, map.get(key));
        }

        System.out.println(answer);
    }
}