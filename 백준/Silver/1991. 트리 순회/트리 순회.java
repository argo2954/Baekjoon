import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        Tree T = new Tree(N);

        for(int i=0; i<N; i++){
            char[] carr = br.readLine().replace(" ", "").toCharArray();
            T.setChild(carr[0], carr[1], carr[2]);
        }

        T.pre(0);
        bw.newLine();
        T.mid(0);
        bw.newLine();
        T.post(0);
        bw.newLine();
        bw.flush();
    }

    static class Tree{
        class Node{
            int data;
            Node left;
            Node right;

            Node(int data){
                this.data = data;
            }
        }

        Node[] nodes;
        Tree(int size){
            nodes = new Node[size];
            for(int i=0; i<size; i++)
                nodes[i] = new Node(i);
        }

        void setChild(char parent, char c1, char c2){
            Node n = nodes[parent-'A'];

            if(c1!='.'){
                Node n1 = nodes[c1-'A'];
                n.left = n1;
            }
            if(c2!='.'){
                Node n2 = nodes[c2-'A'];
                n.right = n2;
            }
        }

        void pre(int i) throws Exception{
            Node now = nodes[i];
            bw.write(now.data+'A');

            if(now.left != null)
                pre(now.left.data);

            if(now.right != null)
                pre(now.right.data);
        }

        void mid(int i) throws Exception{
            Node now = nodes[i];

            if(now.left != null)
                mid(now.left.data);

            bw.write(now.data+'A');

            if(now.right != null)
                mid(now.right.data);
        }

        void post(int i) throws Exception{
            Node now = nodes[i];

            if(now.left != null)
                post(now.left.data);

            if(now.right != null)
                post(now.right.data);

            bw.write(now.data+'A');
        }
    }
}

        
