import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arrays, arrays2;
	static int N,M,R;
	static boolean isOut(int r, int c) {
		return r<0||c<0||r>=N||c>=M;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        arrays = new int[N][M];
        arrays2 = new int[M][N];
        for(int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arrays[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
		
        // 배열 돌리기 시작
		stk = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) 
			func(Integer.parseInt(stk.nextToken()));
		
		// 출력
		StringBuilder result = new StringBuilder();
        for(int[] arr: arrays){
            for(int num: arr){
                result.append(num+" ");
            }
            result.append("\n");
        }

        System.out.print(result);
        br.close();
	}
	
	static void func(int num) {
		switch(num) {
			case 1:
				func1();
				break;
			case 2:
				func2();
				break;
			case 3:
				func3();
				break;
			case 4:
				func4();
				break;
			case 5:
				func5();
				break;
			case 6:
				func6();
				break;
		}
	}
	
	static void func1() {
		for(int r=0; r<N/2; r++) {
			int[] tmp = arrays[r];
			arrays[r] = arrays[N-r-1];
			arrays[N-r-1] = tmp;
		}
	}

	static void func2() {
		for(int c=0; c<M/2; c++) {
			for(int r=0; r<N; r++) {
				int tmp = arrays[r][c];
				arrays[r][c] = arrays[r][M-c-1];
				arrays[r][M-c-1] = tmp;
			}
		}
	}
	
	static void func3() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				arrays2[c][N-r-1] = arrays[r][c];
			}
		}
		int[][] tmpArrays = arrays;
		arrays = arrays2;
		arrays2 = tmpArrays;
		
		int tmp = N;
		N = M;
		M = tmp;
	}

	static void func4 () {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				arrays2[M-c-1][r] = arrays[r][c];
			}
		}
		int[][] tmpArrays = arrays;
		arrays = arrays2;
		arrays2 = tmpArrays;

		int tmp = N;
		N = M;
		M = tmp;
	}
	
	static void swap(int r1, int c1, int r2, int c2) {
		int tmp = arrays[r1][c1];
		arrays[r1][c1] = arrays[r2][c2];
		arrays[r2][c2] = tmp;
	}
	
	static void func5() {
		for(int r=0; r<N/2; r++) {
			for(int c=0; c<M/2; c++) {
				swap(r,c,r,c+M/2);
				swap(r,c,r+N/2,c+M/2);
				swap(r,c,r+N/2,c);				
			}
		}
	}
	
	static void func6() {
		for(int r=0; r<N/2; r++) {
			for(int c=0; c<M/2; c++) {
				swap(r,c,r+N/2,c);				
				swap(r,c,r+N/2,c+M/2);
				swap(r,c,r,c+M/2);
			}
		}
	}
	

}