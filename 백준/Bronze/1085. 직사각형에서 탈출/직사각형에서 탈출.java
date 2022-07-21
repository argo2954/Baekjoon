import java.io.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    //입력
    String[] input = in.readLine().split(" ");
    int x = Integer.parseInt(input[0]);
    int y = Integer.parseInt(input[1]);
    int w = Integer.parseInt(input[2]);
    int h = Integer.parseInt(input[3]);

    if(x>w/2) x = w-x;
    if(y>h/2) y = h-y;
    if(x>y) out.write(y + " ");
    else out.write(x + " ");
    
  
    in.close();
    out.close();
  }
}