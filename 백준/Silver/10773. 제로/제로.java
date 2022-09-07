import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException{
    Stack<Integer> st = new Stack<>();
    //입력 및 stack에 push/pop
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for(int i=0; i<N; i++){
      int num = Integer.parseInt(br.readLine());
      if(num == 0) st.pop();
      else
        st.push(num);
    }

    //stack을 비우며 정답에 더하기
    int answer = 0;
    while(!st.empty())
      answer += st.pop();

    //출력
    System.out.println(answer);
    br.close();
  }
}