import java.io.*;
import java.util.LinkedList;

class Main {
  static int n, m, k;
  static int[][] map;
  static LinkedList<Integer> answer = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    int T = Integer.parseInt(br.readLine());
    while(0 < T--){
      input();
      findGroup();
    }
    print();
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static void input() throws IOException {
    String[] s = br.readLine().split(" ");
    m = Integer.parseInt(s[0]); // Input m
    n = Integer.parseInt(s[1]); // Input m
    k = Integer.parseInt(s[2]); // Input m

    map = new int[n][m]; // For map
    for (int i = 0; i < k; i++) { // Input map
      String[] input = br.readLine().split(" ");
      int x = Integer.parseInt(input[0]);
      int y = Integer.parseInt(input[1]);
      map[y][x] = 1;
    }
  }

  static void findGroup() {
    int nm = n * m;
    int count = 0;
    for (int index = 0; index < nm; index++) { // rounds map to find 1
      int find10 = map[index / m][index % m];
      if (find10 == 1) { // If find 1 in map
        int r = dfs(index / m, index % m); // Call dfs function
        if(r>0) count++;
      }
    }
    answer.add(count);
  }

  static int dfs(int h, int w) {
    // Index of out range exception Or If this index was 0 in map
    if (h < 0 || w < 0 || h == n || w == m || map[h][w] == 0){ 
      return 0 ;
    }

    map[h][w] = 0;
    return 1+dfs(h - 1, w)+dfs(h + 1, w)+dfs(h, w - 1)+dfs(h, w + 1);
  }

  static void print() throws IOException {
    for (Integer i : answer)
      bw.write(i + "\n");
    bw.flush();
  }

}