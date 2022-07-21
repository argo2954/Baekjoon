import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();

    int answer = N;
    while(N-->0){
      boolean[] cmp = new boolean[26]; //기본 false, 알파벳이 나오면 true
      String s = in.next();
      cmp[s.charAt(0)-'a'] = true; //s의 첫 번째 알파벳에 해당하는 index = true

      boolean check = true;
      for(int i=1; i<s.length(); i++){//s 순회
        //해당되는 알파벳이 이 전에 나왔고, 직전 알파벳과 해당 알파벳이 다를경우
        //check = false 및 순회종료
        if(cmp[s.charAt(i)-'a'] & s.charAt(i) != s.charAt(i-1)){
          check = false; break;
        }
        //해당되는 알파벳이 이 전에 나오지 않았다면
        //알파벳에 해당되는 cmp = true
        else
          cmp[s.charAt(i)-'a'] = true;
      }
      if(!check) answer--;
    }

    System.out.println(answer);
  }
}