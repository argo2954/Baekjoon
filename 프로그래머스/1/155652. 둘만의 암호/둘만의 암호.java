import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        List<Character> alphabets = new ArrayList<>();
        for(char c='a'; c<='z'; c++){
            if(skip.indexOf(c) == -1){
                alphabets.add(c);
            }
        }
        
        int len = s.length();
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            
            int pass = alphabets.indexOf(c) + index;
            
            while(pass >= alphabets.size()){
                pass -= alphabets.size();
            }
            
            answer += alphabets.get(pass);
        }
        
        return answer;
    }
}