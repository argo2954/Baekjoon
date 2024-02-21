import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N,M,answer;
    static int[][] office; // 0:빈칸, 음수 1~8:cctv, 6:벽, 7:카메라가 있던 위치
    static List<int[]> cctvs = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        // 입력 N M answer
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        answer = N*M;

        // 사무실 입력
        office = new int[N][M];
        for(int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int state = Integer.parseInt(stk.nextToken());
                office[i][j] = state;
                if(0<state && state<6){// cctv인 경우
                    office[i][j] = 7;
                    cctvs.add(new int[]{i,j,state});
                }
            }
        }

        // cctv 정렬: 버전 내림차순
        cctvs.sort((c1, c2) -> c2[2]-c1[2]);

        // cctv 버전5 먼저 탐색
        int camera = 0; // cctv 인덱스(cctv 버전x)
        for(int[] cctv: cctvs){
            if(cctv[2]!=5) break;
            
            // cctv 버전5 작동
            camera++;
            for(int direction=1; direction<=4; direction++){
                observe(cctv[0],cctv[1], direction, camera, false);
            }
        }

        // 나머지 cctv 탐색
        CCTV(camera);

        // 출력
        System.out.println(answer);
    }

    static void CCTV(int camera){
        if(camera==cctvs.size()){
            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(office[i][j]==0) count++;
                }
            }

            answer = Math.min(answer,count);
            return;
        }

        int[] cctv = cctvs.get(camera++);
        if(cctv[2]==4){ // cctv 버전4
            for(int i=1; i<=4; i++){
                observe(cctv[0],cctv[1], (i)%4+1, camera, false);
                observe(cctv[0],cctv[1], (i+1)%4+1, camera, false);
                observe(cctv[0],cctv[1], (i+2)%4+1, camera, false);
                CCTV(camera);
                observe(cctv[0],cctv[1], (i)%4+1, camera, true);
                observe(cctv[0],cctv[1], (i+1)%4+1, camera, true);
                observe(cctv[0],cctv[1], (i+2)%4+1, camera, true);
            }
        }else if(cctv[2]==3){ // cctv 버전3
            for(int i=1; i<=4; i++){
                observe(cctv[0],cctv[1], (i)%4+1, camera, false);
                observe(cctv[0],cctv[1], (i+1)%4+1, camera, false);
                CCTV(camera);
                observe(cctv[0],cctv[1], (i)%4+1, camera, true);
                observe(cctv[0],cctv[1], (i+1)%4+1, camera, true);
            }
        }else if(cctv[2]==2){ // cctv 버전2
            for(int i=1; i<=2; i++){
                observe(cctv[0],cctv[1], i, camera, false);
                observe(cctv[0],cctv[1], i+2, camera, false);
                CCTV(camera);
                observe(cctv[0],cctv[1], i, camera, true);
                observe(cctv[0],cctv[1], i+2, camera, true);
            }
        }else if(cctv[2]==1){ // cctv 버전1
            for(int i=1; i<=4; i++){
                observe(cctv[0],cctv[1], i, camera, false);
                CCTV(camera);
                observe(cctv[0],cctv[1], i, camera, true);
            }
        }
    }

    // cctv 작동| 방향, cctv번호(버전x) 기준
    static void observe(int r, int c, int direction, int index, boolean remove){
        if(direction==1) { //위
            for(int i=r-1; i>=0; i--) {
                if(office[i][c]==6) break;
                if(!remove && office[i][c]==0) office[i][c] = -index;
                if(remove && office[i][c]==-index) office[i][c] = 0;
            }
        }else if(direction==2) {//오
            for(int i=c-1; i>=0; i--) {
                if(office[r][i]==6) break;
                if(!remove && office[r][i]==0) office[r][i] = -index;
                if(remove && office[r][i]==-index) office[r][i] = 0;
            }
        }else if(direction==3) {//아래
            for(int i=r+1; i<N; i++) {
                if(office[i][c]==6) break;
                if(!remove && office[i][c]==0) office[i][c] = -index;
                if(remove && office[i][c]==-index) office[i][c] = 0;
            }
        }else if(direction==4) {//왼
            for(int i=c+1; i<M; i++) {
                if(office[r][i]==6) break;
                if(!remove && office[r][i]==0) office[r][i] = -index;
                if(remove && office[r][i]==-index) office[r][i] = 0;
            }
        }
    }
}
