class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n>=a){
            int cola = n/a*b;
            
            n = n%a + cola;
            
            answer += cola;
        }
        return answer;
    }
}