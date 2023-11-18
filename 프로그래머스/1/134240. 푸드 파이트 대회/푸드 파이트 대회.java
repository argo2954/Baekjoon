class Solution {
    public String solution(int[] food) {
        String answer = "";
        int len = food.length;
        
        String left = "";
        String right = "";
        
        for(int i=1; i<len; i++){
            left += (i+"").repeat(food[i]/2);
            right += (len-i+"").repeat(food[len-i]/2);
        }
        
        return left +"0"+right;
    }
}