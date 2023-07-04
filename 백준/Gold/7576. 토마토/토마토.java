import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[][] storage;

    // MAIN FUNCTION //
    public static void main(String[] args) throws IOException {
        input();
        Graph g = new Graph(n, m);
        g.setAdjacent();
        System.out.println(g.find());
    }

    // INPUT FUNCTION //
    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        storage = new int[n][m];
        for (int i = 0; i < n; i++) {
        String[] line = br.readLine().split(" ");
        for (int j = 0; j < m; j++) {
            storage[i][j] = Integer.parseInt(line[j]); 
        }
        }
    }

    // GRAPH //
    static class Graph {
        class Node {
            int day;
            LinkedList<Node> adjacent;

            Node(int day){
                this.day = day;
                adjacent = new LinkedList<Node>();
            } // Node initial
        } // Node class

        Node[][] nodes;
        int n, m;
        
        Graph(int n, int m) {
            this.n = n;
            this.m = m;
            nodes = new Node[n][m];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                int day = (storage[y][x]==-1)? -1: n*m;
                nodes[y][x] = new Node(day);
                }
            }
        } // Graph initial

        void addEdge(int y1, int x1, int y2, int x2) {
            if(y1<0 || x1<0 || y2<0 || x2<0) return;
            if(y1==n || x1==m || y2==n || x2==m) return;
            
            Node n1 = nodes[y1][x1];
            Node n2 = nodes[y2][x2];

            if (n1.day!=-1 && n2.day!=-1){
                n1.adjacent.add(n2);
                n2.adjacent.add(n1);
            }
        } // Node to node setting

        void setAdjacent() { // connect between nodes
            for(int y=0; y<n; y++){
                for(int x=0; x<m; x++){
                    if(storage[y][x] != -1){
                        addEdge(y, x, y+1, x);
                        addEdge(y, x, y-1, x);
                        addEdge(y, x, y, x+1);
                        addEdge(y, x, y, x-1);
                    }
                }
            }
        }// connect between nodes

        void BFS() {
            Queue<Node> queue = new LinkedList<Node>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(storage[i][j]==1){
                        Node root = nodes[i][j];
                        queue.offer(root);
                        root.day = 0;
                    }
                }
            }

            while (!queue.isEmpty()) {
                Node r = queue.peek();
                int rday = r.day;
                queue.remove();   
                for (Node n : r.adjacent) {
                    if (rday<n.day-1) {
                        n.day = rday+1;
                        queue.offer(n);
                    }
                }
            }
        }

        int find(){
        // bfs
        BFS();

        // find answer
        int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(nodes[i][j].day==n*m)
                        return -1;
                    if(nodes[i][j].day>answer)
                        answer = nodes[i][j].day;
                }
            }
        return answer;
        }
    }
}