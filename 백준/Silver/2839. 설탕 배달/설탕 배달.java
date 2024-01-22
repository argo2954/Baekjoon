import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = -1;
        for(int i=N/5; i>=0; i--){
            int mod = N - 5*i;

            if(mod%3 == 0){
                answer = i+(mod/3);
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }
}