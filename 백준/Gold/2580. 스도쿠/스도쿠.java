import java.io.*;
public class Main{
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int input[][];
	
	public static void main(String[] args) throws IOException{
    input();
    fill(0,0);
  }
  //입력 함수
	static void input() throws IOException {
    input = new int[9][9];
    for (int i = 0; i < 9; i++) {
      String[] str = in.readLine().split(" ");
      
      for (int j = 0; j < 9; j++) 
        input[i][j] = Integer.parseInt(str[j]);
    }
  }
  //스도쿠 채우는 함수(재귀)
  //다 채우면 출력함수 호출
  static void fill(int i, int j) throws IOException{
    //0찾기
    while(true){
      if(j==9) {i++; j=0;}
      if(i==9) print();
      if(input[i][j]==0) break;
      j++;
    }
    
    for(int t=1; t<10; t++){
      if(check(i,j,t)){
        //중복되는 수 없으면 채우고
        //다음 fill 호출
        input[i][j] = t;
        fill(i, j+1);   
      }
    }
    input[i][j] = 0;
    return;
  }
  static boolean check(int i, int j, int t) {
    //가로줄에서 중복되는 수 있는지 체크
    for(int x=0; x<9; x++)
      if(input[i][x]==t) return false;
    //세로줄에서 중복되는 수 있는지 체크
    for(int x=0; x<9; x++)
      if(input[x][j]==t) return false;;
    //3x3에서 중복되는 수 있느지 체크
    int x = (i/3)*3;
    int y = (j/3)*3;
    for(int ii=0; ii<3; ii++)
      for(int jj=0; jj<3; jj++)
        if(input[x+ii][y+jj]==t) return false;

    return true;
  }
  //출력 함수
  static void print() throws IOException{
    for (int[] i : input) {
      for (int e : i)
        out.write(e + " ");
      out.write("\n");
		}
    out.flush();
    out.close();
    
    System.exit(0); //프로세스 종료
  }
}
