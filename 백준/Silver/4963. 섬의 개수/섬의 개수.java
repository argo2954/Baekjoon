import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input | 테스트 케이스
        while(true){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(stk.nextToken());
            int h = Integer.parseInt(stk.nextToken());
            
            // break point | w=h=0 일때
            if(w==0 && h==0)
                break;
            
            // input & init | map -> boolean[h+2][w+2]
            boolean[][] map = new boolean[h+2][w+2];
            for(int i=1; i<h+1; i++){
                stk = new StringTokenizer(br.readLine());
                for(int j=1; j<w+1; j++){
                    int landOrSea = Integer.parseInt(stk.nextToken());
                    // when int is a land
                    if(landOrSea == 1){ 
                        map[i][j] = true; 
                    }
                }
            }

            // solve | BFS
            int answer = 0;
            for(int i=1; i<h+1; i++){
                for(int j=1; j<w+1; j++){
                    if(map[i][j]==true){
                        answer++;
                        BFS(map, i, j);
                    }
                }
            }

            // print |
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] X = {-1, 0, 1};
    static int[] Y = {-1, 0, 1};
    static void BFS(boolean[][] map, int i, int j){
        Queue<Integer> xq = new LinkedList<Integer>();
        Queue<Integer> yq = new LinkedList<Integer>();
        
        yq.offer(i);
        xq.offer(j);
        map[i][j] = false;

        while(!xq.isEmpty()){
            i = yq.poll();
            j = xq.poll();

            for(int y: Y){
                int newY = i+y;
                for(int x: X){
                    int newX = j+x;
                    
                    if(map[newY][newX]){
                        map[newY][newX] = false;
                        xq.offer(newX);
                        yq.offer(newY);
                    }
                }
            }
        }
    }
}
