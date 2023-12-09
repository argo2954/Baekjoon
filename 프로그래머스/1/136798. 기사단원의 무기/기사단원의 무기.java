class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] divisors = new int[number+1];
        
        for(int i=1; i<=number; i++){
            for(int j=1; j<=number; j++){
                if(i*j > number){
                    break;
                }
                
                divisors[i*j]++;
            }
        }
        
        for(int i=1; i<=number; i++){
            if(divisors[i] <= limit)
                answer += divisors[i];
            else
                answer += power;
        }
        
        return answer;
    }
}