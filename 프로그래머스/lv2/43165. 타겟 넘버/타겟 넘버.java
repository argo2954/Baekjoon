class Solution {
    public int solution(int[] numbers, int target) {
        Graph g = new Graph(numbers, target);
        g.dfs(0, 0);
        
        return g.answer;
    }
    
    class Graph{
        int[] numbers;
        int end;
        int target;
        int answer = 0;
        
        Graph(int[] numbers, int target){
            this.numbers = numbers;
            this.target = target;
            end = numbers.length;
        }
        
        void dfs(int sum, int index){
            if(index == end){
                if(sum==target)
                    answer++;
                return;
            }
            dfs(sum+numbers[index], index+1);
            dfs(sum-numbers[index], index+1);
        }
    }
}