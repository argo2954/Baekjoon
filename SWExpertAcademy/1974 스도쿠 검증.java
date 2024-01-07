import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

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
			int[][] map = new int[9][9];
         	 boolean checkAll = true;
            
            // 입력 및 가로 확인
			for(int i=0; i<9; i++){
                boolean[] check = new boolean[10];
                
                for(int j=0; j<9; j++){
					map[i][j] = sc.nextInt();
                    
                    if( check[map[i][j]])
                        checkAll = false;
                    else
                    	check[map[i][j]] = true;
                }
            }
			
            // 세로 확인
            for(int i=0; i<9; i++){
                if(!checkAll) break;
                
                boolean[] check = new boolean[10];
            	for(int j=0; j<9; j++){
               		if(check[map[j][i]]){
                        checkAll = false;
                        break;
                    }
                    else
                        check[map[j][i]] = true;
                }
            }
            
            // 9칸 확인
            for(int i=0; i<9; i+=3){
                if(!checkAll) break;
                
            	for(int j=0; j<9; j+=3){
                    boolean[] check = new boolean[10];
                    
                    for(int x=i; x<i+3; x++){
                        for(int y=j; y<j+3; y++){
                       		if(check[map[x][y]]){
                                checkAll = false;
                        		break;
                            }
                            else
                            	check[map[x][y]] = true;
                        }
                    }
                    
                }
            }
            
            
            int answer = checkAll? 1: 0;
            System.out.println("#"+test_case + " " + answer);
		}
	}
}
