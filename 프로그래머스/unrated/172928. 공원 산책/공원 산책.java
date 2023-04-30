class Solution {
    int h, w;
    int[] current = new int[2];
    String[] map;
    public int[] solution(String[] park, String[] routes) {
        h = park.length;
        w = park[0].length();
        map = park;
        for(int i=0; i<h*w; i++){
            if(park[i/w].charAt(i%w) == 'S'){
                current[0] = i/w;
                current[1] = i%w;
                break;
            }
        }
        
        for(String s: routes){
            switch(s.charAt(0)){
                case 'E':
                    goE(s.charAt(2) - '0');
                    break;
                case 'W':
                    goW(s.charAt(2) - '0');
                    break;
                case 'N':
                    goN(s.charAt(2) - '0');
                    break;
                case 'S':
                    goS(s.charAt(2) - '0');
                    break;
            }
        }
        
        
        return current;
    }
    
    
    void goE(int index){
        int cH = current[0];
        int cW = current[1];
        if(cW+index >= w) return;
        else{
            for(int i=1; i<=index; i++){
                if(map[cH].charAt(cW+i) == 'X') return;
            }
        }
        current[1] += index;
        System.out.println(current[0] +" " +current[1]);
    }
    
    void goW(int index){
        int cH = current[0];
        int cW = current[1];
        if(cW-index < 0) return;
        else{
            for(int i=1; i<=index; i++){
                if(map[cH].charAt(cW-i) == 'X') return;
            }
        }
        current[1] -= index;
        System.out.println(current[0] +" " +current[1]);
        
    }
    
    void goS(int index){
        int cH = current[0];
        int cW = current[1];
        if(cH+index >= h) return;
        else{
            for(int i=1; i<=index; i++){
                if(map[cH+i].charAt(cW) == 'X') return;
            }
        }
        current[0] += index;
        System.out.println(current[0] +" " +current[1]);
        
    }
    
    void goN(int index){
        int cH = current[0];
        int cW = current[1];
        if(cH-index < 0) return;
        else{
            for(int i=1; i<=index; i++){
                if(map[cH-i].charAt(cW) == 'X') return;
            }
        }
        current[0] -= index;
        System.out.println(current[0] +" " +current[1]);
        
    }
}