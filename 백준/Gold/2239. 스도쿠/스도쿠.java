import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] map = new int[9][9];
    static List<int[]> quests = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력| map
        for(int i=0; i<9; i++){
            String input = br.readLine();
            for(int j=0; j<9; j++){
                map[i][j] = input.charAt(j) -'0';
                if(map[i][j]==0) quests.add(new int[]{i,j});
            }
        }

        // 하나씩 채워보기
        twoThousandYearsLater(0);

        // 출력
        StringBuilder result = new StringBuilder();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                result.append(map[i][j]+"");
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    // 하나씩 채우기
    static boolean twoThousandYearsLater(int index){
        if(index == quests.size()){
            return true;
        }

        int r = quests.get(index)[0];
        int c = quests.get(index)[1];

        int target = bitOper(r, c);
        for(int i=1; i<=9; i++){
            if((target&(1<<i)) >0) continue;
            map[r][c] = i;
            if(twoThousandYearsLater(index+1)) return true;
            map[r][c] = 0;
        }
        
        return false;
    }


    // bit채우기: row,col,9칸
    static int bitOper(int r, int c){
        int target = 0;

        for(int i=0; i<9; i++){
            target |= 1 << map[r][i]; // row에서 채우기
            target |= 1 << map[i][c]; // col에서 채우기
        }

        int dr = (r/3)*3;
        int dc = (c/3)*3;
        for(int i=dr; i<dr+3; i++){
            for(int j=dc; j<dc+3; j++){
                target |= 1<<map[i][j];
            }
        }
        return target;
    }

}