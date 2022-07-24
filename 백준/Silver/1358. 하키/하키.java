import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
      // 입력
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
      //첫줄 입력
      String[] input = in.readLine().split(" ");
      int w = Integer.parseInt(input[0]);
      int h = Integer.parseInt(input[1]);
      int x = Integer.parseInt(input[2]);
      int y = Integer.parseInt(input[3]);
      int p = Integer.parseInt(input[4]);
      int answer = p;

      //p개의 줄 입력 및 연산
      while(p-->0){
        String[] input2 = in.readLine().split(" ");
        int x_ = Integer.parseInt(input2[0]);
        int y_ = Integer.parseInt(input2[1]);

        //직사각형 안에 있는경우 continue
        if((x<=x_&&x_<=x+w)&&(y<=y_&&y_<=y+h)) continue;
        //왼쪽 반원에 속하는 경우 continue
        else if((x-x_)*(x-x_)+(y+h/2-y_)*(y+h/2-y_) <= h/2*h/2) continue;
        //오른쪽 반원에 속하는 경우 continue
        else if((x+w-x_)*(x+w-x_)+(y+h/2-y_)*(y+h/2-y_) <= h/2*h/2) continue;
        else answer--;
      }
    out.write(answer + "\n");
    
    in.close();
    out.close();
  }
}