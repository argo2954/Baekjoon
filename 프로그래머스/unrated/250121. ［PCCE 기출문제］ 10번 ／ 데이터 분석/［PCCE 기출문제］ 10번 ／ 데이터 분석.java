import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int[][] answer = Arrays.stream(data)
            .filter(x -> x[map.get(ext)] < val_ext)
            .toArray(int[][]::new);
        
        Arrays.sort(answer, (d1, d2) ->{
           return d1[map.get(sort_by)]-d2[map.get(sort_by)];
        });
        
        return answer;
    }
}