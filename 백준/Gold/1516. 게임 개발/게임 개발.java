import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Building[] buildings;
    static int[] times;

    static class Building{
        int number;         // 빌딩 번호
        int time;           // 빌딩 건설에 남은 시간
        int rest;           // 먼저 지어야 하는 빌딩 개수
        List<Building> next;// 다음에 지을 수 있는 빌딩들
        public Building(int number){
            this.number = number;
            rest = 0;
            next = new LinkedList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        times = new int[N];
        buildings = new Building[N];
        for(int i=0; i<N; i++) buildings[i] =  new Building(i);
        
        for(int i=0; i<N; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            buildings[i].time = Integer.parseInt(stk.nextToken());

            while(stk.hasMoreTokens()){
                int state = Integer.parseInt(stk.nextToken());
                if(state == -1) break;

                buildings[i].rest++;
                buildings[state-1].next.add(buildings[i]);
            }
        }

        twoThousandYearsLater();

        StringBuilder result = new StringBuilder();
        for(int time: times) result.append(time).append("\n");

        System.out.println(result);
    }

    static void twoThousandYearsLater(){
        Queue<Building> queue = new ArrayDeque<>();
        int minTime = Integer.MAX_VALUE;
        int time = 0;
        
        for(Building building: buildings){
            if(building.rest == 0){
                queue.add(building);
                minTime = Math.min(minTime, building.time);
            }
        }

        while (!queue.isEmpty()) {
            time += minTime;
            int size = queue.size();
            int nextMinTime = Integer.MAX_VALUE;

            while(size-- > 0){
                Building building = queue.poll();
                building.time -= minTime;

                // 빌딩 건설이 끝난 경우
                if(building.time <= 0){
                    times[building.number] = time+building.time;

                    for(Building nextB: building.next){
                        if(--nextB.rest > 0) continue;

                        queue.add(nextB);
                        nextMinTime = Math.min(nextB.time, nextMinTime);
                    }
                }else{ // 빌딩 건설에 시간이 더 필요한 경우
                    nextMinTime = Math.min(building.time, nextMinTime);
                    queue.add(building);
                }
            }

            minTime = nextMinTime;
        }
    }
}