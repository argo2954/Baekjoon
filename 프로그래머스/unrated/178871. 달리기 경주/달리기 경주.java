import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++){
            int num1 = map.get(callings[i]);
            int num2 = num1-1;
            
            String s1 = players[num1];
            String s2 = players[num2];
            
            players[num1] = s2;
            players[num2] = s1;
            
            map.put(s1, num2);
            map.put(s2, num1);
        }
        
        answer = players;
        
        return answer;
    }
}