class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = 'a';
        int same = 0;
        int notSame = 0;
        
        int len = s.length();
        for(int i=0; i<len; i++){
            if(same == 0){
                x = s.charAt(i);
                same = 1;
                continue;
            }
            else if(x == s.charAt(i)){
                same++;
            }
            else{
                notSame++;
            }
            
            
            if(same == notSame){
                answer++;
                same = notSame = 0;
            }
        }
        
        if(same != 0)
            answer++;
        
        return answer;
    }
}