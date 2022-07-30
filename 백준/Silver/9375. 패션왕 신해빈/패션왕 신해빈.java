import java.io.*;
import java.util.*;
class Main {
  static int answer = 1;
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(in.readLine());
    while(T-->0){
      int n = Integer.parseInt(in.readLine());
      Map<String, Integer> map = new LinkedHashMap<String, Integer>();
      while(n-->0){
        String[] s = in.readLine().split(" ");
        if(map.containsKey(s[1]))
          map.put(s[1], map.get(s[1]) +1);
        else
          map.put(s[1], 1);
      }
      map.forEach((key, value) -> {answer *= value+1;});
      out.write(answer-1 + "\n");
      answer = 1;
    }
    
    in.close();
    out.close();
  }
}