import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // input, fee of A B C
        String[] S = br.readLine().split(" "); 
        int A = Integer.parseInt(S[0]);        
        int B = Integer.parseInt(S[1]);
        int C = Integer.parseInt(S[2]);

        // input, in & out time
        int[] inAndOut1 = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int[] inAndOut2 = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int[] inAndOut3 = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        // solve, make a array of int[100] & count the inAndOut times
        int[] times = new int[100];
        for(int i=inAndOut1[0]; i<inAndOut1[1]; i++){
            times[i]++;
        }
        for(int i=inAndOut2[0]; i<inAndOut2[1]; i++){
            times[i]++;
        }
        for(int i=inAndOut3[0]; i<inAndOut3[1]; i++){
            times[i]++;
        }

        // count, times
        int answer = 0;
        for(int i=0; i<100; i++){
            if(times[i] == 1)
                answer += A;
            else if(times[i] == 2)
                answer += B*2;
            else if(times[i] == 3)
                answer += C*3;
        }

        System.out.println(answer);
    }
}
