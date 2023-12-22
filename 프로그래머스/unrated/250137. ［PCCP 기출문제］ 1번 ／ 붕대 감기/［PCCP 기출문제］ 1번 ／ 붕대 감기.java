class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int life = health;
        int index = 0;
        int heal = 0;
        
        for(int start = 1; start<=attacks[attacks.length-1][0]; start++){
            // 공격 받은 경우
            if(start == attacks[index][0]){
                life -= attacks[index][1];
                heal = 0;
                if(life <= 0){
                    return -1;
                }
                
                index++;
            }
            // 아닌 경우
            else{
                life += bandage[1];
                heal++;
                if(heal == bandage[0]){
                    life += bandage[2];
                    heal = 0;
                }
            
                life = Math.min(life, health);
            }
            
        }
        
        
        return life;
    }
}