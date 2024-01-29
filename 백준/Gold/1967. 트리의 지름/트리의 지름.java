import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    /**
     * 10000개의 노드가 존재.
     * 5000 -> 5000 이므로
     * 5000개 시작을 체크하면 시간초과남
     * 루트부터 시작해서 최장 거리 찾기 -> dfs
     * 최장거리의 끝부터 다시 최장거리 찾기 -> dfs
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Graph g = new Graph(size);

        for(int i=1; i<size; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());

            g.setAdjacent(n1, n2, w);
        }

        int startNodeNumber = g.dfs(1);
        g.clear();
        int endNodeNumber = g.dfs(startNodeNumber);
        System.out.println(g.nodes[endNodeNumber].length);
    }

    static class Graph{
        class Node{
            int index;
            int length;
            boolean marked;
            List<Node> adjacent;
            List<Integer> weight;

            Node(int index){
                this.index = index;
                length = 0;
                marked = false;
                adjacent = new LinkedList<>();
                weight = new LinkedList<>();
            }
        }

        int size;
        Node[] nodes;
        Graph(int size){
            this.size = ++size;
            nodes = new Node[size];
            for(int i=0; i<size; i++){
                nodes[i] = new Node(i);
            }
        }

        void setAdjacent(int i1, int i2, int weight){
            Node node1 = nodes[i1];
            Node node2 = nodes[i2];

            node1.adjacent.add(node2);
            node1.weight.add(weight);
            node2.adjacent.add(node1);
            node2.weight.add(weight);
        }

        int dfs(int root){
            Node rootNode = nodes[root];
            rootNode.marked = true;

            Stack<Node> stack = new Stack<>();
            stack.push(rootNode);

            while(!stack.isEmpty()){
                Node node = stack.pop();
                int len = node.adjacent.size();

                for(int i=0; i<len; i++){
                    Node cNode = node.adjacent.get(i);

                    if(!cNode.marked){
                        cNode.marked = true;
                        cNode.length += node.length + node.weight.get(i);
                        stack.push(cNode);
                    }
                }
            }

            int index = 0;
            int maxLength = 0;
            for(int i=1; i<size; i++){
                if(maxLength < nodes[i].length){
                    index = i;
                    maxLength = nodes[i].length;
                }
            }

            return index;
        }

        void clear(){
            for(int i=1; i<size; i++){
                nodes[i].length = 0;
                nodes[i].marked = false;
            }
        }
    }
}
