import java.io.*;
class Main {
  public static void main(String[] args) throws IOException{
    init();
    f(0,num[0],new boolean[n-1]);
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //bw.write(ss + "\n");
    bw.write(max+"\n"); bw.write(min+"\n");
    bw.close();
 }
  //전역 변수
  static int n;
  static int[] num; //피연산자
  static int[] op;  //연산자 -> +,-,x,/ 순
  static int max = -100000000;
  static int min = +100000000;
  //static String ss = "";
  //초기화 함수
  //입력 및 배열 저장
  public static void init() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //첫 째줄 입력
    n = Integer.parseInt(br.readLine());
    num = new int[n];
    op = new int[n-1];
    //둘 째줄 입력
    String[] s1 = br.readLine().split(" ");
    for(int i=0; i<n; i++) num[i] = Integer.parseInt(s1[i]);
    //셋 째줄 입력
    String[] s2 = br.readLine().split(" ");
    for(int i=0,j=0; i<4; i++){
      int t = Integer.parseInt(s2[i]) + j;
      while(j<t){
        op[j] = i+1;
        j++;
      }
    }
    br.close();
  }
  //연산 함수
  public static int opr(int sum, int num, int op){
    switch(op){
      case 1:
        return sum + num;
      case 2:
        return sum - num;
      case 3:
        return sum * num;
      case 4:
        return sum / num;
    }
    return sum;
  }
  //백트레킹 함수
  //depth = 현재 깊이, n-1과 같아지면 함수 끝
  public static void f(int depth, int sum, boolean[] b){
    //최종 깊이에 도달한 경우 max와 min을 조정하고 함수 빠져나옴
    if(depth==n-1){
      if(sum>max) max = sum;
      if(sum<min) min = sum;
      return;
    }
    //연산
    for(int i=0; i<n-1; i++){
      if(b[i]) continue;
      else{
        b[i] = true;
        //ss += sum + " " +op[depth] + " " + num[depth+1] + " = " + opr(sum, num[depth+1], op[depth]) + "\n";
        f(depth+1, opr(sum, num[depth+1], op[i]), b);
        b[i] = false;
      }
    } 
  }
}