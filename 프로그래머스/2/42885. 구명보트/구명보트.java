import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int low = 0;
        for(int i=people.length-1; i>=low; i--){
            if(people[i] + people[low] <= limit){
                answer++;
                low++;
            }else{
                answer++;
            }
        }
        
        return answer;
    }
}