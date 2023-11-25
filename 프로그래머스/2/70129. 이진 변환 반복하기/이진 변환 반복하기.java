class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        
        while(s.length() != 1){
            int one = 0;
            for(String sub: s.split("")){
                if(sub.equals("0")) answer[1]++;         
                else one++;
            }
            s = Integer.toBinaryString(one);
            answer[0]++;
        }
        
        return answer;
    }
}