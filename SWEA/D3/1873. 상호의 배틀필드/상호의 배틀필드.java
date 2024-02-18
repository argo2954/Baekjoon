import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution
{
	static StringBuilder result = new StringBuilder();
	static char[][] map;
	static int h,w,r,c;

	public static void main(String args[]) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++){
			StringTokenizer stk = new StringTokenizer(br.readLine());

			// 입력
			h = Integer.parseInt(stk.nextToken());
			w = Integer.parseInt(stk.nextToken());
			map = new char[h][w];

			for(int i=0; i<h; i++){
				map[i] = br.readLine().toCharArray();

				for(int j=0; j<w; j++){
					if(map[i][j]=='^' || map[i][j]=='v' || map[i][j]=='<' || map[i][j]=='>'){
						r = i; c = j;
					}
				}
			}

			// 게임 진행
			int cmdInputTimes = Integer.parseInt(br.readLine());
			char[] commandLine = br.readLine().toCharArray();
			gameStart(commandLine);
			printResult(test_case);
		}

		System.out.println(result);
	}

	
	static void gameStart(char[] commandLine){
		for(char cmd: commandLine){
			if(cmd == 'U'){
				map[r][c] = '^';
				if(canGo(r-1, c)){
					map[r][c] = '.';
					map[r-1][c] = '^';
					r = r-1;
				}
			}
			if(cmd == 'D'){
				map[r][c] = 'v';
				if(canGo(r+1, c)){
					map[r][c] = '.';
					map[r+1][c] = 'v';
					r = r+1;
				}
			}
			if(cmd == 'L'){
				map[r][c] = '<';
				if(canGo(r, c-1)){
					map[r][c] = '.';
					map[r][c-1] = '<';
					c = c-1;
				}
			}
			if(cmd == 'R'){
				map[r][c] = '>';
				if(canGo(r, c+1)){
					map[r][c] = '.';
					map[r][c+1] = '>';
					c = c+1;
				}
			}
			if(cmd == 'S'){
				shoot();
			}
		}
	}

	static boolean canGo(int r, int c){
		if(r<0 || c<0 || r>=h || c>=w) return false;
		if(map[r][c] == '*' || map[r][c]=='#' || map[r][c]=='-') return false;
		return true;
	}

	static void shoot(){
		// 위
		if(map[r][c] == '^'){
			for(int i=r-1; i>=0; i--){
				if(map[i][c]=='*'||map[i][c]=='#'){
					if(map[i][c]=='*') map[i][c] = '.';
					return;
				}
			}
		}
		// 왼
		if(map[r][c] == '<'){
			for(int i=c-1; i>=0; i--){
				if(map[r][i]=='*'||map[r][i]=='#'){
					if(map[r][i]=='*') map[r][i] = '.';
					return;
				}
			}
		}
		// 아
		if(map[r][c] == 'v'){
			for(int i=r+1; i<h; i++){
				if(map[i][c]=='*'||map[i][c]=='#'){
					if(map[i][c]=='*') map[i][c] = '.';
					return;
				}
			}
		}
		// 오
		else if(map[r][c] == '>'){
			for(int i=c+1; i<w; i++){
				if(map[r][i]=='*'||map[r][i]=='#'){
					if(map[r][i]=='*') map[r][i] = '.';
					return;
				}
			}
		}
	}

	static void printResult(int test_case) {
		result.append("#" + test_case +" ");
		for(char[] row: map){
			for(char col: row){
				result.append(col);
			}
			result.append("\n");
		}
	}
}