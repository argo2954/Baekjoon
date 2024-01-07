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
            
            int[] countNumber = new int[101];
            
            int answer = 0;
            for(int i=0; i<1000; i++){
            	int score = sc.nextInt();
                countNumber[score]++;
                
                if(countNumber[answer] < countNumber[score]){
                    	answer = score;   
                }
                else if(countNumber[answer] == countNumber[score]){
                		answer = Math.max(answer, score);   
                }
            }
            
            System.out.println(String.format("#%d %d", test_case, answer));
		}
	}
}