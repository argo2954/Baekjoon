import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // input & init | N & steps
        int n = Integer.parseInt(br.readLine());
        int[] steps = new int[n];
        int[] one = new int[n]; // 이전의 계단이 한 칸 전인 경우, 이전 계단들의 합
        int[] two = new int[n]; // 이전의 계딴이 두 칸 전인 경우, 이전 계단들의 합
        
        for(int i=0; i<n; i++)
            steps[i] = Integer.parseInt(br.readLine());
        
        // solve |
        for(int i=0; i<n-1; i++){
            one[i+1] = steps[i] + two[i];
            if(i<n-2){
                two[i+2] = Math.max(steps[i]+one[i],steps[i]+two[i]);
            }
        }
        
        System.out.println(Math.max(steps[n-1]+one[n-1], steps[n-1]+two[n-1]));
    }
}
