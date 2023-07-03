import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Main {
    public static void main(String[] args) throws Exception {
        Operator operator = new Operator();
        operator.input();
        operator.changeO();
        operator.start();
        operator.print();
    }
     
    static class Operator{
        int N;      // 수의 개수
        int[] A;    // 수들
        int[] O;    // 연산자들의 개수(+,-,*,/)
        boolean[] bool; // 브루트포스를 위한 boolean
        String S = ""; // 문자열로 연결된 연산자들
        int min = 1000000000;
        int max = -1000000000;
        // 기본 생성자 사용

        // 입력 함수
        void input() throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());

            A = new int[N];
            O = new int[4];
            bool = new boolean[N];

            String[] inputA = br.readLine().split(" ");
            String[] inputO = br.readLine().split(" ");;

            for(int i=0; i<N; i++) A[i] = Integer.parseInt(inputA[i]);
            for(int i=0; i<4; i++) O[i] = Integer.parseInt(inputO[i]);
        }

        // 연산자 전환: [+ - * / ] -> [+++--*/]
        void changeO(){
            for(int i=0; i<4; i++){
                S += (""+i).repeat(O[i]);
            }
        }

        // 연산 -> 2개의 숫자
        int Operate(int a, int b, String o){
            switch(o){
                case "0":
                    return a+b;
                case "1":
                    return a-b;
                case "2":
                    return a*b;
                case "3":
                    return a/b;
                default:
                    return 0;
            }
        }

        // 전체 연산
        void start(){
            find(A[0], 1);
        }
        void find(int result, int index){    //index: 
            if(index==N){
                if(result>max) max = result;
                if(result<min) min = result;
                return;
            }
            // 이전 결과와 연산 후 다음 숫자로 넘김
            for(int i=0; i<N-1; i++){
                if(bool[i]) 
                    continue;
                
                int tmp = Operate(result, A[index], S.substring(i, i+1));
                bool[i] = true;
                find(tmp, index+1);
                bool[i] = false;
            }
        }

        // 결과 출력
        void print() throws IOException{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(max + "\n" + min + "\n");
            bw.flush();
            bw.close();
        }
    }
}
