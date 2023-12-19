import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    while(true){
      String str = br.readLine();
      if(str.equals(".")) break;
      
      Stack<Character> st = new Stack<>();

      boolean check = true;
      for(char c: str.toCharArray()){
        if(c=='[' || c=='('){
          st.push(c);
        }
        else if(c==']' || c==')'){
          if(st.isEmpty()){
            check = false;
            break;
          }
          
          if(c==']' && st.peek()=='['){
            st.pop();
          }
          else if(c==')' && st.peek()=='('){
            st.pop();
          }
          else{
            check = false;
            break;
          }
        }
      }
      if(st.isEmpty() && check) 
        System.out.println("yes");
      else
        System.out.println("no");
    }
  }
}