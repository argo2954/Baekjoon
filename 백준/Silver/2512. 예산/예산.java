import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int M = Integer.parseInt(br.readLine());
        
        // make nums
        int[] nums = new int[N];
        StringTokenizer token = new StringTokenizer(S);
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(token.nextToken());
        }

        // sort
        Arrays.sort(nums);

        // solve
        int answer = 0;
        int mid = M/N;

        for(int i=0; i<N; i++){
            if(mid<nums[i]){
                answer = M/(N-i);
                break;
            }
            else{
                M = M - nums[i];
                answer = nums[i];

                if(i!=N-1)
                    mid = M/(N-i-1);
            }
        }
        System.out.println(answer);
    }
}
