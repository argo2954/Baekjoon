import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input | n->int
        int n = Integer.parseInt(br.readLine());

        /** 
         * init | rect-> int[]  : rect[n] = rect[n-1] + rect[n-2]
         * 0과 1은 기본으로 두고, 2부터 채우기 시작. 패턴은 아래와 같다.
         * 1. n-1 모양 앞에 |를 더한다.
         * 2. n-2 모양 앞에 =를 더한다.
         * 
         * 1: |
         * 2: ||, =                     ->      |+|, =+0 
         * 3: |||, |=, =|               ->      |+||, |+=, =+|
         * 4: ||||, ||=, |=|, =||, ==   ->      |+|||, |+|=, |+=|, =+||, =+=
         */
        int[] rect = new int[n+1];
        rect[0] = rect[1] = 1;
        
        // solve | 10007으로 나눈 나머지를 배열에 저장.
        // (A+B)%C == (A%C + B%C)%C 
        for(int i=2; i<=n; i++){
            rect[i] = (rect[i-1]%10007 + rect[i-2]%10007)%10007;
        }

        System.out.println(rect[n]);
    }
}
