class Solution {
    public int[] solution(String s) {
        int len = s.length();    
    
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
			for (int j = i; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j) && answer[i] == 0) {
					answer[i] = i - j;
					
				}
			}
			if (answer[i] == 0) {
				answer[i] = -1;
			}
		}
        
        return answer;
    }
}