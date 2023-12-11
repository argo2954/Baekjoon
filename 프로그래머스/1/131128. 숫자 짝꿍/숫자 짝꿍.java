import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        int[] x = new int[10];
        int[] y = new int[10];
        
        int xLen = X.length();
        int yLen = Y.length();
        int len = Math.max(xLen, yLen);
        
        for(int i=0; i<len; i++){
            if(i<xLen){
                int num = X.charAt(i)-'0';
                x[num]++;
            }
            if(i<yLen){
                int num = Y.charAt(i)-'0';
                y[num]++;
            }
            
        }
    
        
        for(int i=9; i>=0; i--){
            int min = Math.min(x[i], y[i]);
            
            answer += (""+i).repeat(min);
        }
        
        if(answer.length()==0)
            return "-1";
        else if(answer.indexOf("0") == 0)
            return "0";
        return answer;
    }
}