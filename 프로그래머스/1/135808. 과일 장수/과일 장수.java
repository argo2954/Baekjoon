import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        int cnt = 0;
        for(int i=score.length-1; i>=0; i--){
            cnt++;
            if(cnt == m){
                answer += m*score[i];
                cnt = 0;
            }
        }
        
        return answer;
    }
}