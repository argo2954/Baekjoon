import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input | n->int
        int n = Integer.parseInt(br.readLine());

        /** init | rect[] -> int[]
         * rect[x] = rect[x-1] + rect[x-2] * 2
         * rect배열의 0과 1을 채우고, 2부터 패턴에 따라 값을 채움. 패턴은 아래와 같음
         * 0: 0
         * 1: |
         * 2: ||, =, ㅁ                     -> |+|, =+0, ㅁ+0
         * 3: |||, |=, |ㅁ, =|, ㅁ|         -> |+||, |+=, |+ㅁ, =+|, ㅁ+|
         * 4: ||||, ||=, ||ㅁ, |=|, |ㅁ|, =||, ==, =ㅁ, ㅁ||, ㅁ=, ㅁㅁ
         *     -> |+|||, |+|=, |+|ㅁ, |=|, |+ㅁ|, =+||, =+=, =+ㅁ, ㅁ+||, ㅁ+=, ㅁ+ㅁ
         */
        int[] rect = new int[n+1];
        rect[0] = rect[1] = 1;

        // solve | (A+B)%C == (A%C + B%C) % C
        for(int i=2; i<=n; i++){
            rect[i] = (rect[i-1]%10007 + (rect[i-2]*2)%10007) % 10007;
        }

        // print
        System.out.println(rect[n]);
    }
}
