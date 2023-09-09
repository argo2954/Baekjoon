import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<String, Data> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(!map.containsKey(genres[i])){
                map.put(genres[i], new Data(i, plays[i]));
            }
            else{
                Data data = map.get(genres[i]);
                data.compare(i, plays[i]);
                
                map.put(genres[i], data);
            }
        }
        
        List<Map.Entry<String, Data>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(((o1, o2) -> o2.getValue().size - o1.getValue().size));
        
        for(Map.Entry<String, Data> entry : entryList){
            int[][] data = entry.getValue().id_play;
            
            answer.add(data[0][0]);
            if(data[1][1]!=0)
                answer.add(data[1][0]);
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    class Data{
        int size;
        int[][] id_play = new int[2][2];
        
        Data(int id, int play){
            size = play;
            id_play[0][0] = id;
            id_play[0][1] = play;
        }
        
        void compare(int id, int play){
            size += play;
            
            if(id_play[0][1]<play){
                int idT = id_play[0][0];
                int playT = id_play[0][1];
                
                id_play[0][0] = id;
                id_play[0][1] = play;
                
                id = idT;
                play = playT;
            }
            if(id_play[1][1]<play){
                id_play[1][0] = id;
                id_play[1][1] = play;
            }
        }
    }
}