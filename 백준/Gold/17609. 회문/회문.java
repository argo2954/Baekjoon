import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력| N
        int N = Integer.parseInt(br.readLine());

        // 결과 확인
        for(int i=0; i<N; i++){
            int result = palindrome(br.readLine(), false);

            sb.append(result).append("\n");
        }

        // 출력
        System.out.println(sb);
    }

    static int palindrome(String input, boolean remove){
        int left = 0;
        int right = input.length()-1;

        while(left < right){
            if(input.charAt(left) == input.charAt(right)){
                left++; 
                right--;
            }else if(remove){
                return 2;
            }else {
                int leftResult = palindrome(input.substring(left, right), true);
                int rightResult = palindrome(input.substring(left+1, right+1), true);

                if(leftResult==1 || rightResult==1){
                    return 1;
                }else
                    return 2;
            }
        }


        return remove? 1: 0;
    }
}