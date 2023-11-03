import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      // input| stk->StringTokenizer, 
      StringTokenizer stk = new StringTokenizer(br.readLine());

      // solve| asc, desc를 위한 boolean을 통해 체크
      boolean asc = false, desc = false;
      String previous = stk.nextToken();;
      while(stk.hasMoreTokens()){
        String current = stk.nextToken();
        
        if(current.compareTo(previous)>0) 
          asc=true;
        else
          desc=true;
        previous = current;
      }

      if(asc == desc)
        System.out.println("mixed");
      else if(asc)
        System.out.println("ascending");
      else
        System.out.println("descending");
        
    }
}