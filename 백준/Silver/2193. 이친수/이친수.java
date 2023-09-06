import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        /**
         * 패턴 파악
         * N=1: 1개, 1
         * N=2: 1개, 10
         * N=3: 2개, 101, 100
         * N=4: 3개, 1010, 1001, 1000
         * ...
         * 마지막이 0과 1인 숫자가 몇개인지 각각 확인
         * 0인경우 2개, 1인 경우 1개 추가
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // input | N->int
        int N = Integer.parseInt(br.readLine());

        /** init | N=1 임을 먼저 가정하고 시작
         * zero -> int: 마지막(최하위)가 0인 숫자들의 갯수
         * one -> int: 마지막(최하위)가 1인 숫자들의 갯수
         */ 
        Long zero = 0L;
        Long one = 1L;

        // solve
        for(int i=1; i<N; i++){
            // 마지막을 0으로 만들 수 있는 경우 판단
            Long zeroTemp = zero + one;

            // 마지막을 1로 만들 수 있는 경우 판단
            Long oneTemp = zero;

            // 현재 값을 temp 값으로 수정
            zero = zeroTemp;
            one = oneTemp;
        }

        // print
        System.out.println(zero+one);
    }
}
