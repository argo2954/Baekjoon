import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        /**
         * 패턴
         * 0: 1로 생성
         * 1: 0과 1로 생성
         * 2: 1과 3으로 생성
         * ...
         * 8: 7과 9로 생성
         * 9: 8로 생성
         * 
         * 0123456789
         * 0111111111 -> 9
         * 1122222221 -> 17
         * 1334444432 -> 32
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input | N -> int
        int N = Integer.parseInt(br.readLine());

        // init | nums -> int[10]: 0~9      &     temp -> int[10]: 양옆을 더한 임시저장 값
        int[] nums  = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] temp = new int[10];

        // solve | 패턴 이용
        // 0~9 각 숫자의 양 옆을 더한 값을 temp에 채우고 nums를 temp로 치환
        int mod = 1000000000;
        for(;N>1; N--){
            for(int i=1; i<9; i++){
                temp[i] = (nums[i-1]%mod + nums[i+1]%mod)%mod;
            }
            temp[0] = nums[1];
            temp[9] = nums[8];
            System.arraycopy(temp, 0, nums, 0, 10);
        }

        // print
        Long answer = 0L;
        for(int num: nums)
            answer += num;
        
        System.out.println(answer%mod);
    }
}
