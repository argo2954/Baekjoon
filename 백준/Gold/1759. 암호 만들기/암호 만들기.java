import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int L,C;
    static char[] alphabets;
    static char[] password;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 L, C
        StringTokenizer stk = new StringTokenizer(br.readLine());
        L = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        // 알파벳 입력 및 오름차순 정렬
        alphabets = br.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(alphabets);
        
        // 암호 찾기
        password = new char[L];
        findPassword(0,0);

        // 출력
        System.out.println(result);
    }

    // indexP: password 인덱스
    // indexA: alphbets 인덱스
    static void findPassword(int indexP, int indexA){
        if(indexP==L){
            if(isValid()){
                result.append(String.valueOf(password)+"\n");
            }
            return;
        }

        for(int i=indexA; i<C; i++){
            password[indexP] = alphabets[i];
            findPassword(indexP+1, i+1);
        }
    }

    static boolean isValid(){
        int moem = 0;
        int jaem = 0;

        for(char c: password){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                moem++;
            else
                jaem++;
        }

        return moem>=1&&jaem>=2? true: false;
    }
}