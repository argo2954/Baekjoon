import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for(int num: nums){
            if(!hash.containsKey(num)){
                hash.put(num, 1);
            }
        }
        
            
        
        return Math.min(nums.length/2, hash.size());
    }
}