import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int finger, count;
    static int[][] songarack = {
        {0, 0},
        {8, 8},
        {6, 2},
        {4, 4},
        {2, 6},
        {8, 8}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        finger = Integer.parseInt(br.readLine());
        count = Integer.parseInt(br.readLine());

        long answer = finger;
        for(int i=0; i<count; i++){
            answer += songarack[finger][i%2];
        }

        System.out.println(answer-1);
    }
}