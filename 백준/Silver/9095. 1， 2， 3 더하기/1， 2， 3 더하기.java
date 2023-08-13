import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        // Array[int] | 0~11 저장, 각 수 마다 테스트 케이스 저장
        int[] arr = new int[12];
        arr[1] = 1; // 1
        arr[2] = 2; // 1+arr[1]: 1+1, 
                    // 2+arr[0]: 2+0
        arr[3] = 4; // 1+arr[2]: 1+1+1, 1+2
                    // 2+arr[1]: 2+1
                    // 3+arr[0]: 3+0
        // 4 | 1+arr[3]: 1+3, 1+1+1+1, 1+1+2, 1+2+1
        // 4 | 2+arr[2]: 2+2, 2+1+1
        // 4 | 3+arr[1]: 3+1
        // 5 | 1+arr[4]: 1+1+3, 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+2, 1+2+1+1, 1+3+1
        // 5 | 2+arr[3]: 2+1+1+1, 2+1+2, 2+2+1, 2+3
        // 5 | 3+arr[2]: 3+1+1, 3+2

        for(int i=4; i<12; i++){
            arr[i] =  arr[i-1] + arr[i-2] + arr[i-3]; 
        }

        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(arr[n] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
