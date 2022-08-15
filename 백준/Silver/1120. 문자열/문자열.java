import java.io.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    //입력
    String[] input = in.readLine().split(" ");
    String x = input[0];
    String y = input[1];

    //필요 변수 선언 및 초기화
    int xlen = x.length(); //x문자열의 길이
    int ylen = y.length(); //y문자열의 길이
    int answer = 0; // 출력 값
    
    //반복 count 함수 실행
    for(int i=0; i<=ylen-xlen; i++){
      int count = count(x, y.substring(i,i+xlen), xlen);
      if(count>answer) answer=count;
    }

    out.write(xlen - answer + "\n");

    out.flush();
    in.close();
    out.close();
  }

  public static int count(String s1, String s2, int len){
    int count = 0;
    for(int i=0; i<len; i++){
      if(s1.charAt(i)==s2.charAt(i))
        count++;
    }
    return count;
  }
}