import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<String, Integer> map = new HashMap<>();
        for(String key: keymap){
            int index = 1;
            for(String str: key.split("")){
                if(map.containsKey(str)){
                    map.put(str, Math.min(index, map.get(str)));
                }
                else{
                    map.put(str, index);
                }
                index++;
            }
        }
        
        for(int i=0; i<targets.length; i++){
            for(String str: targets[i].split("")){
                if(!map.containsKey(str)){
                    answer[i] = -1;
                    break;
                }
                answer[i] += map.get(str);
            }
        }
        
        return answer;
    }
}