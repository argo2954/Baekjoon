class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        // 구역 세팅
        boolean[] wall = new boolean[n];
        for(int part: section){
            wall[part-1] = true;
        }
        
        // 페인팅
        for(int i=0; i<n; i++){
            if(wall[i]){
                for(int j=i; j<i+m; j++){
                    if(j>=n) break;
                    wall[j] = false;
                }
                answer++;
            }
        }
        
        
        return answer;
    }
}