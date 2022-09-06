import java.io.*;

class Main {
  // N명 중 N/2명을 백트레킹으로 정해
  // 능력치 비교
  public static void main(String[] args) throws IOException {
    init();
    f(0, 0);
    // 출력
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(min + "\n");
    bw.close();
  }

  // 전역변수
  static int min = 18000; // 최대값 = 100 * 10 * 9
  static int n;
  static int[][] arr;
  static boolean[] b;
  // 초기화 함수(입력)
  public static void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // N입력
    n = Integer.parseInt(br.readLine());
    b = new boolean[n];
    // NxN 배열 입력
    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      String[] s = br.readLine().split(" ");
      for (int j = 0; j < n; j++)
        arr[i][j] = Integer.parseInt(s[j]);
    }

    br.close();
  }

  // 백트래킹 함수
  // depth = 현재 깊이, 현재깊이와 n/2가 같을 경우 능력치를 구해 비교함
  public static void f(int depth, int cur) {
    // 팀을 구한경우
    if (depth == n / 2) {
      ability();
      return;
    }
    // 연산
    for (int i = cur; i < n; i++) {
      if (!b[i]){
        b[i] = true;
        f(depth + 1, i + 1);
        b[i] = false;
      }
    }
  }

  // 능력치 구하는 함수
  public static void ability() {
    int start = 0;
    int link = 0;
    // 능력치 구하기
    for(int i=0; i<n-1; i++){
      for(int j=i+1; j<n; j++){
        if(b[i] && b[j])
          start += arr[i][j] + arr[j][i];
        if(!b[i] && !b[j])
          link += arr[i][j] + arr[j][i];
      }
    }
    // min 결정
    int abs = Math.abs(start-link);
    if(abs<min) min = abs;
  }
}