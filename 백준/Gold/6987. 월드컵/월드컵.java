import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] scores;
    static int isCorrect;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int testCase=0; testCase<4; testCase++){
            scores = new int[6][3];

            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int i=0; i<6; i++){
                scores[i][0] = Integer.parseInt(stk.nextToken());
                scores[i][1] = Integer.parseInt(stk.nextToken());
                scores[i][2] = Integer.parseInt(stk.nextToken());
            }

            isCorrect = 0;
            dfs(0);
            result.append(isCorrect + " ");
        }
        System.out.println(result);
    }

    static int[] schedule1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int[] schedule2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
    static void dfs(int index){
        if(index==15){
            // scores가 전부 0인지 확인
            for(int i=0; i<6; i++){
                if(scores[i][0]!=0 || scores[i][1]!=0 || scores[i][2]!=0)
                    return;
            }
            isCorrect = 1;
            return;
        }

        int country1 = schedule1[index];
        int country2 = schedule2[index];

        // 승
        if(scores[country1][0]!=0 && scores[country2][2]!=0){
            scores[country1][0]--; scores[country2][2]--; dfs(index+1);
            scores[country1][0]++; scores[country2][2]++;
        }
        // 무
        if(scores[country1][1]!=0 && scores[country2][1]!=0){
            scores[country1][1]--; scores[country2][1]--; dfs(index+1);
            scores[country1][1]++; scores[country2][1]++;
        }
        // 패
        if(scores[country1][2]!=0 && scores[country2][0]!=0){
            scores[country1][2]--; scores[country2][0]--; dfs(index+1);
            scores[country1][2]++; scores[country2][0]++;
        }
    }
}
