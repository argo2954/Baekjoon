import java.io.*;
import java.util.LinkedList;
import java.util.Collections;

class Main {
  static int n, max;
  static int[][] map;
  static LinkedList<Integer> answer = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    input();
    findGroup();
    print();
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine()); // Input n

    map = new int[n][n]; // For map
    for (int i = 0; i < n; i++) { // Input map
      String[] input = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(input[j]);
      }
    }
  }

  static void findGroup() {
    int nn = n * n;
    for (int index = 0; index < nn; index++) { // rounds map to find 1
      int find10 = map[index / n][index % n];
      if (find10 == 1) { // If find 1 in map
        max = 0;
        dfs(index / n, index % n); // Call dfs function
        answer.add(max);
      }
    }
  }

  static void dfs(int h, int w) {
    // Index of out range exception Or If this index was 0 in map
    if (h < 0 || w < 0 || h == n || w == n || map[h][w] == 0){ 
      return;
    }

    map[h][w] = 0;
    max++;
    dfs(h - 1, w);
    dfs(h + 1, w);
    dfs(h, w - 1);
    dfs(h, w + 1);
  }

  static void print() throws IOException {
    System.out.println(answer.size());
    Collections.sort(answer);
    for (Integer i : answer)
      System.out.println(i);
  }

}