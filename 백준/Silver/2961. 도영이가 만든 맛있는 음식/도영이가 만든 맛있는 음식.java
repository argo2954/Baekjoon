import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] ingredients = new int[N][2];

        for(int i=0; i<N; i++){
            String[] sinZzan = br.readLine().split(" ");
            ingredients[i][0] = Integer.parseInt(sinZzan[0]);
            ingredients[i][1] = Integer.parseInt(sinZzan[1]);
        }

        int answer = Integer.MAX_VALUE;
        for(int i=1; i<(1<<N); i++){
            int sin = 1;
            int zzan = 0;

            for(int j=0; j<N; j++){
                if((i &(1<<j)) !=0){
                    sin *= ingredients[j][0];
                    zzan += ingredients[j][1];
                }
            }

            answer = Math.min(answer, Math.abs(sin-zzan));
        }
        
        System.out.println(answer);
    }
}
