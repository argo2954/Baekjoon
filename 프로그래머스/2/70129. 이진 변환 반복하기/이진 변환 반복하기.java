class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        
        while(s.length() != 1){
            int oldLength = s.length();
            int newLength = s.replaceAll("0", "").length();
            
            answer[0]++;
            answer[1] += oldLength - newLength;
            
            s = Integer.toBinaryString(newLength);
        }
        
        return answer;
    }
}