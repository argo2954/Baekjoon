import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      long T = Long.parseLong(br.readLine());

      for(long l=1l; l<=T; l++){
        String[] AB = br.readLine().split(" ");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);

        bw.write("Case #" + l + ": " + (A+B) + "\n");
      }

      bw.flush();
      br.close();
      bw.close();
    }
}