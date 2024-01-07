import java.util.Scanner;


class Solution
{
	public static void main(String args[]) throws Exception
	{


		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
        	int n = sc.nextInt();
            int m = sc.nextInt();
			
            // input
            int[][] map = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                	map[i][j] = sc.nextInt();
                }
            }
            
            int sum = 0;
            // plus
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    int sumOfPlus = map[i][j];
                    int mulOfPlus = map[i][j];
                    
                    for(int r=1; r<m; r++){
                        if(i-r>=0) sumOfPlus += map[i-r][j];						 // 위
                        if(i+r<n)  sumOfPlus += map[i+r][j];				   // 아래
                        if(j-r>=0)  sumOfPlus += map[i][j-r];					// 왼
						if(j+r<n)  sumOfPlus += map[i][j+r];				  // 오
						
                        if(i-r>=0&&j-r>=0) mulOfPlus += map[i-r][j-r];		// 왼위 대각
                        if(i+r<n&&j-r>=0) mulOfPlus += map[i+r][j-r];	  // 왼아래 대각
                        if(i-r>=0&&j+r<n) mulOfPlus += map[i-r][j+r];	  // 오위 대각
                        if(i+r<n&&j+r<n) mulOfPlus += map[i+r][j+r];	// 오아래 대각
                    }
                    sum = Math.max(sum, sumOfPlus);
					sum = Math.max(sum, mulOfPlus);
                }
            }
            
            System.out.println("#"+test_case+" "+sum);
		}
        
        
	}
}
