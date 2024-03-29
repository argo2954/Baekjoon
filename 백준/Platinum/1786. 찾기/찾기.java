import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();

        // pi배열 초기화
        /** 
         * ABABC
         * A    : 0
         * AB   : 0
         * ABA  : 1
         * ABAB : 2
         * ABABC: 0 (pi[2-1] -> pi[1] = 0)
         */
        int[] pi = new int[P.length()];
        int i=1,j=0;
        while(i < P.length()){
            if(P.charAt(i) == P.charAt(j)){
                pi[i] = j+1;
                i++; j++;
            }else if(j!=0){
                j = pi[j-1];
            }else{
                i++;
            }
        }

        i=0; j=0;
        int cnt = 0;
        StringBuilder result = new StringBuilder();
        while(i < T.length()){
            if(T.charAt(i) == P.charAt(j)){
                if(j== P.length()-1){
                    result.append((i-P.length()+2)+" ");
                    cnt++;
                    if(j==0){
                        i++;
                    }else{
                        j = pi[j-1];
                    }
                }else{
                    i++; j++;
                }
            }else if(j!=0){
                j = pi[j-1];
            }else{
                i++;
            }
        }

        System.out.println(cnt);
        System.out.println(result);
    }
}