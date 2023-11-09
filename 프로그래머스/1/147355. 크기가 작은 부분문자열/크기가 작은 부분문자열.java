class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int tLen = t.length();
        int pLen = p.length();
        
        long pLong = Long.parseLong(p);
        
        for(int i=0; i<tLen-pLen+1; i++){
            String substring = t.substring(i, i+pLen);
            long subLong = Long.parseLong(substring);
            
            if(subLong <= pLong)
                answer++;
        }
        return answer;
    }
}