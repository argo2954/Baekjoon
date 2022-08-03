class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        
        int sum = brown + yellow;
        for(int c=sum/2;c>0; c--){ //c=column
            if(sum%c!=0) continue;
            int r = sum/c; //row
            if((c-2)*(r-2) == yellow &&
              sum-(c-2)*(r-2) == brown){
                answer[0] = c;
                answer[1] = r;
                break;
            }
        }
        
        
        
        return answer;
    }
    
}