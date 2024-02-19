import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int user,m,n,answer;
    static int[] M,N;
    static int[] A,B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        user = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        M = new int[1000*m+1];
        N = new int[1000*n+1];
        A = new int[m];
        B = new int[n];

        for(int i=0; i<m; i++)
            A[i] = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++)
            B[i] = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            int piece = A[i];
            M[piece]++;

            for(int j=i+1; j<m; j++){
                piece += A[j];
                M[piece]++;
            }

            for(int j=0; j<i; j++){
                piece += A[j];
                M[piece]++;
            }
            M[piece] = 1;
        }

        for(int i=0; i<n; i++){
            int piece = B[i];
            N[piece]++;

            for(int j=i+1; j<n; j++){
                piece += B[j];
                N[piece]++;
            }

            for(int j=0; j<i; j++){
                piece += B[j];
                N[piece]++;
            }
            N[piece] = 1;
        }


        for(int i=1000*m; i>0; i--){
            if(M[i]==0) continue;

            if(i==user){
                answer += M[i];
                M[i] = 0;
            }
            else if(user-i>0 && N[user-i]!=0){
                answer += M[i]*N[user-i];
                M[i] = N[user-i] = 0;
            }
        }

        for(int i=1000*n; i>0; i--){
            if(N[i]==0) continue;

            if(i==user){
                answer += N[i];
                N[i] = 0;
            }
            else if(user-i>0 && M[user-i]!=0){
                answer += N[i]*M[user-i];
                N[i] = M[user-i] = 0;
            }
        }

        System.out.println(answer);
    }
}
