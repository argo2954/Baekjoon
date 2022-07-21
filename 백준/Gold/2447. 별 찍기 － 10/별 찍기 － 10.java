import java.io.*;

class Main {
  // 입력
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
  static int max = 0;
  static void star(int row, int col, int N) throws IOException{
    if ((row / (N/3)) % 3 == 1 & (col / (N/3)) % 3 == 1){
      out.write(" "); 
    }
    else if (N == 3){
      out.write("*");
    }
    else
      star(row, col, N/3); 
  }

  public static void main(String[] args) throws IOException{

    max = Integer.parseInt(in.readLine());
    // 함수 호출
    for(int i=0; i<max; i++){
      for(int j=0; j<max; j++){
        star(i, j, max);
      }
      out.write("\n");
    }
    

    in.close();
    out.close();
  }
}