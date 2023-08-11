import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N+1];

        for(int i=1; i<N; i++){
            int plus = arr[i]+1;
            if(i+1<=N && (arr[i+1]==0 || arr[i+1]>plus)){
                arr[i+1] = plus;
            }
            if(i*2<=N && (arr[i*2]==0 || arr[i*2]>plus)){
                arr[i*2] = plus;
            }
            if(i*3<=N && (arr[i*3]==0 || arr[i*3]>plus)){
                arr[i*3] = plus;
            }
        }

        System.out.println(arr[N]);
    }
}
