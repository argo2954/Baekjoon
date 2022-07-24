import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
      // 입력
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(in.readLine());
    while(T-- > 0){
      String[] input = in.readLine().split(" ");
      int x1 = Integer.parseInt(input[0]);
      int y1 = Integer.parseInt(input[1]);
      int x2 = Integer.parseInt(input[2]);
      int y2 = Integer.parseInt(input[3]);
      int n = Integer.parseInt(in.readLine());
      int answer = 0;
      while(n-->0){
        String[] input2 = in.readLine().split(" ");
        int cx = Integer.parseInt(input2[0]);
        int cy = Integer.parseInt(input2[1]);
        int r = Integer.parseInt(input2[2]);

        //출발점 or 도착점중 한 곳만 행성 안에 있으면 answer++
        if((x1-cx)*(x1-cx)+(y1-cy)*(y1-cy) < r*r &&
          (x2-cx)*(x2-cx)+(y2-cy)*(y2-cy) > r*r)
          answer++;
        else if((x2-cx)*(x2-cx)+(y2-cy)*(y2-cy) < r*r &&
          (x1-cx)*(x1-cx)+(y1-cy)*(y1-cy) > r*r)
          answer++;
      
      }
      out.write(answer + "\n");
    }
    
    in.close();
    out.close();
  }
}