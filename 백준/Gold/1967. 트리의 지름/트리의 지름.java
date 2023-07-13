import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        inputAndInit();
        System.out.println(length[dfs(dfs(1))]);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static LinkedList<Integer>[] nodes;
    static LinkedList<Integer>[] weights;
    static int[] length;
    static boolean[] marked;
    static int N;
    
    
    static void inputAndInit() throws IOException{
        N = Integer.parseInt(br.readLine());
        marked = new boolean[N+1];
        length = new int[N+1];

        nodes = new LinkedList[N+1];
        weights = new LinkedList[N+1];
        
        for(int i=0; i<=N; i++){
            nodes[i] = new LinkedList<>();
            weights[i] = new LinkedList<>();
        }
        
        for(int i=1; i<N; i++){
            String s = br.readLine();
            StringTokenizer token = new StringTokenizer(s);
            int p = Integer.parseInt(token.nextToken());    // parent
            int c = Integer.parseInt(token.nextToken());    // child
            int w = Integer.parseInt(token.nextToken());    // weight
            
            nodes[p].add(c);
            nodes[c].add(p);
            
            weights[p].add(w);
            weights[c].add(w);
        }
    }
    
    static int dfs(int root){
        clear();

        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        marked[root] = true;

        while(!stack.isEmpty()){
            int index = stack.pop();
            int len = nodes[index].size();

            for(int i=0; i<len; i++){
                int node = nodes[index].get(i);
                if(!marked[node]){
                    marked[node] = true;
                    stack.push(node);

                    length[node] += length[index] + weights[index].get(i);
                }
            }
        }

        int len = 0;
        int index = 0;
        for(int i=0; i<=N; i++){
            if(len<length[i]){
                len = length[i];
                index = i;
            }
        }
        
        return index;
    }


    static void clear(){
        for(int i=0; i<=N; i++){
            marked[i] = false;
            length[i] = 0;
        }
    }
}
