import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[][] map = new int[N][N];
            
            // input
			for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
            		map[i][j] = sc.nextInt();      
                }
            }
            
            int[][] rotate90 = new int[N][N];            
            int[][] rotate180 = new int[N][N];
            int[][] rotate270 = new int[N][N];

            // rotate
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
            		rotate90[j][N-1-i] = map[i][j];            		
                    rotate180[N-1-i][N-1-j] = map[i][j];   
            		rotate270[N-1-j][i] = map[i][j];   
                }
            }
            
            // print
            System.out.println("#"+test_case);
            for(int i=0; i<N; i++){
                for(int rotate: rotate90[i])
                    System.out.print(rotate);
                System.out.print(" ");

                for(int rotate: rotate180[i])
                    System.out.print(rotate);
                System.out.print(" ");
                
                for(int rotate: rotate270[i])
                    System.out.print(rotate);
                System.out.println();
            }
		}
	}
}