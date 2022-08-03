import java.util.*;
class Solution {
    public static final int MAX = 10000000;
    public static boolean[] check = new boolean[MAX];
    public static boolean[] flag;
    public static String input;
    public static int len, answer;
    
    public int solution(String numbers) {
        input = numbers;
        len = numbers.length();
        
        f1();
        flag = new boolean[len];
        f2("0");
              
        return answer;
    }
    //에라토스테네스의 체
    //true = 소수X    false = 소수O
    public static void f1(){
        check[0] = check[1] = true;
        for(int i=2; i*i<=MAX; i++){
            if(check[i]) continue;
            for(int j=i+i; j<MAX; j+=i){
                check[j] = true;
            }
        }
    }
    //조합 function
    public static void f2(String s){
        if(s.length()>len+1) return;
        if(!check[Integer.parseInt(s)]){
            check[Integer.parseInt(s)] = true;
            answer++;
        }
        for(int i=0; i<len; i++){
            if(!flag[i]){
                flag[i] = true;
                f2(s+input.charAt(i));
                flag[i] = false;
            }
        }
    }
}