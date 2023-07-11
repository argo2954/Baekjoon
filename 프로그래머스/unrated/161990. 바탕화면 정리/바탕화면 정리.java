class Solution {
    public int[] solution(String[] wallpaper) {        
        int len1 = wallpaper.length;
        int len2 = wallpaper[0].length();
        
        int[] answer = {len1, len2, 0, 0};
        
        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(answer[0]>=i)
                        answer[0] = i;
                    if(answer[1]>=j)
                        answer[1] = j;
                    if(answer[2]<=i)
                        answer[2] = i+1;
                    if(answer[3]<=j)
                        answer[3] = j+1;
                }
            }
        }
        
        return answer;
    }
}